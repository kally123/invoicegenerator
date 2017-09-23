package com.mc.invoice.web;
import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = CustomerBookingsCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = CustomerBooking.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class CustomerBookingsCollectionThymeleafController {
}
