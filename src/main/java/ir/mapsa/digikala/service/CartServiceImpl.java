package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl extends BaseServiceImpl<Cart, CartDTO, Long> implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    protected BaseRepository<Cart, Long> getRepository() {
        return cartRepository;
    }

    @Override
    protected BaseMapper<Cart, CartDTO> getEntityMapper() {
        return cartMapper;
    }


}
