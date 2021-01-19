package com.ismailekin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StajDegerlendirme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long ogrenci_id;
	private long staj_puaný;
	private int ise_devam;
	@Column(length = 9999999)
	private String staj_yorumu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	

	

	public long getOgrenci_id() {
		return ogrenci_id;
	}

	public void setOgrenci_id(long ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}

	public long getStaj_puaný() {
		return staj_puaný;
	}

	public void setStaj_puaný(long staj_puaný) {
		this.staj_puaný = staj_puaný;
	}

	public int getIse_devam() {
		return ise_devam;
	}

	public void setIse_devam(int ise_devam) {
		this.ise_devam = ise_devam;
	}

	public String getStaj_yorumu() {
		return staj_yorumu;
	}

	public void setStaj_yorumu(String staj_yorumu) {
		this.staj_yorumu = staj_yorumu;
	}

	@Override
	public String toString() {
		return "StajDegerlendirme [id=" + id + ", ogrenci_id=" + ogrenci_id + ", staj_puaný=" + staj_puaný
				+ ", ise_devam=" + ise_devam + ", staj_yorumu=" + staj_yorumu + "]";
	}

	
	
}
