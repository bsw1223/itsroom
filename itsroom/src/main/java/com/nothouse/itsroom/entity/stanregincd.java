package com.nothouse.itsroom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class stanregincd {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private String region_cd;
  private String sido_cd;
  private String sgg_cd;
  private String umd_cd;
  private String ri_cd;
  private String locatjumin_cd;
  private String locatjijuk_cd;
  private String locatadd_nm;
  private String locat_order;
  private String locat_rm;
  private String locathigh_cd;
  private String locallow_nm;
  private String adpt_de;

  protected stanregincd() {}

  public stanregincd(String region_cd, String sido_cd, String sgg_cd, String umd_cd, String ri_cd, String locatjumin_cd, String locatjijuk_cd, String locatadd_nm, String locat_order, String locat_rm, String locathigh_cd, String locallow_nm, String adpt_de) {
    this.region_cd = region_cd;
    this.sido_cd = sido_cd;
    this.sgg_cd = sgg_cd;
    this.umd_cd = umd_cd;
    this.ri_cd = ri_cd;
    this.locatjumin_cd = locatjumin_cd;
    this.locatjijuk_cd = locatjijuk_cd;
    this.locatadd_nm = locatadd_nm;
    this.locat_order = locat_order;
    this.locat_rm = locat_rm;
    this.locathigh_cd = locathigh_cd;
    this.locallow_nm = locallow_nm;
    this.adpt_de = adpt_de;
  }

  @Override
  public String toString() {
    return String.format(
        "stanregincd[region_cd=%s, sido_cd=%s, sgg_cd=%s, umd_cd=%s, ri_cd=%s, locatjumin_cd=%s, locatjijuk_cd=%s, locatadd_nm=%s, locat_order=%s, locat_rm=%s, locathigh_cd=%s, locallow_nm=%s, adpt_de]",
        region_cd, sido_cd, sgg_cd, umd_cd, ri_cd, locatjumin_cd, locatjijuk_cd, locatadd_nm, locat_order, locat_rm, locathigh_cd, locallow_nm, adpt_de);
  }

  public String getRegion_cd() {
    return region_cd;
  }

  public String getSido_cd() {
    return sido_cd;
  }
  public String getSgg_cd() {
    return sgg_cd;
  }
  public String getUmd_cd() {
    return umd_cd;
  }
  public String getRi_cd() {
    return ri_cd;
  }
  public String getLocatjumin_cd() {
    return locatjumin_cd;
  }
  public String getLocatjijuk_cd() {
    return locatjijuk_cd;
  }
  public String getLocatadd_nm() {
    return locatadd_nm;
  }
  public String getLocat_order() {
    return locat_order;
  }
  public String getLocat_rm() {
    return locat_rm;
  }
  public String getLocathigh_cd() {
    return locathigh_cd;
  }
  public String getLocallow_nm() {
    return locallow_nm;
  }
  public String getAdpt_de() {
    return adpt_de;
  }
}