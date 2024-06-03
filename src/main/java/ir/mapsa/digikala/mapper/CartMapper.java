package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.dto.CartDTO;
import ir.mapsa.digikala.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface CartMapper extends BaseMapper<Cart, CartDTO> {

}
