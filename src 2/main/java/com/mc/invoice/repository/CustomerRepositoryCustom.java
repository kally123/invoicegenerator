package com.mc.invoice.repository;
import com.mc.invoice.domain.Customer;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.mc.invoice.domain.CustomerBooking;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Customer.class)
public interface CustomerRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Customer> findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable);
}
