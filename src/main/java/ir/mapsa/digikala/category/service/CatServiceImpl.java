package ir.mapsa.digikala.category.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import ir.mapsa.digikala.category.entity.CategoryMapper;
import ir.mapsa.digikala.category.repository.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl extends GenericServiceImpl<Category, CategoryDTO, Long> implements ICatService {

    private final CatRepo catRepo;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CatServiceImpl(CatRepo catRepo, CategoryMapper categoryMapper) {
        this.catRepo = catRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    protected GenericRepository<Category, Long> getRepository() {
        return catRepo;
    }

    @Override
    protected GenericMapper<Category, CategoryDTO> getEntityMapper() {
        return categoryMapper;
    }
}
