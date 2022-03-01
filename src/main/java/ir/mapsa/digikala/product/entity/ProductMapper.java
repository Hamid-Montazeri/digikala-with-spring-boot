package ir.mapsa.digikala.product.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {

}
