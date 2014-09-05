package org.cog.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cog.model.BookingResponse;
import org.cog.model.Message;
import org.cog.model.ShowTime;
import org.cog.service.MovieTicketBookingService;
import org.cog.service.impl.ShowTicketBooking;

@Path("/movieTicketServices")
public class MovieTicketBookingRestService {
	
	 @GET
	  @Path("/checkAval/{showTime}")  
	 @Produces(MediaType.APPLICATION_JSON)  
	  public Response getNumberOfAvalTicket(@PathParam("showTime") String showTime) {
			MovieTicketBookingService bookingManager = new ShowTicketBooking();
			int noOfSeatAvailable = bookingManager.getNumberOfAvalTicket(ShowTime.valueOf(showTime));
			Map<String,String> response = new HashMap<String,String>();
			response.put("MESSAGE", noOfSeatAvailable+" Seats are Available.");
			return Response.ok(response, MediaType.APPLICATION_JSON_TYPE).build();
	  }
	  
	  @POST
	  @Path("bookTicket")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces( MediaType.APPLICATION_JSON )
	  public Map<String,String> bookTicket(Message message) {
			MovieTicketBookingService bookingManager = new ShowTicketBooking();
			BookingResponse response  = bookingManager.bookTicket(message.getShowTime(), message.getNoOfSeat());
			Map<String,String> returnResponse = new HashMap<String,String>();
			if(response.getStatusCode() == 200){
				returnResponse.put("MESSAGE", "Your Seats Nos. are "+response.getAllocatedSeats().toString());
			}else{
				returnResponse.put("MESSAGE", "Not Able to book ticket. There are "+response.getNoOfAvaibleSeat()+" Available.");
			}
			
			return returnResponse;
	  }
	  
}
