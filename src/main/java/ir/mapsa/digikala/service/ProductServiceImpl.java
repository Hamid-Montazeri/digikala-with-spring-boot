package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.mapper.ProductMapper;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductDTO, Long> implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    protected BaseRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    protected BaseMapper<Product, ProductDTO> getEntityMapper() {
        return productMapper;
    }

    @Override
    public List<Product> findAllByCategoryId(Long catId) {
        return productRepository.findAllByCategoryId(catId);
    }

}
