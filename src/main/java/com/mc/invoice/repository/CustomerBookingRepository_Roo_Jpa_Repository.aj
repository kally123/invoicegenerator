// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mc.invoice.repository;

import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.repository.CustomerBookingRepository;
import com.mc.invoice.repository.CustomerBookingRepositoryCustom;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CustomerBookingRepository_Roo_Jpa_Repository {
    
    declare parents: CustomerBookingRepository extends DetachableJpaRepository<CustomerBooking, Long>;
    
    declare parents: CustomerBookingRepository extends CustomerBookingRepositoryCustom;
    
    declare @type: CustomerBookingRepository: @Transactional(readOnly = true);
    
}
