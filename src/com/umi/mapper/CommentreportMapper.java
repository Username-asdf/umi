package com.umi.mapper;

import com.umi.pojo.Commentreport;
import com.umi.pojo.CommentreportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentreportMapper {
    long countByExample(CommentreportExample example);

    int deleteByExample(CommentreportExample example);

    int deleteByPrimaryKey(Long crid);

    int insert(Commentreport record);

    int insertSelective(Commentreport record);

    List<Commentreport> selectByExample(CommentreportExample example);

    Commentreport selectByPrimaryKey(Long crid);

    int updateByExampleSelective(@Param("record") Commentreport record, @Param("example") CommentreportExample example);

    int updateByExample(@Param("record") Commentreport record, @Param("example") CommentreportExample example);

    int updateByPrimaryKeySelective(Commentreport record);

    int updateByPrimaryKey(Commentreport record);
}