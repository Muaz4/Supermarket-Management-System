/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

/**
 *
 * @author admin
 */
public class Report {
   String NAME,QUANTITY, PRICE, DAY;  

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public String getNAME() {
        return NAME;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getDAY() {
        return DAY;
    }

    public Report(String NAME, String QUANTITY, String PRICE, String DAY) {
        this.NAME = NAME;
        this.QUANTITY = QUANTITY;
        this.PRICE = PRICE;
        this.DAY = DAY;
    }
}
