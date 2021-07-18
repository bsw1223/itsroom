package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "SEARCH_CRITERIA" )
public class SearchCriteria implements Serializable {
	
	@Column( name = "ADDRESS1" )
	private String address1;           //'�ּ�1'
	
	@Column( name = "ADDRESS2" )
    private String address2;           //'�ּ�2'
	
	@Column( name = "ADDRESS_DETAIL" )
    private String addressDetail;      //'���ּ�'
	
	@Column( name = "PRIVATE_AREA" )
    private String privateArea;        //'�������'
	
	@Column( name = "FLOOR" )
    private String floor;              //'��'
	
	@Column( name = "DEPOSIT" )
    private String deposit;            //'������'   
	
	@Column( name = "MONTHLY_RENT" )
    private String monthlyRent;        //'����'     
	
	@Column( name = "SUBWAY_LINE" )
    private String subwayLine;         //'����öȣ��'  
	
	@Column( name = "SUBWAY_STATION" )
    private String subwayStation;      //'����ö���̸�'     
	
	@Column( name = "SUBWAY_DISTANCE" )
    private String subwayDistance;     //'����ö�Ÿ�'     
	
	@Id
	@Column( name = "SAVE_TIME" )
    private String saveTime;           //'����ð�'    
	
	@Id
	@Column( name = "SCRAP_NAME" )
    private String scrapName;          //'��ũ����'      
	
	@Id
	@Column( name = "E_MAIL" )
    private String eMail;              //'������̸���'     
	
	
    public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getPrivateArea() {
		return privateArea;
	}
	public void setPrivateArea(String privateArea) {
		this.privateArea = privateArea;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public String getSubwayLine() {
		return subwayLine;
	}
	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}
	public String getSubwayStation() {
		return subwayStation;
	}
	public void setSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation;
	}
	public String getSubwayDistance() {
		return subwayDistance;
	}
	public void setSubwayDistance(String subwayDistance) {
		this.subwayDistance = subwayDistance;
	}
	public String getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	public String getScrapName() {
		return scrapName;
	}
	public void setScrapName(String scrapName) {
		this.scrapName = scrapName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
}
