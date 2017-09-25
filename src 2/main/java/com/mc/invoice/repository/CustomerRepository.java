package com.mc.invoice.repository;
import com.mc.invoice.domain.Customer;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.mc.invoice.domain.CustomerBooking;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Customer.class)
@Transactional(readOnly = true)
public interface CustomerRepository extends DetachableJpaRepository<Customer, Long>, CustomerRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @return Long
     */
    public abstract long countByCustomerBooking(CustomerBooking customerBooking);
}
