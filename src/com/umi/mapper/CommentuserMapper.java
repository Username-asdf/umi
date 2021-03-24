package com.umi.mapper;

import com.umi.pojo.Commentuser;
import com.umi.pojo.CommentuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentuserMapper {
    long countByExample(CommentuserExample example);

    int deleteByExample(CommentuserExample example);

    int deleteByPrimaryKey(Long cuid);

    int insert(Commentuser record);

    int insertSelective(Commentuser record);

    List<Commentuser> selectByExample(CommentuserExample example);

    Commentuser selectByPrimaryKey(Long cuid);

    int updateByExampleSelective(@Param("record") Commentuser record, @Param("example") CommentuserExample example);

    int updateByExample(@Param("record") Commentuser record, @Param("example") CommentuserExample example);

    int updateByPrimaryKeySelective(Commentuser record);

    int updateByPrimaryKey(Commentuser record);
}