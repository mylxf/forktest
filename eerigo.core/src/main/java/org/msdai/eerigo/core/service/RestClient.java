package org.msdai.eerigo.core.service;

import org.msdai.eerigo.core.utils.JsonUtils;
import org.msdai.eerigo.core.utils.EncryptUtils;

import org.msdai.eerigo.core.exception.EerigoRestClientException;

import org.springframework.util.StringUtils;

import javax.ws.rs.core.MediaType;

import java.io.*;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

import java.util.Scanner;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:18
 */
public class RestClient {
    private String servicePath;

    public RestClient(String servicePath) {
        this.servicePath = servicePath;
        this.userName = "Shinspirit";
    }

    private String userName;

    public <T> T upload(String relativeURL, File file, Class<T> tClass) throws EerigoRestClientException {
        URL url = null;
        HttpURLConnection conn = null;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            url = new URL(servicePath + relativeURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            handleRequestHeader(conn, "POST");
            byte[] fByte = new byte[Long.valueOf(file.length()).intValue()];
            fileInputStream.read(fByte, 0, Long.valueOf(file.length()).intValue());
            OutputStream os = conn.getOutputStream();
            os.write(fByte);
            os.flush();
            handleWebResponse(conn);
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            return (T) JsonUtils.parseJson(br, tClass);
        } catch (Exception exception) {
            assert url != null;
            handleException(exception, url.toString());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public byte[] download(String relativeURL, Object object) throws EerigoRestClientException {
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(servicePath + relativeURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
            handleRequestHeader(conn, "POST");
            OutputStream os = conn.getOutputStream();
            os.write(JsonUtils.toJson(object).getBytes());
            os.flush();
            handleWebResponse(conn);
            byte[] ioBuffer = new byte[1024];
            InputStream inputStream = conn.getInputStream();
            int readLen = inputStream.read(ioBuffer);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            while (readLen != -1) {
                result.write(ioBuffer, 0, readLen);
                readLen = inputStream.read(ioBuffer);
            }
            inputStream.close();
            result.close();
            return result.toByteArray();
        } catch (Exception exception) {
            assert url != null;
            handleException(exception, url.toString());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public <T> T post(String relativeURL, Object object, Class<T> tClass) throws EerigoRestClientException {
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(servicePath + relativeURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
            handleRequestHeader(conn, "POST");
            OutputStream os = conn.getOutputStream();
            os.write(JsonUtils.toJson(object).getBytes());
            os.flush();
            handleWebResponse(conn);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "utf-8"));
            return JsonUtils.parseJson(br, tClass);
        } catch (Exception exception) {
            assert url != null;
            handleException(exception, url.toString());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public <T> T get(String relativeURL, Object[] objects, Class<T> tClass) throws EerigoRestClientException {
        StringBuilder param = new StringBuilder();
        for (Object obj : objects) {
            param.append("/");
            param.append(obj);
        }
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(servicePath + relativeURL + param.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", MediaType.APPLICATION_JSON);
            handleRequestHeader(conn, "GET");
            handleWebResponse(conn);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            return JsonUtils.parseJson(br, tClass);
        } catch (Exception exception) {
            assert url != null;
            handleException(exception, url.toString());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private void handleRequestHeader(HttpURLConnection connection, String operation) {
        if (connection != null) {
            try {
                String hour = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                String publicKey = "$1$r9smc0e1$";
                String sign = sign(this.userName, hour, publicKey);
                connection.setRequestMethod(operation);
                connection.setRequestProperty("x-user-acct", this.userName);
                connection.setRequestProperty("x-portal-timezone", hour);
                connection.setRequestProperty("x-portal-publickey", publicKey);
                connection.setRequestProperty("x-portal-sign", sign);
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
        }
    }

    private String sign(String userName, String hour, String key) {
        return EncryptUtils.md5Encrypt(userName + hour + key, key);
    }

    private void handleWebResponse(HttpURLConnection connection) throws EerigoRestClientException {
        try {
            int status = connection.getResponseCode();
            StringBuilder errorMessage = new StringBuilder();
            if (status != HttpURLConnection.HTTP_OK) {
                InputStream error = connection.getErrorStream();
                if (error != null) {
                    Scanner scanner = new Scanner(error);
                    while (scanner.hasNext()) {
                        errorMessage.append(scanner.next());
                    }
                }
                throw new EerigoRestClientException(connection.getURL().toString(), status,
                        StringUtils.isEmpty(errorMessage.toString()) ? connection.getResponseMessage() : errorMessage.toString());
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    private void handleException(Exception exception, String url) throws EerigoRestClientException {
        if (!(exception instanceof EerigoRestClientException)) {
            throw new EerigoRestClientException(url, 500, exception.getMessage());
        }
        throw new EerigoRestClientException(exception);
    }
}
