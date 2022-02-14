/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket1;

/**
 *
 * @author admin
 */
public class SellerTbl {
  int SALARY;
 String SELLERID, NAME, PASSWORD, GENDER;

    public void setSALARY(int SALARY) {
        this.SALARY = SALARY;
    }

    public void setSELLERID(String SELLERID) {
        this.SELLERID = SELLERID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public int getSALARY() {
        return SALARY;
    }

    public String getSELLERID() {
        return SELLERID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getGENDER() {
        return GENDER;
    }

    public SellerTbl(int SALARY, String SELLERID, String NAME, String PASSWORD, String GENDER) {
        this.SALARY = SALARY;
        this.SELLERID = SELLERID;
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
        this.GENDER = GENDER;
    }
    
}
