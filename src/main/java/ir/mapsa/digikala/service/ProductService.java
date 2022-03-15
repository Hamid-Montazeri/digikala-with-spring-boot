package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.repository.CategoryRepository;
import ir.mapsa.digikala.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService extends GenericServiceImpl<Product, ProductDTO, Long> implements IProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ProductMapper productMapper;
    private CategoryMapper categoryMapper;

    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    protected GenericMapper<Product, ProductDTO> getEntityMapper() {
        return productMapper;
    }

    @Override
    public Product save(ProductDTO productDTO, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow();
        CategoryDTO categoryDTO = categoryMapper.toDto(savedCategory);
        productDTO.setCategory(categoryDTO);
        return productRepository.save(productMapper.toEntity(productDTO));
    }

    @Override
    public List<Product> findAllByCategoryId(Long catId) {
        return productRepository.findAllByCategoryId(catId);
    }

}
