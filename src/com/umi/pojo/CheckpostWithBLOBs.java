package com.umi.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class CheckpostWithBLOBs extends Checkpost implements Serializable {
    private String displayinfo;

    private String hiddeninfo;

    private String resourceaddr;

    private String postname;

    private static final long serialVersionUID = 1L;

    public String getDisplayinfo() {
        return displayinfo;
    }

    public void setDisplayinfo(String displayinfo) {
        this.displayinfo = displayinfo;
    }

    public String getHiddeninfo() {
        return hiddeninfo;
    }

    public void setHiddeninfo(String hiddeninfo) {
        this.hiddeninfo = hiddeninfo;
    }

    public String getResourceaddr() {
        return resourceaddr;
    }

    public void setResourceaddr(String resourceaddr) {
        this.resourceaddr = resourceaddr;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
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
        CheckpostWithBLOBs other = (CheckpostWithBLOBs) that;
        return (this.getPostid() == null ? other.getPostid() == null : this.getPostid().equals(other.getPostid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getSortid() == null ? other.getSortid() == null : this.getSortid().equals(other.getSortid()))
            && (this.getPoint() == null ? other.getPoint() == null : this.getPoint().equals(other.getPoint()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getDisplayinfo() == null ? other.getDisplayinfo() == null : this.getDisplayinfo().equals(other.getDisplayinfo()))
            && (this.getHiddeninfo() == null ? other.getHiddeninfo() == null : this.getHiddeninfo().equals(other.getHiddeninfo()))
            && (this.getResourceaddr() == null ? other.getResourceaddr() == null : this.getResourceaddr().equals(other.getResourceaddr()))
            && (this.getPostname() == null ? other.getPostname() == null : this.getPostname().equals(other.getPostname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostid() == null) ? 0 : getPostid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getSortid() == null) ? 0 : getSortid().hashCode());
        result = prime * result + ((getPoint() == null) ? 0 : getPoint().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getDisplayinfo() == null) ? 0 : getDisplayinfo().hashCode());
        result = prime * result + ((getHiddeninfo() == null) ? 0 : getHiddeninfo().hashCode());
        result = prime * result + ((getResourceaddr() == null) ? 0 : getResourceaddr().hashCode());
        result = prime * result + ((getPostname() == null) ? 0 : getPostname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", displayinfo=").append(displayinfo);
        sb.append(", hiddeninfo=").append(hiddeninfo);
        sb.append(", resourceaddr=").append(resourceaddr);
        sb.append(", postname=").append(postname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}