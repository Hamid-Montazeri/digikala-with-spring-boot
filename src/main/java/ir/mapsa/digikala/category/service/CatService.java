package ir.mapsa.digikala.category.service;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.repository.CatRepo;
import ir.mapsa.digikala.exception.ConflictException;
import ir.mapsa.digikala.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService implements ICatService {

    private final CatRepo catRepo;

    @Autowired
    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    @Override
    @Caching(evict = @CacheEvict(value = "category", allEntries = true))
    public Category save(Category category) {
        if (catRepo.existsById(category.getId())) {
            throw new ConflictException("The category \"" + category.getName() + "\" with ID \"" + category.getId() + "\" already exists");
        }
        return catRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        Optional<Category> optionalCategory = catRepo.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("The category \"" + category.getName() + "\" not found with ID " + category.getId());
        }

        Category savedCategory = optionalCategory.get();
        savedCategory.setName(category.getName());

        return catRepo.save(category);
    }

    @Override
    public void deleteById(Long id) {
        catRepo.deleteById(id);
    }

    @Override
    @Cacheable(value = "category")
    public List<Category> getAllCats() {
        List<Category> categories = (List<Category>) catRepo.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException("No Category found!");
        }
        return categories;
    }

    @Override
    public Category getCatById(Long id) {
        Optional<Category> optionalCategory = catRepo.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("The category with ID\"" + id + "\" not found");
        }

        return optionalCategory.get();
    }

}
