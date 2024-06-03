package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T20:54:22+0430",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setName( dto.getName() );
        product.setRegularPrice( dto.getRegularPrice() );
        product.setSalePrice( dto.getSalePrice() );
        product.setImageUrl( dto.getImageUrl() );
        product.setProductType( dto.getProductType() );
        product.setCategory( categoryMapper.toEntity( dto.getCategory() ) );

        return product;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( entity.getId() );
        productDTO.setName( entity.getName() );
        productDTO.setRegularPrice( entity.getRegularPrice() );
        productDTO.setSalePrice( entity.getSalePrice() );
        productDTO.setImageUrl( entity.getImageUrl() );
        productDTO.setProductType( entity.getProductType() );
        productDTO.setCategory( categoryMapper.toDto( entity.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<Product> toEntities(List<ProductDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtos.size() );
        for ( ProductDTO productDTO : dtos ) {
            list.add( toEntity( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> toDTOs(List<Product> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( entities.size() );
        for ( Product product : entities ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Product entity, ProductDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getRegularPrice() != null ) {
            entity.setRegularPrice( dto.getRegularPrice() );
        }
        if ( dto.getSalePrice() != null ) {
            entity.setSalePrice( dto.getSalePrice() );
        }
        if ( dto.getImageUrl() != null ) {
            entity.setImageUrl( dto.getImageUrl() );
        }
        if ( dto.getProductType() != null ) {
            entity.setProductType( dto.getProductType() );
        }
        if ( dto.getCategory() != null ) {
            if ( entity.getCategory() == null ) {
                entity.setCategory( new Category() );
            }
            categoryMapper.partialUpdate( entity.getCategory(), dto.getCategory() );
        }
    }
}
