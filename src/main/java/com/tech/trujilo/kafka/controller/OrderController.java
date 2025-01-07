package com.tech.trujilo.kafka.controller;

import com.tech.trujilo.kafka.record.OrderRecord;
import com.tech.trujilo.kafka.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRecord order){
        orderService.sendMessageOrder(order);
    }
}
