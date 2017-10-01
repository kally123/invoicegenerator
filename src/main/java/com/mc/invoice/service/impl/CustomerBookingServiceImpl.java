package com.mc.invoice.service.impl;

import com.mc.invoice.service.api.CustomerBookingService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.repository.CustomerBookingRepository;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerBookingServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CustomerBookingService.class)
@Service
@Transactional(readOnly = true)
public class CustomerBookingServiceImpl implements CustomerBookingService {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private CustomerBookingRepository customerBookingRepository;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param customerBookingRepository
	 */
	@Autowired
	public CustomerBookingServiceImpl(CustomerBookingRepository customerBookingRepository) {
		setCustomerBookingRepository(customerBookingRepository);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return CustomerBookingRepository
	 */
	public CustomerBookingRepository getCustomerBookingRepository() {
		return customerBookingRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBookingRepository
	 */
	public void setCustomerBookingRepository(CustomerBookingRepository customerBookingRepository) {
		this.customerBookingRepository = customerBookingRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 */
	@Transactional
	public void delete(CustomerBooking customerBooking) {
		// Clear bidirectional one-to-one parent relationship with Accomidation
		customerBooking.removeFromAccomidation();
		// Clear bidirectional one-to-one parent relationship with Customer
		customerBooking.removeFromCustomer();
		getCustomerBookingRepository().delete(customerBooking);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entities
	 * @return List
	 */
	@Transactional
	public List<CustomerBooking> save(Iterable<CustomerBooking> entities) {
		return getCustomerBookingRepository().save(entities);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 */
	@Transactional
	public void delete(Iterable<Long> ids) {
		List<CustomerBooking> toDelete = getCustomerBookingRepository().findAll(ids);
		getCustomerBookingRepository().deleteInBatch(toDelete);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entity
	 * @return CustomerBooking
	 */
	@Transactional
	public CustomerBooking save(CustomerBooking entity) {
		// Ensure the relationships are maintained
		entity.addToAccomidation(entity.getAccomidation());
		entity.addToCustomer(entity.getCustomer());
		return getCustomerBookingRepository().save(entity);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return CustomerBooking
	 */
	public CustomerBooking findOne(Long id) {
		return getCustomerBookingRepository().findOne(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return CustomerBooking
	 */
	public CustomerBooking findOneForUpdate(Long id) {
		return getCustomerBookingRepository().findOneDetached(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @return List
	 */
	public List<CustomerBooking> findAll(Iterable<Long> ids) {
		return getCustomerBookingRepository().findAll(ids);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return List
	 */
	public List<CustomerBooking> findAll() {
		return getCustomerBookingRepository().findAll();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Long
	 */
	public long count() {
		return getCustomerBookingRepository().count();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<CustomerBooking> findAll(GlobalSearch globalSearch, Pageable pageable) {
		return getCustomerBookingRepository().findAll(globalSearch, pageable);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<CustomerBooking> getEntityType() {
		return CustomerBooking.class;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<Long> getIdType() {
		return Long.class;
	}
}
