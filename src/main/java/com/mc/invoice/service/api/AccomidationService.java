package com.mc.invoice.service.api;
import com.mc.invoice.domain.Accomidation;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.mc.invoice.domain.CustomerBooking;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = AccomidationService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Accomidation.class)
public interface AccomidationService extends EntityResolver<Accomidation, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Accomidation
     */
    public abstract Accomidation findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     */
    public abstract void delete(Accomidation accomidation);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Accomidation> save(Iterable<Accomidation> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Accomidation
     */
    public abstract Accomidation save(Accomidation entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Accomidation
     */
    public abstract Accomidation findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Accomidation> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Accomidation> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Accomidation> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Accomidation> findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @return Long
     */
    public abstract long countByCustomerBooking(CustomerBooking customerBooking);
}
