package xyz.hpwyx.manager.mapper;


import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BOrderDetail;

@Mapper
public interface BOrderDetailMapper {
    int deleteByPrimaryKey(Integer odId);
    int insert(BOrderDetail record);
    int insertSelective(BOrderDetail record);
    BOrderDetail selectByPrimaryKey(Integer odId);
    int updateByPrimaryKeySelective(BOrderDetail record);
    int updateByPrimaryKey(BOrderDetail record);
}