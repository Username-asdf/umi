package com.umi.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Request implements Serializable {
    private Long requestid;

    private Long usersid;

    private Date time;

    private Long accpet;

    private Integer finish;
    //发布资源人数
    private Long num;
    //发布资源列表
    private List<RequestPost> list;
    //List<RequestPost>.size()
    private int listSize;

    private static final long serialVersionUID = 1L;
    
    public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public List<RequestPost> getList() {
		return list;
	}

	public void setList(List<RequestPost> list) {
		this.list = list;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getRequestid() {
        return requestid;
    }

    public void setRequestid(Long requestid) {
        this.requestid = requestid;
    }

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getAccpet() {
        return accpet;
    }

    public void setAccpet(Long accpet) {
        this.accpet = accpet;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
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
        Request other = (Request) that;
        return (this.getRequestid() == null ? other.getRequestid() == null : this.getRequestid().equals(other.getRequestid()))
            && (this.getUsersid() == null ? other.getUsersid() == null : this.getUsersid().equals(other.getUsersid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getAccpet() == null ? other.getAccpet() == null : this.getAccpet().equals(other.getAccpet()))
            && (this.getFinish() == null ? other.getFinish() == null : this.getFinish().equals(other.getFinish()));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requestid=").append(requestid);
        sb.append(", usersid=").append(usersid);
        sb.append(", time=").append(time);
        sb.append(", accpet=").append(accpet);
        sb.append(", finish=").append(finish);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}