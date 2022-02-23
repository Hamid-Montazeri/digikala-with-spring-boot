package ir.mapsa.digikala.order.controller;

import ir.mapsa.digikala.order.entity.Order;
import ir.mapsa.digikala.order.entity.OrderDTO;
import ir.mapsa.digikala.order.entity.OrderMapper;
import ir.mapsa.digikala.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;
    private final OrderMapper mapper;

    @Autowired
    public OrderController(IOrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.save(mapper.toEntity(orderDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody OrderDTO orderDTO) {
        Order order = mapper.toEntity(orderDTO);
        Order updatedOrder = orderService.update(order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedOrder);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody OrderDTO orderDTO) {
        orderService.deleteById(orderDTO.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        OrderDTO orderDTO = mapper.toDTO(order);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderDTO> orderDTOs = mapper.toDTOs(orders);
        return ResponseEntity.ok(orderDTOs);
    }


}
