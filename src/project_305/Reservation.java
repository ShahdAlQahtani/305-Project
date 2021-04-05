/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.sql.Date;

/**
 *
 * @author karam
 */
public class Reservation {
    int idTenant ;
    int idHall;
    Date reserveDate;
    int Payment;

    public int getIdTenant() {
        return idTenant;
    }

    public int getIdHall() {
        return idHall;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public int getPayment() {
        return Payment;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public void setPayment(int Payment) {
        this.Payment = Payment;
    }
    
}
