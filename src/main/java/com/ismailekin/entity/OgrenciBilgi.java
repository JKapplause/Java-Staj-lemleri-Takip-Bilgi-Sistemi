package com.ismailekin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class OgrenciBilgi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=9999999)
	private int ogrenci_no;
	private String adi;
	private String soyadi;
	private String email;
	private String telefon;
	private String cinsiyet;
	private String memleket;
	@CreationTimestamp
	private Date create_date;
	@Column(length =99999999)
	private String content;
	private String fakulte;
	private String bolum;
	private String sifre = "1234";
	
	
	

	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	private Date dogum_tarihi;
	
	public String getFakulte() {
		return fakulte;
	}
	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getOgrenci_no() {
		return ogrenci_no;
	}
	public void setOgrenci_no(int ogrenci_no) {
		this.ogrenci_no = ogrenci_no;
	}

	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getMemleket() {
		return memleket;
	}
	public void setMemleket(String memleket) {
		this.memleket = memleket;
	}

	public Date getDogum_tarihi() {
		return dogum_tarihi;
	}
	public void setDogum_tarihi(Date dogum_tarihi) {
		this.dogum_tarihi = dogum_tarihi;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "OgrenciBilgi [id=" + id + ", ogrenci_no=" + ogrenci_no + ", adi=" + adi + ", soyadi=" + soyadi
				+ ", email=" + email + ", telefon=" + telefon + ", cinsiyet=" + cinsiyet + ", memleket=" + memleket
				+ ", create_date=" + create_date + ", content=" + content + ", fakulte=" + fakulte + ", bolum=" + bolum
				+ ", sifre=" + sifre + ", dogum_tarihi=" + dogum_tarihi + "]";
	}
	
	
	
	
			
}
