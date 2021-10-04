package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.CommonResult;
import org.example.service.StorageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/seata/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Long id) {
        return new CommonResult(200, "success", storageService.getById(id));
    }

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "success");
    }
}
