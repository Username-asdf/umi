package com.umi.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Report implements Serializable {
    private Long reportid;

    private Long postid;

    private Long usersid;

    private Integer ischeck;

    private Date reporttime;

    private String cause;

    private static final long serialVersionUID = 1L;

    public Long getReportid() {
        return reportid;
    }

    public void setReportid(Long reportid) {
        this.reportid = reportid;
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

    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
        Report other = (Report) that;
        return (this.getReportid() == null ? other.getReportid() == null : this.getReportid().equals(other.getReportid()))
            && (this.getPostid() == null ? other.getPostid() == null : this.getPostid().equals(other.getPostid()))
            && (this.getUsersid() == null ? other.getUsersid() == null : this.getUsersid().equals(other.getUsersid()))
            && (this.getIscheck() == null ? other.getIscheck() == null : this.getIscheck().equals(other.getIscheck()))
            && (this.getReporttime() == null ? other.getReporttime() == null : this.getReporttime().equals(other.getReporttime()))
            && (this.getCause() == null ? other.getCause() == null : this.getCause().equals(other.getCause()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReportid() == null) ? 0 : getReportid().hashCode());
        result = prime * result + ((getPostid() == null) ? 0 : getPostid().hashCode());
        result = prime * result + ((getUsersid() == null) ? 0 : getUsersid().hashCode());
        result = prime * result + ((getIscheck() == null) ? 0 : getIscheck().hashCode());
        result = prime * result + ((getReporttime() == null) ? 0 : getReporttime().hashCode());
        result = prime * result + ((getCause() == null) ? 0 : getCause().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportid=").append(reportid);
        sb.append(", postid=").append(postid);
        sb.append(", usersid=").append(usersid);
        sb.append(", ischeck=").append(ischeck);
        sb.append(", reporttime=").append(reporttime);
        sb.append(", cause=").append(cause);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}