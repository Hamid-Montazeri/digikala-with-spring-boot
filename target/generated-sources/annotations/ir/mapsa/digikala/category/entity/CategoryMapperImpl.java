package ir.mapsa.digikala.category.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-24T01:20:10+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> toDTOs(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( categories.size() );
        for ( Category category : categories ) {
            list.add( toDTO( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toEntities(List<CategoryDTO> categoryDTOs) {
        if ( categoryDTOs == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDTOs.size() );
        for ( CategoryDTO categoryDTO : categoryDTOs ) {
            list.add( toEntity( categoryDTO ) );
        }

        return list;
    }
}
