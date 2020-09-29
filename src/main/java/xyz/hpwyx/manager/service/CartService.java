package xyz.hpwyx.manager.service;

import xyz.hpwyx.manager.pojo.BShopCart;

public interface CartService {
    int insertCart(BShopCart cart);
    int delCart(BShopCart cart);
    int updateCarNum(BShopCart cart);
}
