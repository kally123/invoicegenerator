package com.mc.invoice.repository;
import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerBookingRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = CustomerBooking.class)
@Transactional(readOnly = true)
public interface CustomerBookingRepository extends DetachableJpaRepository<CustomerBooking, Long>, CustomerBookingRepositoryCustom {
}
