// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mc.invoice.service.api;

import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.service.api.AccomidationService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect AccomidationService_Roo_Service {
    
    declare parents: AccomidationService extends EntityResolver<Accomidation, Long>;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Accomidation
     */
    public abstract Accomidation AccomidationService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param accomidation
     */
    public abstract void AccomidationService.delete(Accomidation accomidation);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Accomidation> AccomidationService.save(Iterable<Accomidation> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void AccomidationService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Accomidation
     */
    public abstract Accomidation AccomidationService.save(Accomidation entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Accomidation
     */
    public abstract Accomidation AccomidationService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Accomidation> AccomidationService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Accomidation> AccomidationService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long AccomidationService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Accomidation> AccomidationService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerBooking
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Accomidation> AccomidationService.findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerBooking
     * @return Long
     */
    public abstract long AccomidationService.countByCustomerBooking(CustomerBooking customerBooking);
    
}
