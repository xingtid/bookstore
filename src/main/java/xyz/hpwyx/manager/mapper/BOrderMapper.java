package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BOrder;
@Mapper
public interface BOrderMapper {
    int deleteByPrimaryKey(Integer oId);
    int insert(BOrder record);
    int insertSelective(BOrder record);
    BOrder selectByPrimaryKey(Integer oId);
    int updateByPrimaryKeySelective(BOrder record);
    int updateByPrimaryKey(BOrder record);
}