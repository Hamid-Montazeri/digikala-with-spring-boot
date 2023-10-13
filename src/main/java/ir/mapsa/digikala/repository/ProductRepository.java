package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.model.Product;

import java.util.List;

public interface ProductRepository extends GenericRepository<Product, Long> {

    List<Product> findAllByCategoryId(Long catId);

}
