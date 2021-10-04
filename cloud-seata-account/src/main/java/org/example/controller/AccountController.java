package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.CommonResult;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/seata/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Long id) {
        return new CommonResult(200, "success", accountService.getById(id));
    }

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "success");
    }
}
