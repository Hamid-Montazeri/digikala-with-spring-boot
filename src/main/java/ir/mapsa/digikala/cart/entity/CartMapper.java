package ir.mapsa.digikala.cart.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toEntity(CartDTO cartDTO);

    CartDTO toDTO(Cart cart);

    List<Cart> toEntities(List<CartDTO> cartDTOs);

    List<CartDTO> toDTOs(List<Cart> carts);


}
