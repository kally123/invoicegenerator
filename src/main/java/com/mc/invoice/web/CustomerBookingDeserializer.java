package com.mc.invoice.web;

import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.service.api.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = CustomerBookingDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = CustomerBooking.class)
@JsonComponent
public class CustomerBookingDeserializer extends JsonObjectDeserializer<CustomerBooking> {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private CustomerBookingService customerBookingService;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private ConversionService conversionService;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param customerBookingService
	 * @param conversionService
	 */
	@Autowired
	public CustomerBookingDeserializer(@Lazy CustomerBookingService customerBookingService,
			ConversionService conversionService) {
		this.customerBookingService = customerBookingService;
		this.conversionService = conversionService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return CustomerBookingService
	 */
	public CustomerBookingService getCustomerBookingService() {
		return customerBookingService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBookingService
	 */
	public void setCustomerBookingService(CustomerBookingService customerBookingService) {
		this.customerBookingService = customerBookingService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return ConversionService
	 */
	public ConversionService getConversionService() {
		return conversionService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param conversionService
	 */
	public void setConversionService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param jsonParser
	 * @param context
	 * @param codec
	 * @param tree
	 * @return CustomerBooking
	 * @throws IOException
	 */
	public CustomerBooking deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec,
			JsonNode tree) {
		String idText = tree.asText();
		Long id = conversionService.convert(idText, Long.class);
		CustomerBooking customerBooking = customerBookingService.findOne(id);
		if (customerBooking == null) {
			throw new NotFoundException("CustomerBooking not found");
		}
		return customerBooking;
	}
}
