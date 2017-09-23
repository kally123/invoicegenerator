package com.mc.invoice.domain;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import com.mc.invoice.enumtype.AccomidationType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.NumberFormat;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * = Accomidation
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
public class Accomidation {

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
    @Enumerated
    private AccomidationType accomidationType;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Min(1L)
    @NumberFormat
    private Integer price;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private CustomerBooking customerBooking;

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
        if (!(obj instanceof Accomidation)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Accomidation) obj).getId());
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
     * @return AccomidationType
     */
    public AccomidationType getAccomidationType() {
        return this.accomidationType;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param accomidationType
     */
    public void setAccomidationType(AccomidationType accomidationType) {
        this.accomidationType = accomidationType;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerBooking
     */
    public CustomerBooking getCustomerBooking() {
        return this.customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerBooking
     */
    public void setCustomerBooking(CustomerBooking customerBooking) {
        this.customerBooking = customerBooking;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Accomidation {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", price='" + price + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }
}
