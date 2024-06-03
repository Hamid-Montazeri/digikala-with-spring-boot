package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.model.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product, Long> {

    List<Product> findAllByCategoryId(Long catId);

}
