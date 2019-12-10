package com.example.express_dena.mapper;

import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.HorsemanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HorsemanMapper {
    long countByExample(HorsemanExample example);

    int deleteByExample(HorsemanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Horseman record);

    int insertSelective(Horseman record);

    List<Horseman> selectByExample(HorsemanExample example);

    Horseman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Horseman record, @Param("example") HorsemanExample example);

    int updateByExample(@Param("record") Horseman record, @Param("example") HorsemanExample example);

    int updateByPrimaryKeySelective(Horseman record);

    int updateByPrimaryKey(Horseman record);
}