package com.Project.services;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Project.daos.BookingDao;
import com.Project.daos.PaymentRepository;
import com.Project.dto.BookingPayment;
import com.Project.entities.Booking;
import com.Project.entities.Payment;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Value("${Razorpay.key_id}")
	private String key_id;
	@Value("${Razorpay.key_secret}")
	private String key_secret;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private BookingDao bookingDao;

	@Override
	public Payment savePaymentDetails(BookingPayment pay) throws Exception {
		Booking booking = bookingDao.getById(4);
		Payment payment = new Payment();

		var client = new RazorpayClient(key_id, key_secret);
		JSONObject ob = new JSONObject();
		double amount = pay.getAmount() * 100;
//		double amount = 500 * 100;
		ob.put("amount", amount); // amount need to send on paise so thats why multiplied by 100
		ob.put("currency", "INR");
		ob.put("receipt", "txn_123");

		Order order = client.Orders.create(ob);
		Payment myOrderRecord = new Payment();
		String amt = (order.get("amount")).toString();
		myOrderRecord.setOrderId(order.get("id"));
		myOrderRecord.setAmount(Double.parseDouble(amt)/100);
		String amt_paid = (order.get("amount_paid")).toString();
		myOrderRecord.setAmount_paid(Double.parseDouble(amt_paid)/100);
		myOrderRecord.setStatus(order.get("status"));
		
		Payment persistPayment = paymentRepository.save(myOrderRecord);
		booking.setPayment(persistPayment);
//		appointment.setPayment(persistPayment);
		return myOrderRecord;
	}

	@Override
	public String updatePaymentDetails(BookingPayment payment) throws Exception {
		Booking booking = bookingDao.getById(4);
		booking.getPayment().setStatus("Paid");
		booking.getPayment().setRazorpayPaymentId(payment.getRazorpayPaymentId());
		booking.getPayment().setAmount_paid(booking.getPayment().getAmount());
		return "updated";
	}

}
