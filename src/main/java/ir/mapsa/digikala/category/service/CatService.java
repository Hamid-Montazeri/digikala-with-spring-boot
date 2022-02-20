package ir.mapsa.digikala.category.service;

import ir.mapsa.digikala.category.repository.CatRepo;
import ir.mapsa.digikala.category.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
    public Category save(Category category) {
        return catRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        Optional<Category> optionalCategory = catRepo.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("'Category' not found with requested 'id'");
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
    public List<Category> getAllCats() {
        return (List<Category>) catRepo.findAll();
    }

    @Override
    public Category getCatById(Long id) {
        Optional<Category> optionalCategory = catRepo.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("'Category' not found");
        }

        return optionalCategory.get();
    }
}
