package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController extends BaseController<Product, ProductDTO, Long> {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    protected BaseService<Product, ProductDTO, Long> getBaseService() {
        return productService;
    }

    @Override
    protected BaseMapper<Product, ProductDTO> getBaseMapper() {
        return productMapper;
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<Product> products = productService.findAllByCategoryId(categoryId);
        return ResponseEntity.ok().body(productMapper.toDTOs(products));
    }

}
