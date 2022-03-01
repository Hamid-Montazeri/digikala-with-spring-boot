package ir.mapsa.digikala.category.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {

}
