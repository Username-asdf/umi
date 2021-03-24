package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class RequestWithBLOBs extends Request implements Serializable {
    private String title;

    private String descinfo;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
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
        RequestWithBLOBs other = (RequestWithBLOBs) that;
        return (this.getRequestid() == null ? other.getRequestid() == null : this.getRequestid().equals(other.getRequestid()))
            && (this.getUsersid() == null ? other.getUsersid() == null : this.getUsersid().equals(other.getUsersid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getAccpet() == null ? other.getAccpet() == null : this.getAccpet().equals(other.getAccpet()))
            && (this.getFinish() == null ? other.getFinish() == null : this.getFinish().equals(other.getFinish()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescinfo() == null ? other.getDescinfo() == null : this.getDescinfo().equals(other.getDescinfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRequestid() == null) ? 0 : getRequestid().hashCode());
        result = prime * result + ((getUsersid() == null) ? 0 : getUsersid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getAccpet() == null) ? 0 : getAccpet().hashCode());
        result = prime * result + ((getFinish() == null) ? 0 : getFinish().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescinfo() == null) ? 0 : getDescinfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", title=").append(title);
        sb.append(", descinfo=").append(descinfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}