package com.mc.invoice.web;
import com.mc.invoice.domain.Customer;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mc.invoice.domain.CustomerBooking;

/**
 * = CustomerJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Customer.class)
public abstract class CustomerJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = CustomerBookingDeserializer.class)
    private CustomerBooking customerBooking;

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerBooking
     */
    public CustomerBooking getCustomerBooking() {
        return customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     */
    public void setCustomerBooking(CustomerBooking customerBooking) {
        this.customerBooking = customerBooking;
    }
}
