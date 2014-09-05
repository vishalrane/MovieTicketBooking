package org.cog.service;

import org.cog.model.BookingResponse;
import org.cog.model.ShowTime;

public interface MovieTicketBookingService {

	public BookingResponse bookTicket(ShowTime showTime, int noOfSeats);
	public int getNumberOfAvalTicket(ShowTime showTime);


}
