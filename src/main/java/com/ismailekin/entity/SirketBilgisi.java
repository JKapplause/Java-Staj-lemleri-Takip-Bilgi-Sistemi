package com.ismailekin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SirketBilgisi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 9999999)
	private String sirket_adi;
	private String adres;
	private String sehir;
	private String website;
	private long ogrenci_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSirket_adi() {
		return sirket_adi;
	}
	public void setSirket_adi(String sirket_adi) {
		this.sirket_adi = sirket_adi;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public long getOgrenci_id() {
		return ogrenci_id;
	}
	public void setOgrenci_id(long ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}
	@Override
	public String toString() {
		return "SirketBilgisi [id=" + id + ", sirket_adi=" + sirket_adi + ", adres=" + adres + ", sehir=" + sehir
				+ ", website=" + website + ", ogrenci_id=" + ogrenci_id + "]";
	}
	
	
	

}
