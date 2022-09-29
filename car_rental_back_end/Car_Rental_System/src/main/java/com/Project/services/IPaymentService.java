package com.Project.services;

import com.Project.dto.BookingPayment;
import com.Project.entities.Payment;

public interface IPaymentService {
	Payment savePaymentDetails(BookingPayment payment) throws Exception;
	String updatePaymentDetails(BookingPayment payment) throws Exception;

}
