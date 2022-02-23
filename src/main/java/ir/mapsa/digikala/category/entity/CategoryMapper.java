package ir.mapsa.digikala.category.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTOs(List<Category> categories);

    List<Category> toEntities(List<CategoryDTO> categoryDTOs);


}
