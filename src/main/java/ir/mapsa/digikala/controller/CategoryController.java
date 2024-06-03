package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category, CategoryDTO, Long> {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    protected BaseService<Category, CategoryDTO, Long> getBaseService() {
        return categoryService;
    }

    @Override
    protected BaseMapper<Category, CategoryDTO> getBaseMapper() {
        return categoryMapper;
    }
}
