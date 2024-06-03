package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, ProductDTO, Long> {
    List<Product> findAllByCategoryId(Long catId);

}
