package com.mc.invoice.service.impl;

import com.mc.invoice.service.api.CustomerService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.repository.CustomerRepository;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CustomerService.class)
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private CustomerRepository customerRepository;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 * @param customerRepository
	 */
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		setCustomerRepository(customerRepository);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return CustomerRepository
	 */
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerRepository
	 */
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customer
	 */
	@Transactional
	public void delete(Customer customer) {
		getCustomerRepository().delete(customer);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entities
	 * @return List
	 */
	@Transactional
	public List<Customer> save(Iterable<Customer> entities) {
		return getCustomerRepository().save(entities);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 */
	@Transactional
	public void delete(Iterable<Long> ids) {
		List<Customer> toDelete = getCustomerRepository().findAll(ids);
		getCustomerRepository().deleteInBatch(toDelete);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param entity
	 * @return Customer
	 */
	@Transactional
	public Customer save(Customer entity) {
		return getCustomerRepository().save(entity);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return Customer
	 */
	public Customer findOne(Long id) {
		return getCustomerRepository().findOne(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param id
	 * @return Customer
	 */
	public Customer findOneForUpdate(Long id) {
		return getCustomerRepository().findOneDetached(id);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @return List
	 */
	public List<Customer> findAll(Iterable<Long> ids) {
		return getCustomerRepository().findAll(ids);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return List
	 */
	public List<Customer> findAll() {
		return getCustomerRepository().findAll();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Long
	 */
	public long count() {
		return getCustomerRepository().count();
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable) {
		return getCustomerRepository().findAll(globalSearch, pageable);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Customer> findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch,
			Pageable pageable) {
		return getCustomerRepository().findByCustomerBooking(customerBooking, globalSearch, pageable);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return Long
	 */
	public long countByCustomerBooking(CustomerBooking customerBooking) {
		return getCustomerRepository().countByCustomerBooking(customerBooking);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return Class
	 */
	public Class<Customer> getEntityType() {
		return Customer.class;
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
