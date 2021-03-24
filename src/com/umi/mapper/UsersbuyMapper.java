package com.umi.mapper;

import com.umi.pojo.Usersbuy;
import com.umi.pojo.UsersbuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersbuyMapper {
    long countByExample(UsersbuyExample example);

    int deleteByExample(UsersbuyExample example);

    int deleteByPrimaryKey(Long usersbuyid);

    int insert(Usersbuy record);

    int insertSelective(Usersbuy record);

    List<Usersbuy> selectByExample(UsersbuyExample example);

    Usersbuy selectByPrimaryKey(Long usersbuyid);

    int updateByExampleSelective(@Param("record") Usersbuy record, @Param("example") UsersbuyExample example);

    int updateByExample(@Param("record") Usersbuy record, @Param("example") UsersbuyExample example);

    int updateByPrimaryKeySelective(Usersbuy record);

    int updateByPrimaryKey(Usersbuy record);
}