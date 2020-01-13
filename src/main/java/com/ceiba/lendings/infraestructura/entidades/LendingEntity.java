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
    @Column(name="lendingtotalamount")
    private Double lendingtotalamount;
    @Column(name="lendingreturndate")
    @Temporal(TemporalType.DATE)
    private Date lendingreturndate;
    @Column(name="lendingvalue")
    private Double lendingvalue;
    @Column(name="lendingdate")
    @Temporal(TemporalType.DATE)
    private Date lendingdate;

    @OneToMany(mappedBy="lendingid")
    private Set<PaymentEntity> paymententity;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private ClientEntity clientid;

    public LendingEntity() {
    }

    public LendingEntity(Long id,Double lendingtotalamount, Date lendingreturndate,  Double lendingvalue, Date lendingdate) {
        this.id = id;
        this.lendingreturndate = (Date)lendingreturndate.clone();
        this.lendingtotalamount = lendingtotalamount;
        this.lendingvalue = lendingvalue;
        this.lendingdate = (Date)lendingdate.clone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLendingtotalamount() {
        return lendingtotalamount;
    }

    public void setLendingtotalamount(Double lendingtotalamount) {
        this.lendingtotalamount = lendingtotalamount;
    }

    public Date getLendingreturndate() {
        return (Date)lendingreturndate.clone();
    }

    public void setLendingreturndate(Date lendingreturndate) {
        this.lendingreturndate = (Date)lendingreturndate.clone();
    }

    public Double getLendingvalue() {
        return lendingvalue;
    }

    public void setLendingvalue(Double lendingvalue) {
        this.lendingvalue = lendingvalue;
    }

    public Date getLendingdate() {
        return (Date)lendingdate.clone();
    }

    public void setLendingdate(Date lendingdate) {
        this.lendingdate = (Date)lendingdate.clone();
    }

    public Set<PaymentEntity> getPaymententity() {
        return paymententity;
    }

    public void setPaymententity(Set<PaymentEntity> paymententity) {
        this.paymententity = paymententity;
    }

    public ClientEntity getClientid() {
        return clientid;
    }

    public void setClientid(ClientEntity clientid) {
        this.clientid = clientid;
    }
}
