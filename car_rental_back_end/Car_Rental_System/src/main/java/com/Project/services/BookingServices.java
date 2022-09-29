package com.Project.services;

import java.util.List;

import com.Project.entities.Booking;
import com.Project.entities.User;

public interface BookingServices {
	Booking saveBooking (Booking booking);
	Booking findById (int id);
	List<Booking> findAllBookings();
	void deleteBooking (Booking booking);
	List<Booking> findAll();
	List<Booking> findByUser(User id);
	
}
