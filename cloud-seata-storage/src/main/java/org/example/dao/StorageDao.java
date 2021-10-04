package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.entities.Storage;

@Mapper
public interface StorageDao {

    Storage getById(Long id);

    int updateByCondition(Long productId, Integer count);
}
