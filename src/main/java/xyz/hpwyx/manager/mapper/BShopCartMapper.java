package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BShopCart;
@Mapper
public interface BShopCartMapper {
    int deleteByPrimaryKey(Integer cId);
    int insert(BShopCart record);
    int insertSelective(BShopCart record);
    BShopCart selectByPrimaryKey(Integer cId);
    int updateByPrimaryKeySelective(BShopCart record);
    int updateByPrimaryKey(BShopCart record);
}