package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.model.Cart;
import ir.mapsa.digikala.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T23:05:13+0430",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Cart toEntity(CartDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( dto.getId() );
        cart.setCode( dto.getCode() );
        cart.setDate( dto.getDate() );
        cart.setUser( userMapper.toEntity( dto.getUser() ) );

        return cart;
    }

    @Override
    public CartDTO toDto(Cart entity) {
        if ( entity == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setId( entity.getId() );
        cartDTO.setCode( entity.getCode() );
        cartDTO.setDate( entity.getDate() );
        cartDTO.setUser( userMapper.toDto( entity.getUser() ) );

        return cartDTO;
    }

    @Override
    public List<Cart> toEntities(List<CartDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Cart> list = new ArrayList<Cart>( dtos.size() );
        for ( CartDTO cartDTO : dtos ) {
            list.add( toEntity( cartDTO ) );
        }

        return list;
    }

    @Override
    public List<CartDTO> toDTOs(List<Cart> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CartDTO> list = new ArrayList<CartDTO>( entities.size() );
        for ( Cart cart : entities ) {
            list.add( toDto( cart ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Cart entity, CartDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getDate() != null ) {
            entity.setDate( dto.getDate() );
        }
        if ( dto.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new User() );
            }
            userMapper.partialUpdate( entity.getUser(), dto.getUser() );
        }
    }
}
