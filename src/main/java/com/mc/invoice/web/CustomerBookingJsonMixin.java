package com.mc.invoice.web;

import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

/**
 * = CustomerBookingJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = CustomerBooking.class)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public abstract class CustomerBookingJsonMixin {
}
