package com.mc.invoice.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.domain.QCustomerBooking;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerBookingRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerBookingRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerBookingRepositoryImpl extends QueryDslRepositorySupportExt<CustomerBooking>
		implements CustomerBookingRepositoryCustom {

	/**
	 * TODO Auto-generated constructor documentation
	 */
	CustomerBookingRepositoryImpl() {
		super(CustomerBooking.class);
	}

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String TOTAL_PRICE = "totalPrice";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CUSTOMER = "customer";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String ACCOMIDATION = "accomidation";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String NO_OF_DAYS = "noOfDays";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String CUSTOMER_DISCOUNT = "customerDiscount";

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<CustomerBooking> findAll(GlobalSearch globalSearch, Pageable pageable) {
		QCustomerBooking customerBooking = QCustomerBooking.customerBooking;
		JPQLQuery<CustomerBooking> query = from(customerBooking);
		Path<?>[] paths = new Path<?>[] { customerBooking.customer, customerBooking.accomidation,
				customerBooking.noOfDays, customerBooking.totalPrice, customerBooking.customerDiscount };
		applyGlobalSearch(globalSearch, query, paths);
		AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER, customerBooking.customer)
				.map(ACCOMIDATION, customerBooking.accomidation).map(NO_OF_DAYS, customerBooking.noOfDays)
				.map(TOTAL_PRICE, customerBooking.totalPrice).map(CUSTOMER_DISCOUNT, customerBooking.customerDiscount);
		applyPagination(pageable, query, mapping);
		applyOrderById(query);
		return loadPage(query, pageable, customerBooking);
	}
}
