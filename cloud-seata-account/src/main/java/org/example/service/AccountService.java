package org.example.service;

import org.example.entities.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    Account getById(Long id);

    void decrease(Long userId, BigDecimal money);
}
