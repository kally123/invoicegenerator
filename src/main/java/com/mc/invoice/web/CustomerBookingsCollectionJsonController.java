package com.mc.invoice.web;

import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.mc.invoice.service.api.CustomerBookingService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = CustomerBookingsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = CustomerBooking.class, type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/customerbookings", name = "CustomerBookingsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerBookingsCollectionJsonController {

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
	public CustomerBookingsCollectionJsonController(CustomerBookingService customerBookingService) {
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
	 * @param globalSearch
	 * @param pageable
	 * @return ResponseEntity
	 */
	@GetMapping(name = "list")
	public ResponseEntity<Page<CustomerBooking>> list(GlobalSearch globalSearch, Pageable pageable) {
		Page<CustomerBooking> customerBookings = getCustomerBookingService().findAll(globalSearch, pageable);
		return ResponseEntity.ok(customerBookings);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return UriComponents
	 */
	public static UriComponents listURI() {
		return MvcUriComponentsBuilder
				.fromMethodCall(
						MvcUriComponentsBuilder.on(CustomerBookingsCollectionJsonController.class).list(null, null))
				.build().encode();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @param result
	 * @return ResponseEntity
	 */
	@PostMapping(name = "create")
	public ResponseEntity<?> create(@Valid @RequestBody CustomerBooking customerBooking, BindingResult result) {
		if (customerBooking.getId() != null || customerBooking.getVersion() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		CustomerBooking newCustomerBooking = getCustomerBookingService().save(customerBooking);
		UriComponents showURI = CustomerBookingsItemJsonController.showURI(newCustomerBooking);
		return ResponseEntity.created(showURI.toUri()).build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBookings
	 * @param result
	 * @return ResponseEntity
	 */
	@PostMapping(value = "/batch", name = "createBatch")
	public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<CustomerBooking> customerBookings,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		getCustomerBookingService().save(customerBookings);
		return ResponseEntity.created(listURI().toUri()).build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBookings
	 * @param result
	 * @return ResponseEntity
	 */
	@PutMapping(value = "/batch", name = "updateBatch")
	public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<CustomerBooking> customerBookings,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
		}
		getCustomerBookingService().save(customerBookings);
		return ResponseEntity.ok().build();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @return ResponseEntity
	 */
	@DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
	public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
		getCustomerBookingService().delete(ids);
		return ResponseEntity.ok().build();
	}
}
