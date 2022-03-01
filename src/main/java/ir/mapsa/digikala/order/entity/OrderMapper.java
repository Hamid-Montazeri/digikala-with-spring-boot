package ir.mapsa.digikala.order.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {

}
