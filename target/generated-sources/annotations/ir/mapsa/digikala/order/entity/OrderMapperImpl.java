package ir.mapsa.digikala.order.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-24T01:20:09+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setStatus( orderDTO.getStatus() );
        order.setDate( orderDTO.getDate() );

        return order;
    }

    @Override
    public OrderDTO toDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setStatus( order.getStatus() );
        orderDTO.setDate( order.getDate() );

        return orderDTO;
    }

    @Override
    public List<Order> toEntities(List<OrderDTO> orderDTOs) {
        if ( orderDTOs == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDTOs.size() );
        for ( OrderDTO orderDTO : orderDTOs ) {
            list.add( toEntity( orderDTO ) );
        }

        return list;
    }

    @Override
    public List<OrderDTO> toDTOs(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( orders.size() );
        for ( Order order : orders ) {
            list.add( toDTO( order ) );
        }

        return list;
    }
}
