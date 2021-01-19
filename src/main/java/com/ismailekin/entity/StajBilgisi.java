package com.ismailekin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StajBilgisi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=99999999)
	private String staj_birimi;
	private long ogrenci_id;
	private Date staj_baslama;
	private Date staj_bitis;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStaj_birimi() {
		return staj_birimi;
	}
	public void setStaj_birimi(String staj_birimi) {
		this.staj_birimi = staj_birimi;
	}
	
	
	public long getOgrenci_id() {
		return ogrenci_id;
	}
	public void setOgrenci_id(long ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}
	public Date getStaj_baslama() {
		return staj_baslama;
	}
	public void setStaj_baslama(Date staj_baslama) {
		this.staj_baslama = staj_baslama;
	}
	public Date getStaj_bitis() {
		return staj_bitis;
	}
	public void setStaj_bitis(Date staj_bitis) {
		this.staj_bitis = staj_bitis;
	}
	@Override
	public String toString() {
		return "StajBilgisi [id=" + id + ", staj_birimi=" + staj_birimi + ", ogrenci_id=" + ogrenci_id
				+ ", staj_baslama=" + staj_baslama + ", staj_bitis=" + staj_bitis + "]";
	}

	
	
	
}
