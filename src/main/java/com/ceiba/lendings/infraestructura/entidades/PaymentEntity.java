package com.ceiba.lendings.infraestructura.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Table(name="payment")
public class PaymentEntity {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="payment_value")
    private Integer payment_value;
    @Column(name="payment_date")
    private Date payment_date;

    @ManyToOne
    @JoinColumn(name="lending_id", nullable=false)
    private LendingEntity lending_id;

    public PaymentEntity() {
    }

    public PaymentEntity(Integer id, Integer payment_value, Date payment_date) {
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

    public Integer getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Integer payment_value) {
        this.payment_value = payment_value;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", payment_value=" + payment_value +
                ", payment_date=" + payment_date +
                '}';
    }
}
