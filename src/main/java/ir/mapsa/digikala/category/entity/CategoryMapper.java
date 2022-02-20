package ir.mapsa.digikala.category.entity;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTOs(List<Category> categories);

    List<Category> toEntities(List<CategoryDTO> categoryDTOs);


}
