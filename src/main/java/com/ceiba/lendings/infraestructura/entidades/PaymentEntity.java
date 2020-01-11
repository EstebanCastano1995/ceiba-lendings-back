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
    private Integer id;
    @Column(name="payment_value")
    private Double payment_value;
    @Column(name="payment_date")
    @Temporal(TemporalType.DATE)
    private Date payment_date;

    @ManyToOne
    @JoinColumn(name="lending_id", nullable=false)
    private LendingEntity lending_id;

    public PaymentEntity() {
    }

    public PaymentEntity(Integer id, Double payment_value, Date payment_date) {
        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = payment_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Double payment_value) {
        this.payment_value = payment_value;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public LendingEntity getLending_id() {
        return lending_id;
    }

    public void setLending_id(LendingEntity lending_id) {
        this.lending_id = lending_id;
    }
}
