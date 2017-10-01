package com.mc.invoice.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.domain.QCustomer;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = CustomerRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerRepositoryImpl extends QueryDslRepositorySupportExt<Customer> implements CustomerRepositoryCustom {

	/**
	 * TODO Auto-generated constructor documentation
	 */
	CustomerRepositoryImpl() {
		super(Customer.class);
	}

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String DOCUMENT_PROOF = "documentProof";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CUSTOMER_NAME = "customerName";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String ADDRESS_LINE_1 = "addressLine1";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String COUNTRY = "country";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String MOBILE_NUMBER = "mobileNumber";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String ADDRESS_LINE_2 = "addressLine2";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CITY_NAME = "cityName";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String EMAIL_ID = "emailId";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String DATE_OF_BIRTH = "dateOfBirth";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CUSTOMER_BOOKING = "customerBooking";

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable) {
		QCustomer customer = QCustomer.customer;
		JPQLQuery<Customer> query = from(customer);
		Path<?>[] paths = new Path<?>[] { customer.customerName, customer.mobileNumber, customer.dateOfBirth,
				customer.emailId, customer.documentProof, customer.addressLine1, customer.addressLine2,
				customer.cityName, customer.country, customer.customerBooking };
		applyGlobalSearch(globalSearch, query, paths);
		AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_NAME, customer.customerName)
				.map(MOBILE_NUMBER, customer.mobileNumber).map(DATE_OF_BIRTH, customer.dateOfBirth)
				.map(EMAIL_ID, customer.emailId).map(DOCUMENT_PROOF, customer.documentProof)
				.map(ADDRESS_LINE_1, customer.addressLine1).map(ADDRESS_LINE_2, customer.addressLine2)
				.map(CITY_NAME, customer.cityName).map(COUNTRY, customer.country)
				.map(CUSTOMER_BOOKING, customer.customerBooking);
		applyPagination(pageable, query, mapping);
		applyOrderById(query);
		return loadPage(query, pageable, customer);
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
		QCustomer customer = QCustomer.customer;
		JPQLQuery<Customer> query = from(customer);
		Assert.notNull(customerBooking, "customerBooking is required");
		query.where(customer.customerBooking.eq(customerBooking));
		Path<?>[] paths = new Path<?>[] { customer.customerName, customer.mobileNumber, customer.dateOfBirth,
				customer.emailId, customer.documentProof, customer.addressLine1, customer.addressLine2,
				customer.cityName, customer.country, customer.customerBooking };
		applyGlobalSearch(globalSearch, query, paths);
		AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_NAME, customer.customerName)
				.map(MOBILE_NUMBER, customer.mobileNumber).map(DATE_OF_BIRTH, customer.dateOfBirth)
				.map(EMAIL_ID, customer.emailId).map(DOCUMENT_PROOF, customer.documentProof)
				.map(ADDRESS_LINE_1, customer.addressLine1).map(ADDRESS_LINE_2, customer.addressLine2)
				.map(CITY_NAME, customer.cityName).map(COUNTRY, customer.country)
				.map(CUSTOMER_BOOKING, customer.customerBooking);
		applyPagination(pageable, query, mapping);
		applyOrderById(query);
		return loadPage(query, pageable, customer);
	}
}
