package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Order;

import java.util.List;

@Mapper
public interface OrderDao {

    Order getById(@Param("id") Long id);

    List<Order> getByUserId(@Param("userId") Long userId);

    void save(Order order);

    void updateStatus(@Param("id") Long id, @Param("userId") Long userId, @Param("status") Integer status, @Param("statusBefore") Integer statusBefore);
}
