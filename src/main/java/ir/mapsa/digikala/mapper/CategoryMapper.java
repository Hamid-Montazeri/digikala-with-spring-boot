package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {

}
