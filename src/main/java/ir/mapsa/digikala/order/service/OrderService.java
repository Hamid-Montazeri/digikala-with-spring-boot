package ir.mapsa.digikala.order.service;

import ir.mapsa.digikala.exception.ConflictException;
import ir.mapsa.digikala.exception.NotFoundException;
import ir.mapsa.digikala.order.entity.Order;
import ir.mapsa.digikala.order.entity.OrderMapper;
import ir.mapsa.digikala.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        if (orderRepository.existsById(order.getId())) {
            throw new ConflictException("The \"order\" with ID \"" + order.getId() + "\" already exists");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());

        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("The requested \"Order\" not found.");
        }

        Order savedOrder = optionalOrder.get();

        savedOrder.setStatus(order.getStatus());
        savedOrder.setDate(order.getDate());

        return savedOrder;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("The requested \"Order\" not found.");
        }

        return optionalOrder.get();
    }

    @Override
    @Cacheable(value = "order")
    public List<Order> getAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();

        if (orders.isEmpty()) {
            throw new NotFoundException("No \"Order\" found.");
        }

        return orders;
    }
}
