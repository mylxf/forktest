package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.core.RepositoryContext;

import org.msdai.eerigo.service.domain.model.Resource;

import org.msdai.eerigo.service.domain.repository.ResourceRepository;

import org.msdai.eerigo.core.exception.RepositoryConcurrentModificationException;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 0:01
 */
public class ResourceMongoDBRepository implements ResourceRepository {

    private GridFsOperations fsOperations;

    public void setFsOperations(GridFsOperations fsOperations) {
        this.fsOperations = fsOperations;
    }

    @Override
    public RepositoryContext getContext() {
        return null;
    }

    @Override
    public void add(Resource item) throws RepositoryConcurrentModificationException {
        InputStream inputStream = new ByteArrayInputStream(item.getResourceContent());
        String fileName = UUID.randomUUID().toString();
        fsOperations.store(inputStream, fileName);
        item.setResourceUrl(fileName);
    }

    @Override
    public void remove(Resource item) throws RepositoryConcurrentModificationException {

    }

    @Override
    public void update(Resource item) throws RepositoryConcurrentModificationException {

    }

    @Override
    public Resource find(String id) {
        byte[] ioBuffer = new byte[1024];
        int readLen;
        InputStream inputStream = null;
        ByteArrayOutputStream result = null;
        try {
            inputStream = fsOperations.getResource(id).getInputStream();
            readLen = inputStream.read(ioBuffer);
            result = new ByteArrayOutputStream();
            while (readLen != -1) {
                result.write(ioBuffer, 0, readLen);
                readLen = inputStream.read(ioBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (result != null) {
            try {
                result.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Resource resource = new Resource();
        resource.setResourceUrl(id);
        assert result != null;
        resource.setResourceContent(result.toByteArray());
        return resource;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Resource> findAll() {
        return null;
    }
}
