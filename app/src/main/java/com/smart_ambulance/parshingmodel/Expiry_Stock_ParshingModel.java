package com.smart_ambulance.parshingmodel;

/**
 * Created by admin on 17-Apr-18.
 */

public class Expiry_Stock_ParshingModel {
    private String particularName;
    private String quantity;
    private String expiryDate;

    public Expiry_Stock_ParshingModel(String particularName, String quantity, String expiryDate) {
        this.particularName = particularName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getParticularName() {
        return particularName;
    }

    public void setParticularName(String particularName) {
        this.particularName = particularName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
