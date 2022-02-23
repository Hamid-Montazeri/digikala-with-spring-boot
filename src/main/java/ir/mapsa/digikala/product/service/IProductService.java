package ir.mapsa.digikala.product.service;

import ir.mapsa.digikala.product.entity.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product, Long catId, Long userId);

    Product update(Product product);

    void deleteById(Long id);

    Product getById(Long id);

    List<Product> getAllProducts();

    List<Product> getAllProductsByCatId(Long catId);

}
