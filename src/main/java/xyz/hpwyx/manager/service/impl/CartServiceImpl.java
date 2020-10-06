package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BShopCartMapper;
import xyz.hpwyx.manager.pojo.BShopCart;
import xyz.hpwyx.manager.pojo.CartWithBook;
import xyz.hpwyx.manager.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private BShopCartMapper dao;

    public int insertCart(BShopCart cart){
        return dao.insertSelective (cart);
    }

    @Override
    public int delCart(BShopCart cart) {
        return dao.deleteByPrimaryKey (cart.getcId ());
    }

    @Override
    public int updateCarNum(BShopCart cart) {
        return dao.updateByPrimaryKeySelective (cart);
    }

    public List<CartWithBook> findCartList(BShopCart cart){
        return dao.findCartList (cart);
    }
    public List<CartWithBook> findCartList2(BShopCart cart){
        return dao.findCartList2 (cart);
    }
    public BShopCart getCart(BShopCart cart){
        return dao.selectByPrimaryKey (cart.getcId ());
    }



}
