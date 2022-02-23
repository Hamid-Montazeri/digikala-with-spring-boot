package ir.mapsa.digikala.cart.service;


import ir.mapsa.digikala.cart.entity.Cart;

import java.util.List;

public interface ICartService {

    Cart save(Cart cart);

    Cart update(Cart cart);

    void deleteById(Long id);

    Cart getById(Long id);

    List<Cart> getAllCarts();

}
