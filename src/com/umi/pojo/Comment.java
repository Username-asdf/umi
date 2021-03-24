package com.umi.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Comment implements Serializable {
    private Long commid;

    private Long postid;

    private Long fkcommid;

    private Long userid;

    private Date sendtime;

    private Long reportnum;

    private Long likenum;

    private Long hatenum;

    private String comm;
    
    private String username;
    
    private String usericon;
    
    private int lOrH;

	public int getlOrH() {
		return lOrH;
	}

	public void setlOrH(int lOrH) {
		this.lOrH = lOrH;
	}

	private static final long serialVersionUID = 1L;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsericon() {
		return usericon;
	}

	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}

	public Long getCommid() {
        return commid;
    }

    public void setCommid(Long commid) {
        this.commid = commid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getFkcommid() {
        return fkcommid;
    }

    public void setFkcommid(Long fkcommid) {
        this.fkcommid = fkcommid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Long getReportnum() {
        return reportnum;
    }

    public void setReportnum(Long reportnum) {
        this.reportnum = reportnum;
    }

    public Long getLikenum() {
        return likenum;
    }

    public void setLikenum(Long likenum) {
        this.likenum = likenum;
    }

    public Long getHatenum() {
        return hatenum;
    }

    public void setHatenum(Long hatenum) {
        this.hatenum = hatenum;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
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
        Comment other = (Comment) that;
        return (this.getCommid() == null ? other.getCommid() == null : this.getCommid().equals(other.getCommid()))
            && (this.getPostid() == null ? other.getPostid() == null : this.getPostid().equals(other.getPostid()))
            && (this.getFkcommid() == null ? other.getFkcommid() == null : this.getFkcommid().equals(other.getFkcommid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getSendtime() == null ? other.getSendtime() == null : this.getSendtime().equals(other.getSendtime()))
            && (this.getReportnum() == null ? other.getReportnum() == null : this.getReportnum().equals(other.getReportnum()))
            && (this.getLikenum() == null ? other.getLikenum() == null : this.getLikenum().equals(other.getLikenum()))
            && (this.getHatenum() == null ? other.getHatenum() == null : this.getHatenum().equals(other.getHatenum()))
            && (this.getComm() == null ? other.getComm() == null : this.getComm().equals(other.getComm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommid() == null) ? 0 : getCommid().hashCode());
        result = prime * result + ((getPostid() == null) ? 0 : getPostid().hashCode());
        result = prime * result + ((getFkcommid() == null) ? 0 : getFkcommid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getSendtime() == null) ? 0 : getSendtime().hashCode());
        result = prime * result + ((getReportnum() == null) ? 0 : getReportnum().hashCode());
        result = prime * result + ((getLikenum() == null) ? 0 : getLikenum().hashCode());
        result = prime * result + ((getHatenum() == null) ? 0 : getHatenum().hashCode());
        result = prime * result + ((getComm() == null) ? 0 : getComm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commid=").append(commid);
        sb.append(", postid=").append(postid);
        sb.append(", fkcommid=").append(fkcommid);
        sb.append(", userid=").append(userid);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", reportnum=").append(reportnum);
        sb.append(", likenum=").append(likenum);
        sb.append(", hatenum=").append(hatenum);
        sb.append(", comm=").append(comm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}