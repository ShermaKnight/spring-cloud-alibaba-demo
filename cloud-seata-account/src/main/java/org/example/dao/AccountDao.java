package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.entities.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    Account getById(Long id);

    int updateByCondition(Long userId, BigDecimal money);
}
