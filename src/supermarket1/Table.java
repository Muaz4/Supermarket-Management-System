/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

/**
 *
 * @author admin
 */
public class Table {
  
   int PRODUCT_ID;
   String NAME, CATEGORY, QUANTITY, PRICE;

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public Table(int PRODUCT_ID, String NAME, String CATEGORY, String QUANTITY, String PRICE) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.NAME = NAME;
        this.CATEGORY = CATEGORY;
        this.QUANTITY = QUANTITY;
        this.PRICE = PRICE;
    }
    
}
