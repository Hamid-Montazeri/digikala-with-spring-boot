package ir.mapsa.digikala.cart.entity;

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
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart toEntity(CartDTO cartDTO) {
        if ( cartDTO == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( cartDTO.getId() );
        cart.setCode( cartDTO.getCode() );

        return cart;
    }

    @Override
    public CartDTO toDTO(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setId( cart.getId() );
        cartDTO.setCode( cart.getCode() );

        return cartDTO;
    }

    @Override
    public List<Cart> toEntities(List<CartDTO> cartDTOs) {
        if ( cartDTOs == null ) {
            return null;
        }

        List<Cart> list = new ArrayList<Cart>( cartDTOs.size() );
        for ( CartDTO cartDTO : cartDTOs ) {
            list.add( toEntity( cartDTO ) );
        }

        return list;
    }

    @Override
    public List<CartDTO> toDTOs(List<Cart> carts) {
        if ( carts == null ) {
            return null;
        }

        List<CartDTO> list = new ArrayList<CartDTO>( carts.size() );
        for ( Cart cart : carts ) {
            list.add( toDTO( cart ) );
        }

        return list;
    }
}
