package com.umi.pojo;

import java.util.List;

public class ShowPost {
	private PostWithBLOBs passPost;
	private Users user;
	private List<Comment> commentList;
	private int isComment;
	private int currentPage;
	private int total;
	private int totalPage;
	private int lOrh;
	
	public int getlOrh() {
		return lOrh;
	}
	public void setlOrh(int lOrh) {
		this.lOrh = lOrh;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getIsComment() {
		return isComment;
	}
	public void setIsComment(int isComment) {
		this.isComment = isComment;
	}
	public PostWithBLOBs getPassPost() {
		return passPost;
	}
	public void setPassPost(PostWithBLOBs passPost) {
		this.passPost = passPost;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "ShowPost [passPost=" + passPost + ", user=" + user + ", commentList=" + commentList + "]";
	}
	
	
	
}
