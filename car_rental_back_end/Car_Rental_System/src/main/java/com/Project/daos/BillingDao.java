package com.Project.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.entities.Billing;

public interface BillingDao extends JpaRepository<Billing, Integer> {
}
