package ir.mapsa.digikala.order.repository;

import ir.mapsa.digikala.order.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    @Override
    boolean existsById(Long id);



}
