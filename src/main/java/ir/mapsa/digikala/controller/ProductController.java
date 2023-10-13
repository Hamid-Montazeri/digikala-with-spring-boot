package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.service.CategoryService;
import ir.mapsa.digikala.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductMapper mapper;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        Product savedProduct = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(savedProduct));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(productService.update(productDTO, productDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductDTO productDTO = mapper.toDto(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<Product> products = productService.findAllByCategoryId(categoryId);
        return ResponseEntity.ok().body(mapper.toDTOs(products));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = (List<Product>) productService.findAll();
        List<ProductDTO> productDTOS = mapper.toDTOs(products);
        return ResponseEntity.ok(productDTOS);
    }


}
