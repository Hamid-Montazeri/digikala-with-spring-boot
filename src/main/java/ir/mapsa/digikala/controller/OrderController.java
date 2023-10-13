package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.mapper.OrderMapper;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper mapper;

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(orderService.save(orderDTO)));
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(orderService.update(orderDTO, orderDTO.getId()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Order savedOrder = orderService.findById(id);
        OrderDTO orderDTO = mapper.toDto(savedOrder);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> orders = (List<Order>) orderService.findAll();
        List<OrderDTO> orderDTOs = mapper.toDTOs(orders);
        return ResponseEntity.ok(orderDTOs);
    }


}
