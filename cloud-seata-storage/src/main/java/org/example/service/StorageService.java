package org.example.service;

import org.example.entities.Storage;
import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {

    Storage getById(Long id);

    void decrease(Long productId, Integer count);
}
