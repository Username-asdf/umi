package com.umi.mapper;

import com.umi.pojo.Notpasspost;
import com.umi.pojo.NotpasspostExample;
import com.umi.pojo.NotpasspostWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotpasspostMapper {
    long countByExample(NotpasspostExample example);

    int deleteByExample(NotpasspostExample example);

    int deleteByPrimaryKey(Long postid);

    int insert(NotpasspostWithBLOBs record);

    int insertSelective(NotpasspostWithBLOBs record);

    List<NotpasspostWithBLOBs> selectByExampleWithBLOBs(NotpasspostExample example);

    List<Notpasspost> selectByExample(NotpasspostExample example);

    NotpasspostWithBLOBs selectByPrimaryKey(Long postid);

    int updateByExampleSelective(@Param("record") NotpasspostWithBLOBs record, @Param("example") NotpasspostExample example);

    int updateByExampleWithBLOBs(@Param("record") NotpasspostWithBLOBs record, @Param("example") NotpasspostExample example);

    int updateByExample(@Param("record") Notpasspost record, @Param("example") NotpasspostExample example);

    int updateByPrimaryKeySelective(NotpasspostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NotpasspostWithBLOBs record);

    int updateByPrimaryKey(Notpasspost record);
}