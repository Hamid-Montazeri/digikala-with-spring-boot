package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.OrderDTO;
import ir.mapsa.digikala.mapper.OrderMapper;
import ir.mapsa.digikala.model.Order;
import ir.mapsa.digikala.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController extends BaseController<Order, OrderDTO, Long> {

    private final OrderService orderService;
    private final OrderMapper orderMapper;


    @Override
    protected BaseService<Order, OrderDTO, Long> getBaseService() {
        return orderService;
    }

    @Override
    protected BaseMapper<Order, OrderDTO> getBaseMapper() {
        return orderMapper;
    }
}
