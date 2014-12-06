package org.msdai.eerigo.service.domain.core;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 3/31/14
 * Time: 5:26 PM
 * 实体接口
 */
public interface Entity extends Serializable {

    /**
     * 实体的全局唯一标识设置
     */
    void setId(String id);

    /**
     * 获取实体的全局唯一标识
     */
    String getId();

    /**
     * 获取实体的唯一全局锁标识
     */
    String getSeq();

    /**
     * 设置实体的唯一全局锁标识
     */
    void updateSeq();

    /**
     * 获取实体的唯一全局创建人
     */
    String getCreDate();

    /**
     * 获取实体的唯一全局创建时间
     */
    String getCreUser();

}
