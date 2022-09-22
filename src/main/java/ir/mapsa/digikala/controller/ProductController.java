package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.service.ICategoryService;
import ir.mapsa.digikala.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;
    private final ProductMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO) {
        Product savedProduct = productService.save(mapper.toEntity(productDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO) {
        Product updatedProduct = productService.save(mapper.toEntity(productDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Product product) {
        productService.deleteById(product.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow();
        ProductDTO productDTO = mapper.toDto(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long id) {
        List<Product> products = productService.findAllByCategoryId(id);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = (List<Product>) productService.findAll();
        List<ProductDTO> productDTOS = mapper.toDTOs(products);
        return ResponseEntity.ok(productDTOS);
    }


}
