package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.mapper.OrderMapper;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDTO, Long> implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Override
    protected BaseRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    protected BaseMapper<Order, OrderDTO> getEntityMapper() {
        return mapper;
    }
}
