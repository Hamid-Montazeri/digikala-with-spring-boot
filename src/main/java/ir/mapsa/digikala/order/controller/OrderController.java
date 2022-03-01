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
import java.util.Optional;

@RestController
@RequestMapping("/orders")
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
        Order order = orderService.save(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderService.findById(orderDTO.getId());

        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("The requested \"Order\" not found.");
        }

        Order savedOrder = optionalOrder.get();

        savedOrder.setDate(orderDTO.getDate());
        savedOrder.setStatus(orderDTO.getStatus());

        Order updatedOrder = orderService.save(mapper.toDto(savedOrder));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedOrder);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody OrderDTO orderDTO) {
        orderService.deleteById(orderDTO.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderService.findById(id);

        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("The requested \"Order\" not found.");
        }

        OrderDTO orderDTO = mapper.toDto(optionalOrder.get());
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> orders = (List<Order>) orderService.findAll();
        List<OrderDTO> orderDTOs = mapper.toDTOs(orders);
        return ResponseEntity.ok(orderDTOs);
    }


}
