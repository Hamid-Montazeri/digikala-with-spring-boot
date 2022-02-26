package ir.mapsa.digikala.product.entity;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.category.entity.CategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {

}
