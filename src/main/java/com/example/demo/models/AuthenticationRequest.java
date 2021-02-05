package com.example.demo.models;

import javax.websocket.Decoder.Binary;

import org.springframework.web.multipart.MultipartFile;

public class AuthenticationRequest {
	
	 public AuthenticationRequest() {
		
		// TODO Auto-generated constructor stub
	}
	 private String nom;
	 private String prenom ;
	// private String piece_identite;
	 private String date_naiss;
	 private String email;
	 private String tel;
	// private String N_patente;
	 private String n_cin;
	 private String adress;
	
	//private String conf_mail;
	// private String n_immatriculation;
	// private String description;
	 private String password;
	// private MultipartFile  file;
	 

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getN_cin() {
		return n_cin;
	}
	public void setN_cin(String n_cin) {
		this.n_cin = n_cin;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
	 
	 
	
	
}
