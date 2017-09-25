package com.mc.invoice.service.api;
import com.mc.invoice.domain.CustomerBooking;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerBookingService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = CustomerBooking.class)
public interface CustomerBookingService extends EntityResolver<CustomerBooking, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerBooking
     */
    public abstract CustomerBooking findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     */
    public abstract void delete(CustomerBooking customerBooking);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<CustomerBooking> save(Iterable<CustomerBooking> entities);

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
     * @return CustomerBooking
     */
    public abstract CustomerBooking save(CustomerBooking entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerBooking
     */
    public abstract CustomerBooking findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<CustomerBooking> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<CustomerBooking> findAll();

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
    public abstract Page<CustomerBooking> findAll(GlobalSearch globalSearch, Pageable pageable);
}
