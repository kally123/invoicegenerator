package com.mc.invoice.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.mc.invoice.domain.CustomerBooking;
import com.mc.invoice.domain.QCustomerBooking;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerBookingRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerBookingRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerBookingRepositoryImpl extends QueryDslRepositorySupportExt<CustomerBooking> implements CustomerBookingRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CustomerBookingRepositoryImpl() {
        super(CustomerBooking.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String S_GST = "sGst";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CHECK_IN_DATE = "checkInDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FINAL_AMOUNT_AFTER_TAX = "finalAmountAfterTax";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ACCOMIDATION = "accomidation";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NO_OF_DAYS = "noOfDays";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CUSTOMER_DISCOUNT = "customerDiscount";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SPECIAL_INSTRUCTIONS = "specialInstructions";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ORGANIZATION = "organization";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String C_GST = "cGst";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ROOM_NUMBERS = "roomNumbers";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String AMOUNT_AFTER_DISCOUNT = "amountAfterDiscount";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CUSTOMER = "customer";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CHECK_OUT_DATE = "checkOutDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NO_OF_ROOMS = "noOfRooms";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TOTAL_AFTER_TAX_PER_ROOM = "totalAfterTaxPerRoom";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerBooking> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCustomerBooking customerBooking = QCustomerBooking.customerBooking;
        JPQLQuery<CustomerBooking> query = from(customerBooking);
        Path<?>[] paths = new Path<?>[] { customerBooking.customer, customerBooking.accomidation, customerBooking.organization, customerBooking.checkInDate, customerBooking.checkOutDate, customerBooking.noOfDays, customerBooking.noOfRooms, customerBooking.roomNumbers, customerBooking.specialInstructions, customerBooking.customerDiscount, customerBooking.amountAfterDiscount, customerBooking.sGst, customerBooking.cGst, customerBooking.totalAfterTaxPerRoom, customerBooking.finalAmountAfterTax };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER, customerBooking.customer).map(ACCOMIDATION, customerBooking.accomidation).map(ORGANIZATION, customerBooking.organization).map(CHECK_IN_DATE, customerBooking.checkInDate).map(CHECK_OUT_DATE, customerBooking.checkOutDate).map(NO_OF_DAYS, customerBooking.noOfDays).map(NO_OF_ROOMS, customerBooking.noOfRooms).map(ROOM_NUMBERS, customerBooking.roomNumbers).map(SPECIAL_INSTRUCTIONS, customerBooking.specialInstructions).map(CUSTOMER_DISCOUNT, customerBooking.customerDiscount).map(AMOUNT_AFTER_DISCOUNT, customerBooking.amountAfterDiscount).map(S_GST, customerBooking.sGst).map(C_GST, customerBooking.cGst).map(TOTAL_AFTER_TAX_PER_ROOM, customerBooking.totalAfterTaxPerRoom).map(FINAL_AMOUNT_AFTER_TAX, customerBooking.finalAmountAfterTax);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerBooking);
    }
}
