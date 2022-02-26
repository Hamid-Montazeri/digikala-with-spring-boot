package ir.mapsa.digikala.order.repository;

import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GenericRepository<Order, Long> {


}
