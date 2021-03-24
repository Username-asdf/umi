package com.umi.pojo;

import java.util.List;

/**
 * 用户查看其他用户的信息
 * @author 我
 *
 */
public class ShowUserInfo {
	
	private Users user;
	
	private int isAtten;
	
	private List<PostWithBLOBs> postList;
	
	private int postListSize;
	
	public int getPostListSize() {
		return postListSize;
	}

	public void setPostListSize(int postListSize) {
		this.postListSize = postListSize;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getIsAtten() {
		return isAtten;
	}

	public void setIsAtten(int isAtten) {
		this.isAtten = isAtten;
	}

	public List<PostWithBLOBs> getPostList() {
		return postList;
	}

	public void setPostList(List<PostWithBLOBs> postList) {
		this.postList = postList;
	}
	
	
}
