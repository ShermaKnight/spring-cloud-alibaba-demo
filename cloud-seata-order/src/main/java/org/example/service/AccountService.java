package org.example.service;

import org.example.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "${service.account}")
public interface AccountService {

    @GetMapping(value = "/seata/account/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    @PostMapping(value = "/seata/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
