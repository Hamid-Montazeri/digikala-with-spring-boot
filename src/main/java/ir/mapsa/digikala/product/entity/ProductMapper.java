package ir.mapsa.digikala.product.entity;

import ir.mapsa.digikala.category.entity.CategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    Product toEntity(ProductDTO productDTO);

    ProductDTO toDTO(Product product);

    List<Product> toEntities(List<ProductDTO> productDTOs);

    List<ProductDTO> toDTOs(List<Product> products);


}
