package ir.mapsa.digikala.product;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/save/{catId}")
    public Product save(@RequestBody ProductDTO productDTO, @PathVariable Long catId) {
        return productService.save(mapper.toEntity(productDTO), catId);
    }

    @PutMapping("/update")
    public Product update(@RequestBody ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        return productService.update(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.deleteById(product.getId());
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return mapper.toDTO(productService.getById(id));
    }

    @GetMapping("/")
    public List<ProductDTO> getAll() {
        List<Product> products = productService.getAllProducts();
        return mapper.toDTOs(products);
    }


}
