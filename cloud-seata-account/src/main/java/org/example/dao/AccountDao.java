package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    Account getById(@Param("id") Long id);

    int updateByCondition(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
