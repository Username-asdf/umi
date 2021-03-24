package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Commentuser implements Serializable {
    private Long cuid;

    private Long userid;

    private Long commid;

    private Integer lorh;

    private static final long serialVersionUID = 1L;

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCommid() {
        return commid;
    }

    public void setCommid(Long commid) {
        this.commid = commid;
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
        Commentuser other = (Commentuser) that;
        return (this.getCuid() == null ? other.getCuid() == null : this.getCuid().equals(other.getCuid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCommid() == null ? other.getCommid() == null : this.getCommid().equals(other.getCommid()))
            && (this.getLorh() == null ? other.getLorh() == null : this.getLorh().equals(other.getLorh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCuid() == null) ? 0 : getCuid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCommid() == null) ? 0 : getCommid().hashCode());
        result = prime * result + ((getLorh() == null) ? 0 : getLorh().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cuid=").append(cuid);
        sb.append(", userid=").append(userid);
        sb.append(", commid=").append(commid);
        sb.append(", lorh=").append(lorh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}