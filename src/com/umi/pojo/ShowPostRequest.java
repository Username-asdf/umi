package com.umi.pojo;

import java.util.List;

public class ShowPostRequest {
	
	//总页数
	private long total;
	//信息总条数
	private long totalNum;
	//当前页数
	private long current;
	
	private List<RequestWithBLOBs> list;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public List<RequestWithBLOBs> getList() {
		return list;
	}

	public void setList(List<RequestWithBLOBs> list) {
		this.list = list;
	}
	
	
}
