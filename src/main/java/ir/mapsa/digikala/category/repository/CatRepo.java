package ir.mapsa.digikala.category.repository;

import ir.mapsa.digikala.category.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatRepo extends PagingAndSortingRepository<Category, Long> {

}
