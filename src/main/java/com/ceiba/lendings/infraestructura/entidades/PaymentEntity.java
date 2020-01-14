package com.ceiba.lendings.infraestructura.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="payment")
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="paymentvalue")
    private Double paymentvalue;
    @Column(name="paymentdate")
    @Temporal(TemporalType.DATE)
    private Date paymentdate;

    @ManyToOne
    @JoinColumn(name="lendingid", nullable=false)
    private LendingEntity lendingid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPaymentvalue() {
        return paymentvalue;
    }

    public void setPaymentvalue(Double paymentvalue) {
        this.paymentvalue = paymentvalue;
    }

    public Date getPaymentdate() {
        return (Date)paymentdate.clone();
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = (Date)paymentdate.clone();
    }

    public LendingEntity getLendingid() {
        return lendingid;
    }

    public void setLendingid(LendingEntity lendingid) {
        this.lendingid = lendingid;
    }
}
