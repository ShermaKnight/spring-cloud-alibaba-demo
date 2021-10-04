package org.example.service;

import org.example.entities.Order;
import org.example.model.OrderRequest;
import org.example.model.OrderResponse;

import java.util.List;

public interface OrderService {

    void create(OrderRequest orderRequest);

    OrderResponse get(Long id);

    List<OrderResponse> list();
}
