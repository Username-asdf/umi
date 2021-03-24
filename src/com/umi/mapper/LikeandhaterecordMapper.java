package com.umi.mapper;

import com.umi.pojo.Likeandhaterecord;
import com.umi.pojo.LikeandhaterecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeandhaterecordMapper {
    long countByExample(LikeandhaterecordExample example);

    int deleteByExample(LikeandhaterecordExample example);

    int deleteByPrimaryKey(Long lhid);

    int insert(Likeandhaterecord record);

    int insertSelective(Likeandhaterecord record);

    List<Likeandhaterecord> selectByExample(LikeandhaterecordExample example);

    Likeandhaterecord selectByPrimaryKey(Long lhid);

    int updateByExampleSelective(@Param("record") Likeandhaterecord record, @Param("example") LikeandhaterecordExample example);

    int updateByExample(@Param("record") Likeandhaterecord record, @Param("example") LikeandhaterecordExample example);

    int updateByPrimaryKeySelective(Likeandhaterecord record);

    int updateByPrimaryKey(Likeandhaterecord record);
}