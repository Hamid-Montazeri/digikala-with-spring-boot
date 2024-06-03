package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {

}
