package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Order;

@Mapper
public interface OrderDao {

    Order getById(@Param("id") Long id);

    void save(Order order);

    void updateStatus(@Param("id") Long id, @Param("userId") Long userId, @Param("status") Integer status, @Param("statusBefore") Integer statusBefore);
}
