package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.mapper.CartMapper;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.service.ICartService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final ICartService cartService;
    private final CartMapper cartMapper;

    @PostMapping("/save")
    public ResponseEntity<Cart> save(@RequestBody CartDTO cartDTO) {
        Cart savedCart = cartService.save(cartMapper.toEntity(cartDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> update(@RequestBody CartDTO cartDTO) {
        Cart updatedCart = cartService.save(cartMapper.toEntity(cartDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedCart);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
        Optional<Cart> optionalCart = cartService.findById(id);

        if (optionalCart.isEmpty()) {
            throw new RuntimeException("The requested \"Cart\" not found.");
        }

        CartDTO cartDTO = cartMapper.toDto(optionalCart.get());
        return ResponseEntity.ok(cartDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CartDTO>> getAll() {
        List<Cart> carts = (List<Cart>) cartService.findAll();
        List<CartDTO> cartDTOs = cartMapper.toDTOs(carts);
        return ResponseEntity.ok(cartDTOs);
    }

}
