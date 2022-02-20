package ir.mapsa.digikala.product.repository;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.product.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);

}
