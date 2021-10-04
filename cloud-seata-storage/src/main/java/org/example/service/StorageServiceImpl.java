package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.StorageDao;
import org.example.entities.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public Storage getById(Long id) {
        return storageDao.getById(id);
    }

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("减库存");
        storageDao.updateByCondition(productId, count);
    }
}
