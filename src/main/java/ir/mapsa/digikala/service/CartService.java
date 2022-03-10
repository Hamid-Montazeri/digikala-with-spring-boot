package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends GenericServiceImpl<Cart, CartDTO, Long> implements ICartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    /*@Override
    public Cart save(Cart cart) {
        if (cartRepository.existsById(cart.getId())) {
            throw new ConflictException("The cart with ID \"" + cart.getId() + "\" already exists");
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        Optional<Cart> optionalCart = cartRepository.findById(cart.getId());

        if (optionalCart.isEmpty()) {
            throw new NotFoundException("The requested \"cart\" not found.");
        }

        Cart savedCart = optionalCart.get();

        savedCart.setCode(cart.getCode());

        return savedCart;
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart getById(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);

        if (optionalCart.isEmpty()) {
            throw new NotFoundException("The requested \"Address\" with id \"" + id + "\" not found.");
        }

        return optionalCart.get();
    }

    @Override
    @Cacheable(value = "cart")
    public List<Cart> getAllCarts() {
        List<Cart> carts = (List<Cart>) cartRepository.findAll();

        if (carts.isEmpty()) {
            throw new NotFoundException("No cart found.");
        }

        return carts;
    }*/

    @Override
    protected GenericRepository<Cart, Long> getRepository() {
        return cartRepository;
    }

    @Override
    protected GenericMapper<Cart, CartDTO> getEntityMapper() {
        return cartMapper;
    }



}
