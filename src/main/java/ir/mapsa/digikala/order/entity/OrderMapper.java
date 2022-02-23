package ir.mapsa.digikala.order.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDTO orderDTO);

    OrderDTO toDTO(Order order);

    List<Order> toEntities(List<OrderDTO> orderDTOs);

    List<OrderDTO> toDTOs(List<Order> orders);

}
