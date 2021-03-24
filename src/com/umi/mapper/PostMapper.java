package com.umi.mapper;

import com.umi.pojo.Post;
import com.umi.pojo.PostExample;
import com.umi.pojo.PostWithBLOBs;
import com.umi.pojo.RequestPost;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Long postid);

    int insert(PostWithBLOBs record);

    int insertSelective(PostWithBLOBs record);

    List<PostWithBLOBs> selectByExampleWithBLOBs(PostExample example);

    List<Post> selectByExample(PostExample example);

    PostWithBLOBs selectByPrimaryKey(Long postid);

    int updateByExampleSelective(@Param("record") PostWithBLOBs record, @Param("example") PostExample example);

    int updateByExampleWithBLOBs(@Param("record") PostWithBLOBs record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(PostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PostWithBLOBs record);

    int updateByPrimaryKey(Post record);
    
    List<PostWithBLOBs> selPostLikeTitle(String condition,int start,int size);
    
    List<PostWithBLOBs> selPostLikeDisplayInfo(String condition,int start,int size);
    
    long selPostCountLikeTitle(String condition);
    
    long selPostCountLikeDisplayInfo(String condition);
    
    List<RequestPost> selUsernaemAndPostId(Long source);
}