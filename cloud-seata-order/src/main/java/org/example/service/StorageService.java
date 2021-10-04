package org.example.service;

import org.example.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${service.storage}")
public interface StorageService {

    @GetMapping(value = "/seata/storage/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    @PostMapping(value = "/seata/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
