package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.AccountDao;
import org.example.entities.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Account getById(Long id) {
        return accountDao.getById(id);
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("减账户");
        accountDao.updateByCondition(userId, money);
    }
}
