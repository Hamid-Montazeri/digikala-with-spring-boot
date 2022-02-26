package ir.mapsa.digikala.product.entity;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-26T02:08:26+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

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
        product.setImage( dto.getImage() );
        product.setType( dto.getType() );
        product.setCategory( categoryDTOToCategory( dto.getCategory() ) );

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
        productDTO.setImage( entity.getImage() );
        productDTO.setType( entity.getType() );
        productDTO.setCategory( categoryToCategoryDTO( entity.getCategory() ) );

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
        if ( dto.getImage() != null ) {
            entity.setImage( dto.getImage() );
        }
        if ( dto.getType() != null ) {
            entity.setType( dto.getType() );
        }
        if ( dto.getCategory() != null ) {
            if ( entity.getCategory() == null ) {
                entity.setCategory( new Category() );
            }
            categoryDTOToCategory1( dto.getCategory(), entity.getCategory() );
        }
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    protected void categoryDTOToCategory1(CategoryDTO categoryDTO, Category mappingTarget) {
        if ( categoryDTO == null ) {
            return;
        }

        if ( categoryDTO.getId() != null ) {
            mappingTarget.setId( categoryDTO.getId() );
        }
        if ( categoryDTO.getName() != null ) {
            mappingTarget.setName( categoryDTO.getName() );
        }
    }
}
