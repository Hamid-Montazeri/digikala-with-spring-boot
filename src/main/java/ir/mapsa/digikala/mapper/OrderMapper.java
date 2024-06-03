package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface OrderMapper extends BaseMapper<Order, OrderDTO> {

}
