package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BShopCartMapper;
import xyz.hpwyx.manager.pojo.BShopCart;
import xyz.hpwyx.manager.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private BShopCartMapper dao;

    public int insertCart(BShopCart cart){
        return dao.insertSelective (cart);
    }

}
