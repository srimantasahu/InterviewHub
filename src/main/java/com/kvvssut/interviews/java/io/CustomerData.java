package com.kvvssut.interviews.java.io;

import java.io.Serializable;
import java.util.Date;

public class CustomerData implements Serializable {        // warns if serialVersionUID not explicitly defined

    private static final long serialVersionUID = 1L;

    private String customerName;
    private long customerId;
    private Date dob;

    @Override
    public String toString() {
        return "CustomerData [customerName=" + customerName + ", customerId="
               + customerId + ", dob=" + dob + "]";
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


}
