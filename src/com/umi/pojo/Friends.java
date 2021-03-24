package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Friends implements Serializable {
    private Long fid;

    private Long beattenduserid;

    private Long attenduserid;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getBeattenduserid() {
        return beattenduserid;
    }

    public void setBeattenduserid(Long beattenduserid) {
        this.beattenduserid = beattenduserid;
    }

    public Long getAttenduserid() {
        return attenduserid;
    }

    public void setAttenduserid(Long attenduserid) {
        this.attenduserid = attenduserid;
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
        Friends other = (Friends) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getBeattenduserid() == null ? other.getBeattenduserid() == null : this.getBeattenduserid().equals(other.getBeattenduserid()))
            && (this.getAttenduserid() == null ? other.getAttenduserid() == null : this.getAttenduserid().equals(other.getAttenduserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getBeattenduserid() == null) ? 0 : getBeattenduserid().hashCode());
        result = prime * result + ((getAttenduserid() == null) ? 0 : getAttenduserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", beattenduserid=").append(beattenduserid);
        sb.append(", attenduserid=").append(attenduserid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}