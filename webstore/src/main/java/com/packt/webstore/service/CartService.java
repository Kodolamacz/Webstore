package com.packt.webstore.service;

import com.packt.webstore.domain.Cart;

/**
 * Created by Blazej on 22.05.2017.
 */
public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
