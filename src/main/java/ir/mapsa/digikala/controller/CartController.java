package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController extends BaseController<Cart, CartDTO, Long> {

    private final CartService cartService;
    private final CartMapper cartMapper;


    @Override
    protected BaseService<Cart, CartDTO, Long> getBaseService() {
        return cartService;
    }

    @Override
    protected BaseMapper<Cart, CartDTO> getBaseMapper() {
        return cartMapper;
    }
}
