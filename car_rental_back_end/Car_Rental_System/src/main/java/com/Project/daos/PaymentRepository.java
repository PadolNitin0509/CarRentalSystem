package com.Project.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
