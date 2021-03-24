package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Commentreport implements Serializable {
    private Long crid;

    private Long userid;

    private Long commid;

    private String reason;

    private static final long serialVersionUID = 1L;

    public Long getCrid() {
        return crid;
    }

    public void setCrid(Long crid) {
        this.crid = crid;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        Commentreport other = (Commentreport) that;
        return (this.getCrid() == null ? other.getCrid() == null : this.getCrid().equals(other.getCrid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCommid() == null ? other.getCommid() == null : this.getCommid().equals(other.getCommid()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCrid() == null) ? 0 : getCrid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCommid() == null) ? 0 : getCommid().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", crid=").append(crid);
        sb.append(", userid=").append(userid);
        sb.append(", commid=").append(commid);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}