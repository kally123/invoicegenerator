package com.mc.invoice.web;

import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mc.invoice.domain.CustomerBooking;

/**
 * = AccomidationJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Accomidation.class)
public abstract class AccomidationJsonMixin {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@JsonDeserialize(using = CustomerBookingDeserializer.class)
	private CustomerBooking customerBooking;

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return CustomerBooking
	 */
	public CustomerBooking getCustomerBooking() {
		return customerBooking;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 */
	public void setCustomerBooking(CustomerBooking customerBooking) {
		this.customerBooking = customerBooking;
	}
}
