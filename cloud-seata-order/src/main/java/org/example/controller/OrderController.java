package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.CommonResult;
import org.example.model.OrderRequest;
import org.example.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/seata/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/")
    public CommonResult create(@Validated @RequestBody OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return new CommonResult(200, "success");
    }
}
