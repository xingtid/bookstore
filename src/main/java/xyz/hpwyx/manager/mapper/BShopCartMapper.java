package xyz.hpwyx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.hpwyx.manager.pojo.BShopCart;
import xyz.hpwyx.manager.pojo.CartWithBook;

import java.util.List;

@Mapper
public interface BShopCartMapper {
    int deleteByPrimaryKey(Integer cId);
    int insert(BShopCart record);
    int insertSelective(BShopCart record);
    BShopCart selectByPrimaryKey(Integer cId);
    List<CartWithBook> findCartList(BShopCart record);
    List<CartWithBook> findCartList2(BShopCart record);
    int updateByPrimaryKeySelective(BShopCart record);
    int updateByPrimaryKey(BShopCart record);
}