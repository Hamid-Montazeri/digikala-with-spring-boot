package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CartMapper extends GenericMapper<Cart, CartDTO> {


}
