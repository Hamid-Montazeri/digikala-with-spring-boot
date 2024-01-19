package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductDTO, Long> implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    protected GenericMapper<Product, ProductDTO> getEntityMapper() {
        return productMapper;
    }

    @Override
    public List<Product> findAllByCategoryId(Long catId) {
        return productRepository.findAllByCategoryId(catId);
    }

}
