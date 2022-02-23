package ir.mapsa.digikala.product.repository;

import ir.mapsa.digikala.product.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {

    @Override
    boolean existsById(Long productId);

    List<Product> findAllByCategory_Id(Long catId);



}
