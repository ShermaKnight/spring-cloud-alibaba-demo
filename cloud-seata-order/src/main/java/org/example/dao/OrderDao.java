package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.entities.Order;

@Mapper
public interface OrderDao {

    Order getById(Long id);

    void save(Order order);

    void updateStatus(Long id, Long userId, Integer status, Integer statusBefore);
}
