package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.mapper.OrderMapper;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;
    private final OrderMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.save(mapper.toEntity(orderDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody OrderDTO orderDTO) {
        Order updatedOrder = orderService.save(mapper.toEntity(orderDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedOrder);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody OrderDTO orderDTO) {
        orderService.deleteById(orderDTO.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Order savedOrder = orderService.findById(id).orElseThrow();
        OrderDTO orderDTO = mapper.toDto(savedOrder);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> orders = (List<Order>) orderService.findAll();
        List<OrderDTO> orderDTOs = mapper.toDTOs(orders);
        return ResponseEntity.ok(orderDTOs);
    }


}
