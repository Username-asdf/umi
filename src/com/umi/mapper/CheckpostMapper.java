package com.umi.mapper;

import com.umi.pojo.Checkpost;
import com.umi.pojo.CheckpostExample;
import com.umi.pojo.CheckpostWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckpostMapper {
    long countByExample(CheckpostExample example);

    int deleteByExample(CheckpostExample example);

    int deleteByPrimaryKey(Long postid);

    int insert(CheckpostWithBLOBs record);

    int insertSelective(CheckpostWithBLOBs record);

    List<CheckpostWithBLOBs> selectByExampleWithBLOBs(CheckpostExample example);

    List<Checkpost> selectByExample(CheckpostExample example);

    CheckpostWithBLOBs selectByPrimaryKey(Long postid);

    int updateByExampleSelective(@Param("record") CheckpostWithBLOBs record, @Param("example") CheckpostExample example);

    int updateByExampleWithBLOBs(@Param("record") CheckpostWithBLOBs record, @Param("example") CheckpostExample example);

    int updateByExample(@Param("record") Checkpost record, @Param("example") CheckpostExample example);

    int updateByPrimaryKeySelective(CheckpostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CheckpostWithBLOBs record);

    int updateByPrimaryKey(Checkpost record);
}