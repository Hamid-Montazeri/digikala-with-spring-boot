package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl extends GenericServiceImpl<Cart, CartDTO, Long> implements ICartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    protected GenericRepository<Cart, Long> getRepository() {
        return cartRepository;
    }

    @Override
    protected GenericMapper<Cart, CartDTO> getEntityMapper() {
        return cartMapper;
    }



}
