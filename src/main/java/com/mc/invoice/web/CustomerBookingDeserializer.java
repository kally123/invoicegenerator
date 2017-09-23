package com.mc.invoice.web;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.service.api.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = CustomerBookingDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = CustomerBooking.class)
public class CustomerBookingDeserializer extends JsonObjectDeserializer<CustomerBooking> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerBookingService customerBookingService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerBookingService
     * @param conversionService
     */
    @Autowired
    public CustomerBookingDeserializer(@Lazy CustomerBookingService customerBookingService, ConversionService conversionService) {
        this.customerBookingService = customerBookingService;
        this.conversionService = conversionService;
    }
}
