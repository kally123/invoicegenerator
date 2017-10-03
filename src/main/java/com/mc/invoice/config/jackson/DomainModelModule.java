package com.mc.invoice.config.jackson;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.Customer;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.web.AccomidationJsonMixin;
import com.mc.invoice.web.CustomerBookingJsonMixin;
import com.mc.invoice.web.CustomerJsonMixin;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Accomidation.class, AccomidationJsonMixin.class);
        setMixInAnnotation(Customer.class, CustomerJsonMixin.class);
        setMixInAnnotation(CustomerBooking.class, CustomerBookingJsonMixin.class);
    }
}
