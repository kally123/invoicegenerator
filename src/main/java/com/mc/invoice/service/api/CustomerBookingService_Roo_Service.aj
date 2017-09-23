// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mc.invoice.service.api;

import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.service.api.CustomerBookingService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect CustomerBookingService_Roo_Service {
    
    declare parents: CustomerBookingService extends EntityResolver<CustomerBooking, Long>;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return CustomerBooking
     */
    public abstract CustomerBooking CustomerBookingService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerBooking
     */
    public abstract void CustomerBookingService.delete(CustomerBooking customerBooking);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<CustomerBooking> CustomerBookingService.save(Iterable<CustomerBooking> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void CustomerBookingService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return CustomerBooking
     */
    public abstract CustomerBooking CustomerBookingService.save(CustomerBooking entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return CustomerBooking
     */
    public abstract CustomerBooking CustomerBookingService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<CustomerBooking> CustomerBookingService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<CustomerBooking> CustomerBookingService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long CustomerBookingService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerBooking> CustomerBookingService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
}
