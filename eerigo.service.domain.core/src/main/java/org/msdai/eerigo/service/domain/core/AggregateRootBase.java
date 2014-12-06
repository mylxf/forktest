package org.msdai.eerigo.service.domain.core;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/1/14
 * Time: 2:05 PM
 */
public abstract class AggregateRootBase implements AggregateRoot {

    protected String id;
    protected String seq;
    protected String creUser;
    protected String creDate;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getSeq() {
        return seq;
    }

    @Override
    public void updateSeq() {
        this.seq = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (this == obj || obj instanceof AggregateRoot && this.id.equals((((AggregateRoot) obj).getId())));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String getCreDate() {
        return creDate;
    }

    public void setCreDate(String creDate) {
        this.creDate = creDate;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    @Override
    public String getCreUser() {
        return creUser;
    }


}