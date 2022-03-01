package ir.mapsa.digikala.product.controller;

import ir.mapsa.digikala.product.entity.Product;
import ir.mapsa.digikala.product.entity.ProductDTO;
import ir.mapsa.digikala.product.entity.ProductMapper;
import ir.mapsa.digikala.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;
    private final ProductMapper mapper;

    @Autowired
    public ProductController(IProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

/*
    @PostMapping("/save/{catId}/{userId}")
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO, @PathVariable Long catId, @PathVariable Long userId) {
        Product product = productService.save(mapper.toEntity(productDTO), catId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
*/

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO) {
        Product product = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO) {
        Optional<Product> optionalProduct = productService.findById(productDTO.getId());

        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("The requested \"Product\" not found.");
        }

        Product savedProduct = optionalProduct.get();

        savedProduct.setName(productDTO.getName());
        savedProduct.setRegularPrice(productDTO.getRegularPrice());
        savedProduct.setSalePrice(productDTO.getSalePrice());
        savedProduct.setImage(productDTO.getImage());
        savedProduct.setType(productDTO.getType());
//        savedProduct.setCategory(productDTO.getCategory());

        Product updatedProduct = productService.save(mapper.toDto(savedProduct));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody Product product) {
        productService.deleteById(product.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("The requested \"Product\" not found.");
        }

        ProductDTO productDTO = mapper.toDto(optionalProduct.get());
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = (List<Product>) productService.findAll();
        List<ProductDTO> productDTOS = mapper.toDTOs(products);
        return ResponseEntity.ok(productDTOS);
    }


}
