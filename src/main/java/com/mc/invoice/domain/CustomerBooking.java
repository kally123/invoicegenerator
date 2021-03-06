package com.mc.invoice.domain;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;


import io.springlets.format.EntityFormat;

/**
 * = CustomerBooking
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat
public class CustomerBooking {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
//    @OneToOne(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerBooking")
//    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
//    @EntityFormat
//    private Customer customer;
//
//    /**
//     * TODO Auto-generated attribute documentation
//     *
//     */
//    @OneToOne(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerBooking")
//    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
//    @EntityFormat
//    private Accomidation accomidation;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String organization;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String checkInDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String checkOutDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Min(1L)
    @NumberFormat
    private Integer noOfDays;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Min(1L)
    @NumberFormat
    private Integer noOfRooms;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String roomNumbers;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String specialInstructions;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer customerDiscount;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float amountAfterDiscount;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float sGst;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float cGst;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float totalAfterTaxPerRoom;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float finalAmountAfterTax;
    
  //bi-directional many-to-one association to User
  	@ManyToOne
  	@JoinColumn(name="customer_id")
  	private Customer customer;
  	
  //bi-directional many-to-one association to User
  	@ManyToOne
  	@JoinColumn(name="accomidation_id")
  	private Accomidation accomidation;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof CustomerBooking)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((CustomerBooking) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Accomidation
     */
    public Accomidation getAccomidation() {
        return this.accomidation;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     */
    public void setAccomidation(Accomidation accomidation) {
        this.accomidation = accomidation;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param checkInDate
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param checkOutDate
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getNoOfDays() {
        return this.noOfDays;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param noOfDays
     */
    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getNoOfRooms() {
        return this.noOfRooms;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param noOfRooms
     */
    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getRoomNumbers() {
        return this.roomNumbers;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param roomNumbers
     */
    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getSpecialInstructions() {
        return this.specialInstructions;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param specialInstructions
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getCustomerDiscount() {
        return this.customerDiscount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerDiscount
     */
    public void setCustomerDiscount(Integer customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getAmountAfterDiscount() {
        return this.amountAfterDiscount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param amountAfterDiscount
     */
    public void setAmountAfterDiscount(Float amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getSGst() {
        return this.sGst;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param sGst
     */
    public void setSGst(Float sGst) {
        this.sGst = sGst;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getCGst() {
        return this.cGst;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cGst
     */
    public void setCGst(Float cGst) {
        this.cGst = cGst;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getTotalAfterTaxPerRoom() {
        return this.totalAfterTaxPerRoom;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param totalAfterTaxPerRoom
     */
    public void setTotalAfterTaxPerRoom(Float totalAfterTaxPerRoom) {
        this.totalAfterTaxPerRoom = totalAfterTaxPerRoom;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getFinalAmountAfterTax() {
        return this.finalAmountAfterTax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param finalAmountAfterTax
     */
    public void setFinalAmountAfterTax(Float finalAmountAfterTax) {
        this.finalAmountAfterTax = finalAmountAfterTax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
		return "CustomerBooking {" + "id='" + id + '\'' + '\'' + ", noOfDays='" + noOfDays + '\'' + ", noOfRooms='"
				+ noOfRooms + "}";
    }

//    /**
//     * TODO Auto-generated method documentation
//     *
//     * @param customer
//     */
//    public void addToCustomer(Customer customer) {
//        if (customer == null) {
//            removeFromCustomer();
//        } else {
//            this.customer = customer;
//            customer.setCustomerBooking(this);
//        }
//    }
//
//    /**
//     * TODO Auto-generated method documentation
//     *
//     */
//    public void removeFromCustomer() {
//        if (this.customer != null) {
//            customer.setCustomerBooking(null);
//        }
//        this.customer = null;
//    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidation
     */
//    public void addToAccomidation(Accomidation accomidation) {
//        if (accomidation == null) {
//            removeFromAccomidation();
//        } else {
//            this.accomidation = accomidation;
//            accomidation.setCustomerBooking(this);
//        }
//    }
//
//    /**
//     * TODO Auto-generated method documentation
//     *
//     */
//    public void removeFromAccomidation() {
//        if (this.accomidation != null) {
//            accomidation.setCustomerBooking(null);
//        }
//        this.accomidation = null;
//    }
}
