package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Storage;

@Mapper
public interface StorageDao {

    Storage getById(@Param("id") Long id);

    int updateByCondition(@Param("productId") Long productId, @Param("count") Integer count);
}
