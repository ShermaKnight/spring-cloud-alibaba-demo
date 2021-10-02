package org.example.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.dao.PaymentDao;
import org.example.entities.Payment;
import org.example.handler.BlockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@SuppressWarnings("all")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }

    @Override
    public List<Payment> get() {
        return paymentDao.get();
    }

    @Override
    public int delete(Long id) {
        return paymentDao.delete(id);
    }
}
