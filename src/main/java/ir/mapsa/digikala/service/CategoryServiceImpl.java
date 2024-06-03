package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDTO, Long> implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    protected BaseRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    protected BaseMapper<Category, CategoryDTO> getEntityMapper() {
        return categoryMapper;
    }
}
