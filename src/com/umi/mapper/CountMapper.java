package com.umi.mapper;

import com.umi.pojo.Count;
import com.umi.pojo.CountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountMapper {
    long countByExample(CountExample example);

    int deleteByExample(CountExample example);

    int deleteByPrimaryKey(Long countid);

    int insert(Count record);

    int insertSelective(Count record);

    List<Count> selectByExample(CountExample example);

    Count selectByPrimaryKey(Long countid);

    int updateByExampleSelective(@Param("record") Count record, @Param("example") CountExample example);

    int updateByExample(@Param("record") Count record, @Param("example") CountExample example);

    int updateByPrimaryKeySelective(Count record);

    int updateByPrimaryKey(Count record);
}