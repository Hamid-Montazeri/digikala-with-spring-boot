package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {


}
