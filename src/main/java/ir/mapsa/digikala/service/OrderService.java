package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.mapper.OrderMapper;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericServiceImpl<Order, OrderDTO, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    protected GenericRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    protected GenericMapper<Order, OrderDTO> getEntityMapper() {
        return mapper;
    }
}
