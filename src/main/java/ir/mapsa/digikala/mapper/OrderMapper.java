package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {

}
