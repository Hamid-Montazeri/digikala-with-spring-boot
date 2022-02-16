package ir.mapsa.digikala.product;

import ir.mapsa.digikala.category.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);

}
