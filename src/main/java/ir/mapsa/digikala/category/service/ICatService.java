package ir.mapsa.digikala.category.service;

import ir.mapsa.digikala.category.entity.Category;

import java.util.List;

public interface ICatService {

    Category save(Category category);

    Category update(Category category);

    void deleteById(Long id);

    Category getCatById(Long id);

    List<Category> getAllCats();


}
