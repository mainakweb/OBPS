package com.example.jwt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ekko")
public class Ekko {
    @Id
    @Column(name = "ebeln", length = 10, nullable = false)
    private String ebeln;

    @Column(name = "bukrs", length = 4, nullable = false)
    private String bukrs;

    @Column(name = "bstyp", length = 1)
    private String bstyp;

    @Column(name = "bsart", length = 4)
    private String bsart;

    @Column(name = "loekz", length = 1)
    private String loekz;

    @Column(name = "aedat")
    private Date aedat;

    @Column(name = "ernam", length = 12)
    private String ernam;

    @Column(name = "lifnr", length = 10)
    private String lifnr;

    @Column(name = "ekorg", length = 4)
    private String ekorg;

    @Column(name = "ekgrp", length = 3)
    private String ekgrp;

    @Column(name = "created_at")
    private BigInteger createdAt;

    @Column(name = "last_changed_at")
    private BigInteger lastChangedAt;

    // Default constructor
    public Ekko() {
    }

    // Constructor with all fields
    public Ekko(String ebeln, String bukrs, String bstyp, String bsart, String loekz,
                Date aedat, String ernam, String lifnr, String ekorg, String ekgrp,
                BigInteger createdAt, BigInteger lastChangedAt) {
        this.ebeln = ebeln;
        this.bukrs = bukrs;
        this.bstyp = bstyp;
        this.bsart = bsart;
        this.loekz = loekz;
        this.aedat = aedat;
        this.ernam = ernam;
        this.lifnr = lifnr;
        this.ekorg = ekorg;
        this.ekgrp = ekgrp;
        this.createdAt = createdAt;
        this.lastChangedAt = lastChangedAt;
    }

    // Getters and Setters

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getBukrs() {
        return bukrs;
    }

    public void setBukrs(String bukrs) {
        this.bukrs = bukrs;
    }

    public String getBstyp() {
        return bstyp;
    }

    public void setBstyp(String bstyp) {
        this.bstyp = bstyp;
    }

    public String getBsart() {
        return bsart;
    }

    public void setBsart(String bsart) {
        this.bsart = bsart;
    }

    public String getLoekz() {
        return loekz;
    }

    public void setLoekz(String loekz) {
        this.loekz = loekz;
    }

    public Date getAedat() {
        return aedat;
    }

    public void setAedat(Date aedat) {
        this.aedat = aedat;
    }

    public String getErnam() {
        return ernam;
    }

    public void setErnam(String ernam) {
        this.ernam = ernam;
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr;
    }

    public String getEkorg() {
        return ekorg;
    }

    public void setEkorg(String ekorg) {
        this.ekorg = ekorg;
    }

    public String getEkgrp() {
        return ekgrp;
    }

    public void setEkgrp(String ekgrp) {
        this.ekgrp = ekgrp;
    }

    public BigInteger getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BigInteger createdAt) {
        this.createdAt = createdAt;
    }

    public BigInteger getLastChangedAt() {
        return lastChangedAt;
    }

    public void setLastChangedAt(BigInteger lastChangedAt) {
        this.lastChangedAt = lastChangedAt;
    }
}
