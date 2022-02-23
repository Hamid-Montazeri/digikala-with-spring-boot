package ir.mapsa.digikala.cart.controller;

import ir.mapsa.digikala.cart.entity.Cart;
import ir.mapsa.digikala.cart.entity.CartDTO;
import ir.mapsa.digikala.cart.entity.CartMapper;
import ir.mapsa.digikala.cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ICartService cartService;
    private final CartMapper cartMapper;

    @Autowired
    public CartController(ICartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Cart> save(@RequestBody CartDTO cartDTO) {
        Cart savedCart = cartService.save(cartMapper.toEntity(cartDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> update(@RequestBody CartDTO cartDTO) {
        Cart updatedCart = cartService.update(cartMapper.toEntity(cartDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedCart);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody CartDTO cartDTO) {
        cartService.deleteById(cartDTO.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
        Cart cart = cartService.getById(id);
        CartDTO cartDTO = cartMapper.toDTO(cart);
        return ResponseEntity.ok(cartDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CartDTO>> getAll() {
        List<Cart> carts = cartService.getAllCarts();
        List<CartDTO> cartDTOs = cartMapper.toDTOs(carts);
        return ResponseEntity.ok(cartDTOs);
    }

}
