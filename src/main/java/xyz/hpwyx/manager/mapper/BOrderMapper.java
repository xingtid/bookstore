package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BOrder;

import java.util.List;

@Mapper
public interface BOrderMapper {
    int deleteByPrimaryKey(Integer oId);
    int insert(BOrder record);
    int insertSelective(BOrder record);
    BOrder selectByPrimaryKey(Integer oId);
    BOrder selectByOrderNo(String oOrderNo);
    int updateByPrimaryKeySelective(BOrder record);
    int updateByPrimaryKey(BOrder record);
    int countOrder();
    List<BOrder> findList(BOrder order);
}