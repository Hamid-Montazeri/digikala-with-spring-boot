package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-22T17:40:40+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );

        return category;
    }

    @Override
    public CategoryDTO toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( entity.getId() );
        categoryDTO.setName( entity.getName() );

        return categoryDTO;
    }

    @Override
    public List<Category> toEntities(List<CategoryDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtos.size() );
        for ( CategoryDTO categoryDTO : dtos ) {
            list.add( toEntity( categoryDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toDTOs(List<Category> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entities.size() );
        for ( Category category : entities ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Category entity, CategoryDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
    }
}
