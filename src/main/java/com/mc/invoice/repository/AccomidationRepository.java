package com.mc.invoice.repository;

import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.mc.invoice.domain.CustomerBooking;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = AccomidationRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Accomidation.class)
@Transactional(readOnly = true)
public interface AccomidationRepository
		extends DetachableJpaRepository<Accomidation, Long>, AccomidationRepositoryCustom {

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param customerBooking
	 * @return Long
	 */
	public abstract long countByCustomerBooking(CustomerBooking customerBooking);
}
