package com.umi.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Count implements Serializable {
    private Long countid;

    private Long countnum;

    private Long countloginnum;

    private Date countdate;

    private static final long serialVersionUID = 1L;

    public Long getCountid() {
        return countid;
    }

    public void setCountid(Long countid) {
        this.countid = countid;
    }

    public Long getCountnum() {
        return countnum;
    }

    public void setCountnum(Long countnum) {
        this.countnum = countnum;
    }

    public Long getCountloginnum() {
        return countloginnum;
    }

    public void setCountloginnum(Long countloginnum) {
        this.countloginnum = countloginnum;
    }

    public Date getCountdate() {
        return countdate;
    }

    public void setCountdate(Date countdate) {
        this.countdate = countdate;
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
        Count other = (Count) that;
        return (this.getCountid() == null ? other.getCountid() == null : this.getCountid().equals(other.getCountid()))
            && (this.getCountnum() == null ? other.getCountnum() == null : this.getCountnum().equals(other.getCountnum()))
            && (this.getCountloginnum() == null ? other.getCountloginnum() == null : this.getCountloginnum().equals(other.getCountloginnum()))
            && (this.getCountdate() == null ? other.getCountdate() == null : this.getCountdate().equals(other.getCountdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCountid() == null) ? 0 : getCountid().hashCode());
        result = prime * result + ((getCountnum() == null) ? 0 : getCountnum().hashCode());
        result = prime * result + ((getCountloginnum() == null) ? 0 : getCountloginnum().hashCode());
        result = prime * result + ((getCountdate() == null) ? 0 : getCountdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countid=").append(countid);
        sb.append(", countnum=").append(countnum);
        sb.append(", countloginnum=").append(countloginnum);
        sb.append(", countdate=").append(countdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}