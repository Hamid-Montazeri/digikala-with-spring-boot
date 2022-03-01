package ir.mapsa.digikala.cart.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends GenericMapper<Cart, CartDTO> {


}
