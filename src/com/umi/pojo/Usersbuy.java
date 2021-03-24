package com.umi.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Usersbuy implements Serializable {
    private Long usersbuyid;

    private Long usersid;

    private Long postid;

    private Date buytime;

    private static final long serialVersionUID = 1L;

    public Long getUsersbuyid() {
        return usersbuyid;
    }

    public void setUsersbuyid(Long usersbuyid) {
        this.usersbuyid = usersbuyid;
    }

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Usersbuy other = (Usersbuy) that;
        return (this.getUsersbuyid() == null ? other.getUsersbuyid() == null : this.getUsersbuyid().equals(other.getUsersbuyid()))
            && (this.getUsersid() == null ? other.getUsersid() == null : this.getUsersid().equals(other.getUsersid()))
            && (this.getPostid() == null ? other.getPostid() == null : this.getPostid().equals(other.getPostid()))
            && (this.getBuytime() == null ? other.getBuytime() == null : this.getBuytime().equals(other.getBuytime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsersbuyid() == null) ? 0 : getUsersbuyid().hashCode());
        result = prime * result + ((getUsersid() == null) ? 0 : getUsersid().hashCode());
        result = prime * result + ((getPostid() == null) ? 0 : getPostid().hashCode());
        result = prime * result + ((getBuytime() == null) ? 0 : getBuytime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usersbuyid=").append(usersbuyid);
        sb.append(", usersid=").append(usersid);
        sb.append(", postid=").append(postid);
        sb.append(", buytime=").append(buytime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}