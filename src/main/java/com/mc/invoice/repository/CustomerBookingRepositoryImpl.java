package com.mc.invoice.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.CustomerBooking;

/**
 * = CustomerBookingRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = CustomerBookingRepositoryCustom.class)
public class CustomerBookingRepositoryImpl extends QueryDslRepositorySupportExt<CustomerBooking> {

    /**
     * TODO Auto-generated constructor documentation
     */
    CustomerBookingRepositoryImpl() {
        super(CustomerBooking.class);
    }
}