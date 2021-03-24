package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Likeandhaterecord implements Serializable {
    private Long lhid;

    private Long postid;

    private Long usersid;

    private Integer lorh;

    private static final long serialVersionUID = 1L;

    public Long getLhid() {
        return lhid;
    }

    public void setLhid(Long lhid) {
        this.lhid = lhid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public Integer getLorh() {
        return lorh;
    }

    public void setLorh(Integer lorh) {
        this.lorh = lorh;
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
        Likeandhaterecord other = (Likeandhaterecord) that;
        return (this.getLhid() == null ? other.getLhid() == null : this.getLhid().equals(other.getLhid()))
            && (this.getPostid() == null ? other.getPostid() == null : this.getPostid().equals(other.getPostid()))
            && (this.getUsersid() == null ? other.getUsersid() == null : this.getUsersid().equals(other.getUsersid()))
            && (this.getLorh() == null ? other.getLorh() == null : this.getLorh().equals(other.getLorh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLhid() == null) ? 0 : getLhid().hashCode());
        result = prime * result + ((getPostid() == null) ? 0 : getPostid().hashCode());
        result = prime * result + ((getUsersid() == null) ? 0 : getUsersid().hashCode());
        result = prime * result + ((getLorh() == null) ? 0 : getLorh().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lhid=").append(lhid);
        sb.append(", postid=").append(postid);
        sb.append(", usersid=").append(usersid);
        sb.append(", lorh=").append(lorh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}