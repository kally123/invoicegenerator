package com.mc.invoice.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.Accomidation;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.domain.QAccomidation;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = AccomidationRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = AccomidationRepositoryCustom.class)
@Transactional(readOnly = true)
public class AccomidationRepositoryImpl extends QueryDslRepositorySupportExt<Accomidation> implements AccomidationRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    AccomidationRepositoryImpl() {
        super(Accomidation.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ACCOMIDATION_PRICE = "accomidationPrice";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ACCOMIDATION_TYPE = "accomidationType";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CUSTOMER_BOOKING = "customerBooking";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Accomidation> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QAccomidation accomidation = QAccomidation.accomidation;
        JPQLQuery<Accomidation> query = from(accomidation);
        Path<?>[] paths = new Path<?>[] { accomidation.accomidationType, accomidation.accomidationPrice, accomidation.customerBooking };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ACCOMIDATION_TYPE, accomidation.accomidationType).map(ACCOMIDATION_PRICE, accomidation.accomidationPrice).map(CUSTOMER_BOOKING, accomidation.customerBooking);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, accomidation);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Accomidation> findByCustomerBooking(CustomerBooking customerBooking, GlobalSearch globalSearch, Pageable pageable) {
        QAccomidation accomidation = QAccomidation.accomidation;
        JPQLQuery<Accomidation> query = from(accomidation);
        Assert.notNull(customerBooking, "customerBooking is required");
        query.where(accomidation.customerBooking.eq(customerBooking));
        Path<?>[] paths = new Path<?>[] { accomidation.accomidationType, accomidation.accomidationPrice, accomidation.customerBooking };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ACCOMIDATION_TYPE, accomidation.accomidationType).map(ACCOMIDATION_PRICE, accomidation.accomidationPrice).map(CUSTOMER_BOOKING, accomidation.customerBooking);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, accomidation);
    }
}
