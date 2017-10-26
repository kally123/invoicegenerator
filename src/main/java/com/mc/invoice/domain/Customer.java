package com.mc.invoice.domain;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.springlets.format.EntityFormat;

/**
 * = Customer
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
public class Customer {

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
    private String customerName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String mobileNumber;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String dateOfBirth;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String emailId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String documentProof;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String addressLine1;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String addressLine2;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String cityName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
//    @OneToOne(fetch = FetchType.LAZY)
//    @EntityFormat
//    private CustomerBooking customerBooking;
    
  //bi-directional many-to-one association to CustomerBooking
  	@OneToMany(mappedBy="customer")
  	private List<CustomerBooking> customerBooking;

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
        if (!(obj instanceof Customer)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Customer) obj).getId());
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
     * @return String
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param mobileNumber
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEmailId() {
        return this.emailId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDocumentProof() {
        return this.documentProof;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param documentProof
     */
    public void setDocumentProof(String documentProof) {
        this.documentProof = documentProof;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getAddressLine1() {
        return this.addressLine1;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param addressLine1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getAddressLine2() {
        return this.addressLine2;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param addressLine2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerBooking
     */
    @JsonIgnore
    public List<CustomerBooking> getCustomerBooking() {
        return this.customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     */
    public void setCustomerBooking(List<CustomerBooking> customerBooking) {
        this.customerBooking = customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
		return customerName;
    }
}
