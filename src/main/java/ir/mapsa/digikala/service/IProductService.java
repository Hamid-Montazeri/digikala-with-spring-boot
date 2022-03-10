package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericService;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.model.Product;

import java.util.List;

public interface IProductService extends GenericService<Product, ProductDTO, Long> {

    Product save(ProductDTO productDTO, Long categoryId);
    List<Product> findAllByCategoryId(Long catId);

}
