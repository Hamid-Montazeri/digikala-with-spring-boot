package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @PostMapping
    public ResponseEntity<CartDTO> save(@RequestBody CartDTO cartDTO) {
        Cart savedCart = cartService.save(cartDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartMapper.toDto(savedCart));
    }

    @PutMapping
    public ResponseEntity<CartDTO> update(@RequestBody CartDTO cartDTO) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(cartService.update(cartDTO, cartDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
        Cart cart = cartService.findById(id);
        return ResponseEntity.ok(cartMapper.toDto(cart));
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getAll() {
        List<Cart> carts = (List<Cart>) cartService.findAll();
        List<CartDTO> cartDTOs = cartMapper.toDTOs(carts);
        return ResponseEntity.ok(cartDTOs);
    }

}
