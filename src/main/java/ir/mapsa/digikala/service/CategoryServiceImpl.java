package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryDTO, Long> implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    protected GenericRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    protected GenericMapper<Category, CategoryDTO> getEntityMapper() {
        return categoryMapper;
    }
}
