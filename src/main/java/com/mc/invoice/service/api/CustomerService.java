package com.mc.invoice.service.api;
import com.mc.invoice.domain.Customer;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.mc.invoice.domain.CustomerBooking;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Customer.class)
public interface CustomerService extends EntityResolver<Customer, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public abstract Customer findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public abstract void delete(Customer customer);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Customer> save(Iterable<Customer> entities);

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
     * @return Customer
     */
    public abstract Customer save(Customer entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public abstract Customer findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Customer> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Customer> findAll();

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
    public abstract Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable);

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
     * @param customerBooking
     * @return Long
     */
    public abstract long countByCustomerBooking(CustomerBooking customerBooking);
}
