package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Blazej on 21.05.2017.
 */
@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String,Cart> listOfCarts;

    public InMemoryCartRepository(){
        listOfCarts = new HashMap<String,Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw  new IllegalArgumentException(String.format("Nie mozna utworzyc koszyka " +
                    "o wskzanym id (%) koszyk juz isnieteje.",cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(),cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {

        if(!listOfCarts.keySet().contains(cartId)){
            throw  new IllegalArgumentException(String.format("Nie mozna utworzyc koszyka " +
                    "o wskzanym id (%) koszyk nie isnieteje.",cartId));

        }
        listOfCarts.put(cartId,cart);
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw  new IllegalArgumentException(String.format("Nie mozna utworzyc koszyka " +
                    "o wskzanym id (%) koszyk nie isnieteje.",cartId));

        }
        listOfCarts.remove(cartId);
    }
}
