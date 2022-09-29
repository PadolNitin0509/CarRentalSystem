package com.Project.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.daos.BookingDao;
import com.Project.entities.Booking;
import com.Project.entities.User;


@Transactional
@Service

public class BookingServiceImpl implements BookingServices {
	
	
	@Autowired
	private BookingDao bookingDao;

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingDao.save(booking);
	}

	@Override
	public Booking findById(int id) {
		Optional<Booking> booking = bookingDao.findById(id);
		return booking.orElse(null) ;
	}

	@Override
	public List<Booking> findAllBookings() {
		return bookingDao.findAll();
	}

	@Override
	public void deleteBooking(Booking booking) {
		 bookingDao.delete(booking);
		
	}

	@Override
	public List<Booking> findAll() {
		return bookingDao.findAll();
	}

	@Override
	public List<Booking> findByUser(User id) {
		return bookingDao.findByUser(id);
	}

	
	
	

}
