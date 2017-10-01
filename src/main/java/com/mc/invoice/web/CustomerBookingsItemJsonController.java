package com.mc.invoice.web;

import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.mc.invoice.service.api.CustomerBookingService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = CustomerBookingsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = CustomerBooking.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/customerbookings/{customerBooking}", name = "CustomerBookingsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerBookingsItemJsonController {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private CustomerBookingService customerBookingService;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param customerBookingService
	 */
	@Autowired
	public CustomerBookingsItemJsonController(CustomerBookingService customerBookingService) {
		this.customerBookingService = customerBookingService;
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
	 * @param id
	 * @return CustomerBooking
	 */
	@ModelAttribute
	public CustomerBooking getCustomerBooking(@PathVariable("customerBooking") Long id) {
		CustomerBooking customerBooking = customerBookingService.findOne(id);
		if (customerBooking == null) {
			throw new NotFoundException(String.format("CustomerBooking with identifier '%s' not found", id));
		}
		return customerBooking;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return ResponseEntity
	 */
	@GetMapping(name = "show")
	public ResponseEntity<?> show(@ModelAttribute CustomerBooking customerBooking) {
		return ResponseEntity.ok(customerBooking);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return UriComponents
	 */
	public static UriComponents showURI(CustomerBooking customerBooking) {
		return MvcUriComponentsBuilder
				.fromMethodCall(
						MvcUriComponentsBuilder.on(CustomerBookingsItemJsonController.class).show(customerBooking))
				.buildAndExpand(customerBooking.getId()).encode();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param storedCustomerBooking
	 * @param customerBooking
	 * @param result
	 * @return ResponseEntity
	 */
	@PutMapping(name = "update")
	public ResponseEntity<?> update(@ModelAttribute CustomerBooking storedCustomerBooking,
			@Valid @RequestBody CustomerBooking customerBooking, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		customerBooking.setId(storedCustomerBooking.getId());
		getCustomerBookingService().save(customerBooking);
		return ResponseEntity.ok().build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return ResponseEntity
	 */
	@DeleteMapping(name = "delete")
	public ResponseEntity<?> delete(@ModelAttribute CustomerBooking customerBooking) {
		getCustomerBookingService().delete(customerBooking);
		return ResponseEntity.ok().build();
	}
}
