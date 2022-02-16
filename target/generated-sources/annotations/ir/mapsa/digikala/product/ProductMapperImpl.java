package ir.mapsa.digikala.product;

import ir.mapsa.digikala.category.CategoryMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-16T20:21:03+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setRegularPrice( productDTO.getRegularPrice() );
        product.setSalePrice( productDTO.getSalePrice() );
        product.setImage( productDTO.getImage() );
        product.setType( productDTO.getType() );
        product.setCategory( categoryMapper.toEntity( productDTO.getCategory() ) );

        return product;
    }

    @Override
    public ProductDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );
        productDTO.setRegularPrice( product.getRegularPrice() );
        productDTO.setSalePrice( product.getSalePrice() );
        productDTO.setImage( product.getImage() );
        productDTO.setType( product.getType() );
        productDTO.setCategory( categoryMapper.toDTO( product.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<Product> toEntities(List<ProductDTO> productDTOs) {
        if ( productDTOs == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOs.size() );
        for ( ProductDTO productDTO : productDTOs ) {
            list.add( toEntity( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> toDTOs(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toDTO( product ) );
        }

        return list;
    }
}
