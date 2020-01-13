package com.ceiba.lendings.infraestructura.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="lending")
public class LendingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="lending_total_amount")
    private Double lending_total_amount;
    @Column(name="lending_return_date")
    @Temporal(TemporalType.DATE)
    private Date lending_return_date;
    @Column(name="lending_value")
    private Double lending_value;
    @Column(name="lending_date")
    @Temporal(TemporalType.DATE)
    private Date lending_date;

    @OneToMany(mappedBy="lending_id")
    private Set<PaymentEntity> paymententity;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private ClientEntity client_id;

    public LendingEntity() {
    }

    public LendingEntity(Long id,Double lending_total_amount, Date lending_return_date,  Double lending_value, Date lending_date) {
        this.id = id;
        this.lending_return_date = (Date)lending_return_date.clone();
        this.lending_total_amount = lending_total_amount;
        this.lending_value = lending_value;
        this.lending_date = (Date)lending_date.clone();
    }

    public Double getLending_total_amount() {
        return lending_total_amount;
    }

    public void setLending_total_amount(Double lending_total_amount) {
        this.lending_total_amount = lending_total_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLending_return_date() {
        return (Date)lending_return_date.clone();
    }

    public void setLending_return_date(Date lending_return_date) {
        this.lending_return_date = lending_return_date;
    }

    public Double getLending_value() {
        return lending_value;
    }

    public void setLending_value(Double lending_value) {
        this.lending_value = lending_value;
    }

    public Date getLending_date() {
        return (Date)lending_date.clone();
    }

    public void setLending_date(Date lending_date) {
        this.lending_date = lending_date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ClientEntity getClient_id() {
        return client_id;
    }

    public void setClient_id(ClientEntity client_id) {
        this.client_id= client_id;
    }
}
