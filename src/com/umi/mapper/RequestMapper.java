package com.umi.mapper;

import com.umi.pojo.Request;
import com.umi.pojo.RequestExample;
import com.umi.pojo.RequestWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestMapper {
    long countByExample(RequestExample example);

    int deleteByExample(RequestExample example);

    int deleteByPrimaryKey(Long requestid);

    int insert(RequestWithBLOBs record);

    int insertSelective(RequestWithBLOBs record);

    List<RequestWithBLOBs> selectByExampleWithBLOBs(RequestExample example);

    List<Request> selectByExample(RequestExample example);

    RequestWithBLOBs selectByPrimaryKey(Long requestid);

    int updateByExampleSelective(@Param("record") RequestWithBLOBs record, @Param("example") RequestExample example);

    int updateByExampleWithBLOBs(@Param("record") RequestWithBLOBs record, @Param("example") RequestExample example);

    int updateByExample(@Param("record") Request record, @Param("example") RequestExample example);

    int updateByPrimaryKeySelective(RequestWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RequestWithBLOBs record);

    int updateByPrimaryKey(Request record);
}