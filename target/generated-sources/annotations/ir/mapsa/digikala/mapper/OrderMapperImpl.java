package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T20:54:22+0430",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Order toEntity(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setStatus( dto.getStatus() );
        order.setDate( dto.getDate() );
        order.setUser( userMapper.toEntity( dto.getUser() ) );

        return order;
    }

    @Override
    public OrderDTO toDto(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( entity.getId() );
        orderDTO.setStatus( entity.getStatus() );
        orderDTO.setDate( entity.getDate() );
        orderDTO.setUser( userMapper.toDto( entity.getUser() ) );

        return orderDTO;
    }

    @Override
    public List<Order> toEntities(List<OrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtos.size() );
        for ( OrderDTO orderDTO : dtos ) {
            list.add( toEntity( orderDTO ) );
        }

        return list;
    }

    @Override
    public List<OrderDTO> toDTOs(List<Order> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( entities.size() );
        for ( Order order : entities ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Order entity, OrderDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getDate() != null ) {
            entity.setDate( dto.getDate() );
        }
        if ( dto.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new User() );
            }
            userMapper.partialUpdate( entity.getUser(), dto.getUser() );
        }
    }
}
