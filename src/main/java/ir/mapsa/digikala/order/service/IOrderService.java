package ir.mapsa.digikala.order.service;


import ir.mapsa.digikala.order.entity.Order;

import java.util.List;

public interface IOrderService {

    Order save(Order order);

    Order update(Order order);

    void deleteById(Long id);

    Order getById(Long id);

    List<Order> getAllOrders();


}
