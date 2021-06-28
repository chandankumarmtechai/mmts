package com.mmts.modal;

public class BookTicket {
    private String pnr;
    private String s_code;
    private String d_code;
    private double fair;
    private int noadult;
    private int nochild;
    private String cname;

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public int getNoadult() {
        return noadult;
    }

    public void setNoadult(int noadult) {
        this.noadult = noadult;
    }

    public int getNochild() {
        return nochild;
    }

    public void setNochild(int nochild) {
        this.nochild = nochild;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getD_code() {
        return d_code;
    }

    public void setD_code(String d_code) {
        this.d_code = d_code;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }
}
