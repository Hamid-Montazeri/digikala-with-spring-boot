package ir.mapsa.digikala.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;
    private final ProductMapper mapper;

    @Autowired
    public ProductController(IProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @PostMapping("/save/{catId}/{userId}")
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO, @PathVariable Long catId, @PathVariable Long userId) {
        Product product = productService.save(mapper.toEntity(productDTO), catId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        Product updatedProduct = productService.update(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Product product) {
        productService.deleteById(product.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getById(id);
        ProductDTO productDTO = mapper.toDTO(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOS = mapper.toDTOs(products);
        return ResponseEntity.ok(productDTOS);
    }


}
