// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mc.invoice.repository;

import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.repository.AccomidationRepository;
import com.mc.invoice.repository.AccomidationRepositoryCustom;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AccomidationRepository_Roo_Jpa_Repository {
    
    declare parents: AccomidationRepository extends DetachableJpaRepository<Accomidation, Long>;
    
    declare parents: AccomidationRepository extends AccomidationRepositoryCustom;
    
    declare @type: AccomidationRepository: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerBooking
     * @return Long
     */
    public abstract long AccomidationRepository.countByCustomerBooking(CustomerBooking customerBooking);
    
}
