package com.ismailekin.stajtakip;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ismailekin.entity.OgrenciBilgi;
import com.ismailekin.entity.SirketBilgisi;
import com.ismailekin.entity.StajBilgisi;
import com.ismailekin.service.MailService;
import com.ismailekin.service.OgrenciBilgiService;
import com.ismailekin.service.SirketBilgiService;
import com.ismailekin.service.StajBilgiService;
import com.ismailekin.service.StajDegerlendirmeService;
import com.ismailekin.entity.StajDegerlendirme;


@Controller
public class HomeController {
	public static String url = "http://localhost:8080/stajtakip";
	
	@Autowired
	private MailService mailService;	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
				
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homes(Model model, HttpServletRequest req) {
		
		
		return "redirect:/index";
	}
		
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) {
		model.addAttribute("user", req.getSession().getAttribute("user"));
		System.out.println(req.getRemoteAddr());
		
		model.addAttribute("mesaj","Ogrenci Bilgileri");
		model.addAttribute("mesaj2","Þirket Bilgileri");
		model.addAttribute("mesaj3","Staj Bilgileri");
		model.addAttribute("mesaj4","Staj Degerlendirme Bilgileri");
		
		model.addAttribute("serverTime", "/");
		
		return "index";
	}
				
	///////////////// Ogrenci Bilgileri //////////////
	
	@RequestMapping(value = "/detay/{id}", method = RequestMethod.GET)
	public String home(@PathVariable("id") Long id,Model model) {
		model.addAttribute("id", id);
		
		mailService.registerMail("ismailekin@yopmail.com", "12345");
		
		return "detail";
		
	}
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
		
		return "error_404";
	}
	
	
	
	
	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String ekle(Model model) {
		
		
		return "ogrenciekle";
	}
	
	
	
	@Autowired
	private OgrenciBilgiService ogrenciBilgiService;
	@RequestMapping(value ="/ogrenciekle" , method=RequestMethod.POST)  
	public ResponseEntity<String> ogrenciekle(@RequestBody OgrenciBilgi bilgi, HttpServletRequest request){
		
		System.out.println(bilgi.toString());
		
		ogrenciBilgiService.createOgrenciBilgi(bilgi, request);
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	
	@RequestMapping(value ="/getEkle" , method=RequestMethod.GET)  
	public ResponseEntity<ArrayList<OgrenciBilgi>> getEkle(HttpServletRequest request){	
	
		return new ResponseEntity<>(ogrenciBilgiService.getAll() ,HttpStatus.CREATED);
	}
	
	

	@RequestMapping(value ="/detay/getOgrenci/{id}" , method=RequestMethod.GET)  
	public ResponseEntity<OgrenciBilgi> getOgrenci(@PathVariable Long id,HttpServletRequest request){
		return new ResponseEntity<>(ogrenciBilgiService.getOgrenciBilgiFindId(id) ,HttpStatus.CREATED);
	}
	
	
	
	
	@RequestMapping(value ="/ogrenciGuncelle" , method=RequestMethod.PUT)  
	public ResponseEntity<String> ogrenciGuncelle(@RequestBody OgrenciBilgi bilgi, HttpServletRequest request){
		
		OgrenciBilgi oldBilgi = ogrenciBilgiService.getOgrenciBilgiFindId(bilgi.getId());
		
		oldBilgi.setAdi(bilgi.getAdi());
		oldBilgi.setBolum(bilgi.getBolum());
		oldBilgi.setCinsiyet(bilgi.getCinsiyet());
		oldBilgi.setContent(bilgi.getContent());
		oldBilgi.setDogum_tarihi(bilgi.getDogum_tarihi());
		oldBilgi.setEmail(bilgi.getEmail());
		oldBilgi.setFakulte(bilgi.getFakulte());
		oldBilgi.setMemleket(bilgi.getMemleket());
		oldBilgi.setOgrenci_no(bilgi.getOgrenci_no());
		oldBilgi.setSoyadi(bilgi.getSoyadi());
		oldBilgi.setTelefon(bilgi.getTelefon());
		
		ogrenciBilgiService.updateOgrenciBilgi(oldBilgi, request);
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value ="/deleteOgrenci" , method=RequestMethod.DELETE)  
	public ResponseEntity<String> deleteOgrenci(@RequestBody OgrenciBilgi bilgi, HttpServletRequest request){
		
		OgrenciBilgi oldBilgi = ogrenciBilgiService.getOgrenciBilgiFindId(bilgi.getId());
		
		
		
		ogrenciBilgiService.deleteOgrenciBilgi(oldBilgi, request);
		
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	/////////////////////////////////
	
	/////////////////////////////////
	
	// Þirket Bilgisi
	
	///
	@RequestMapping(value = "/detay1/{id}", method = RequestMethod.GET)
	public String home1(@PathVariable("id") Long id,Model model) {
		model.addAttribute("id", id);
		
		mailService.registerMail("ismailekin@yopmail.com", "12345");
		
		return "Sirketdetail";
	}

	
	
	
	//////
	@RequestMapping(value = "/sirket", method = RequestMethod.GET)
	public String sirket(Model model) {
		
		
		return "sirketekle";
	}
	
	
	
	@Autowired
	private SirketBilgiService sirketBilgiService;
	@RequestMapping(value ="/sirketekle" , method=RequestMethod.POST)  
	public ResponseEntity<String> sirketekle(@RequestBody SirketBilgisi sirket, HttpServletRequest request){
		
		System.out.println(sirket.toString());
		
		sirketBilgiService.createSirketBilgisi(sirket, request);
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	
	@RequestMapping(value ="/getEkle2" , method=RequestMethod.GET)  
	public ResponseEntity<ArrayList<SirketBilgisi>> getEkle2(HttpServletRequest request){	
	
		return new ResponseEntity<>(sirketBilgiService.getAll() ,HttpStatus.CREATED);
	}

	
	@RequestMapping(value ="/detay1/getSirket/{id}" , method=RequestMethod.GET)  
	public ResponseEntity<SirketBilgisi> getSirket(@PathVariable Long id,HttpServletRequest request){
		return new ResponseEntity<>(sirketBilgiService.getSirketBilgisiFindId(id) ,HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value ="/sirketGuncelle" , method=RequestMethod.PUT)  
	public ResponseEntity<String> sirketGuncelle(@RequestBody SirketBilgisi sirket, HttpServletRequest request){
		
		SirketBilgisi oldSirket = sirketBilgiService.getSirketBilgisiFindId(sirket.getId());
		
		oldSirket.setSirket_adi(sirket.getSirket_adi());
		oldSirket.setAdres(sirket.getAdres());
		oldSirket.setSehir(sirket.getSehir());
		oldSirket.setWebsite(sirket.getWebsite());
		
		
		sirketBilgiService.updateSirketBilgisi(oldSirket, request);
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value ="/deleteSirket" , method=RequestMethod.DELETE)  
	public ResponseEntity<String> deleteSirket(@RequestBody SirketBilgisi sirket, HttpServletRequest request){
		
		SirketBilgisi oldSirket = sirketBilgiService.getSirketBilgisiFindId(sirket.getId());
		
		
		
		sirketBilgiService.deleteSirketBilgisi(oldSirket, request);
		
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	//////////////////////////////////
	/////////////////////////////////
	/////////////////////////////////
	
	
	
	
	
	
	// STAJ BÝLGÝSÝ //
	
	
	@RequestMapping(value = "/detay2/{id}", method = RequestMethod.GET)
	public String home2(@PathVariable("id") Long id,Model model) {
		model.addAttribute("id", id);
		
		mailService.registerMail("ismailekin@yopmail.com", "12345");
		
		return "Stajdetail";
	}
	
	@RequestMapping(value = "/staj", method = RequestMethod.GET)
	public String staj(Model model) {
		
		
		return "stajekle";
	}
	
	
	
	@Autowired
	private StajBilgiService stajBilgiService;
	@RequestMapping(value ="/stajekle" , method=RequestMethod.POST)  
	public ResponseEntity<String> stajekle(@RequestBody StajBilgisi staj, HttpServletRequest request){
		
		System.out.println(staj.toString());
		
		stajBilgiService.createStajBilgisi(staj, request);
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/getEkle3" , method=RequestMethod.GET)  
	public ResponseEntity<ArrayList<StajBilgisi>> getEkle3(HttpServletRequest request){	
		return new ResponseEntity<>(stajBilgiService.getAll() ,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value ="/detay2/getStaj/{id}" , method=RequestMethod.GET)  
	public ResponseEntity<StajBilgisi> getStaj(@PathVariable Long id,HttpServletRequest request){
		return new ResponseEntity<>(stajBilgiService.getStajBilgisiFindId(id) ,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value ="/stajGuncelle" , method=RequestMethod.PUT)  
	public ResponseEntity<String> stajGuncelle(@RequestBody StajBilgisi staj, HttpServletRequest request){
		
		StajBilgisi oldStaj = stajBilgiService.getStajBilgisiFindId(staj.getId());
		
		oldStaj.setStaj_birimi(staj.getStaj_birimi());
		oldStaj.setStaj_baslama(staj.getStaj_baslama());
		oldStaj.setStaj_bitis(staj.getStaj_bitis());
		
		
		
		stajBilgiService.updateStajBilgisi(oldStaj, request);
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value ="/deleteStaj" , method=RequestMethod.DELETE)  
	public ResponseEntity<String> deleteStaj(@RequestBody StajBilgisi staj, HttpServletRequest request){
		
		StajBilgisi oldStaj = stajBilgiService.getStajBilgisiFindId(staj.getId());
		
		
		
		stajBilgiService.deleteStajBilgisi(oldStaj, request);
		
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	
	
	////// STAJ DEGERLENDÝRMESÝ ////////////////
	
	@RequestMapping(value = "/detay3/{id}", method = RequestMethod.GET)
	public String home3(@PathVariable("id") Long id,Model model) {
		model.addAttribute("id", id);
		
		mailService.registerMail("ismailekin@yopmail.com", "12345");
		
		return "Degerlendirmedetail";
	}
	
	@RequestMapping(value = "/degerlendirme", method = RequestMethod.GET)
	public String degerlendirme(Model model) {
		
		
		return "degerlendirmeekle";
	}
	
	
	
	@Autowired
	private StajDegerlendirmeService stajDegerlendirmeService;
	@RequestMapping(value ="/degerlendirmeekle" , method=RequestMethod.POST)  
	public ResponseEntity<String> degerlendirmeekle(@RequestBody StajDegerlendirme deger, HttpServletRequest request){
		
		System.out.println(deger.toString());
		
		stajDegerlendirmeService.createStajDegerlendirme(deger, request);
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value ="/getEkle4" , method=RequestMethod.GET)  
	public ResponseEntity<ArrayList<StajDegerlendirme>> getEkle4(HttpServletRequest request){	
		return new ResponseEntity<>(stajDegerlendirmeService.getAll() ,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value ="/detay3/getDegerlendirme/{id}" , method=RequestMethod.GET)  
	public ResponseEntity<StajDegerlendirme> getDegerlendirme(@PathVariable Long id,HttpServletRequest request){
		return new ResponseEntity<>(stajDegerlendirmeService.getStajDegerlendirmeFindId(id) ,HttpStatus.CREATED);
	}
	
	
	
	
	@RequestMapping(value ="/degerlendirmeGuncelle" , method=RequestMethod.PUT)  
	public ResponseEntity<String> degerlendirmeGuncelle(@RequestBody StajDegerlendirme deger, HttpServletRequest request){
		
		StajDegerlendirme oldDeger = stajDegerlendirmeService.getStajDegerlendirmeFindId(deger.getId());
		
		oldDeger.setStaj_puaný(deger.getStaj_puaný());
		oldDeger.setIse_devam(deger.getIse_devam());
		oldDeger.setStaj_yorumu(deger.getStaj_yorumu());
		
		
		
		
		stajDegerlendirmeService.updateStajDegerlendirme(oldDeger, request);
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value ="/deleteDegerlendirme" , method=RequestMethod.DELETE)  
	public ResponseEntity<String> deleteDegerlendirme(@RequestBody StajDegerlendirme deger, HttpServletRequest request){
		
		StajDegerlendirme oldDeger = stajDegerlendirmeService.getStajDegerlendirmeFindId(deger.getId());
		
		
		
		stajDegerlendirmeService.deleteStajDegerlendirme(oldDeger, request);
		
		
		
		return new ResponseEntity<>("OK" ,HttpStatus.CREATED);
	}
	
	

}






