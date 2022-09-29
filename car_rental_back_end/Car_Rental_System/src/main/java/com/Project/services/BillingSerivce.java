package com.Project.services;

import java.util.List;

import com.Project.entities.Billing;

public interface BillingSerivce {
	Billing saveBilling (Billing billing);

	List<Billing> findAll();

}
