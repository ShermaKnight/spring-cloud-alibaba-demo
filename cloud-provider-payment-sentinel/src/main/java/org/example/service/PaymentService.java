package org.example.service;

import org.example.entities.Payment;

import java.util.List;

public interface PaymentService {

    int create(Payment payment);

    Payment getById(Long id);

    List<Payment> get();

    int delete(Long id);
}
