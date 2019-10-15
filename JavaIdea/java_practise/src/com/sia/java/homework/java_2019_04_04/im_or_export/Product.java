package com.sia.java.homework.java_2019_04_04.im_or_export;

import java.util.Date;

public class Product {

        private String proID;
        private String proName;
        private double proPrice;
        private double proQuantity;
        private Date lastAltered;

        public Product() {
        }

        public Product( String proID, String proName, double proPrice, double proQuantity ) {
                this.proID = proID;
                this.proName = proName;
                this.proPrice = proPrice;
                this.proQuantity = proQuantity;
        }

        public String getProID() {
                return proID;
        }

        public void setProID(String proID) {
                this.proID = proID;
        }

        public String getProName() {
                return proName;
        }

        public void setProName(String proName) {
                this.proName = proName;
        }

        public double getProPrice() {
                return proPrice;
        }

        public void setProPrice(double proPrice) {
                this.proPrice = proPrice;
        }

        public double getProQuantity() {
                return proQuantity;
        }

        public void setProQuantity(int proQuantity) {
                this.proQuantity = proQuantity;
        }

        public Date getLastAltered() {
                return lastAltered;
        }

        public void setLastAltered(Date lastAltered) {
                this.lastAltered = lastAltered;
        }
}
