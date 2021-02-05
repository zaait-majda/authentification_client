package com.example.demo;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.*;
@RestController
public class AuthController {
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private AuthenticationManager  authenticationManager;
@PostMapping("/subs")
//@RequestMapping(value = "/subs" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) throws IOException{
	
	String nom = authenticationRequest.getNom();
	String password = authenticationRequest.getPassword();
	
	  String prenom =authenticationRequest.getPrenom();
	
	  String email=authenticationRequest.getEmail();
   String tel=authenticationRequest.getTel();
   // String N_patente=authenticationRequest.getN_patente();
	String n_cin= authenticationRequest.getN_cin();
	 String adress=authenticationRequest.getAdress();
	
	// String conf_mail=authenticationRequest.getConf_mail();
	// String n_immatriculation=authenticationRequest.getN_immatriculation();
	// String description=authenticationRequest.getDescription();
	// MultipartFile file =authenticationRequest.getFile();
	//Binary file= authenticationRequest.getFile();
	UserModel usermodel = new UserModel();
	usermodel.setNom(nom);
	usermodel.setPassword(password);
	usermodel.setAdress(adress);
//	usermodel.setConf_mail(conf_mail);
//	usermodel.setDate_naiss(date_naiss);
//	usermodel.setDescription(description);
	usermodel.setEmail(email);
	usermodel.setN_cin(n_cin);
//	usermodel.setN_immatriculation(n_immatriculation);
//	usermodel.setN_patente(N_patente);
	//usermodel.setPiece_identite(piece_identite);
	usermodel.setPrenom(prenom);
	usermodel.setTel(tel);
//	usermodel.setFile(file);
	agentRepository.insert(usermodel);
	try {
		agentRepository.save(usermodel);
		
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthenticationResponse("client not added "+ nom));
	}

	return ResponseEntity.ok(new AuthenticationResponse("client added "+ nom));
}


@PostMapping("/auth")
private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
	String nom = authenticationRequest.getNom();
	String password = authenticationRequest.getPassword();
	
	  String prenom =authenticationRequest.getPrenom();
	// String piece_identite=authenticationRequest.getPiece_identite();
	// String date_naiss=authenticationRequest.getDate_naiss();
	  String email=authenticationRequest.getEmail();
   String tel=authenticationRequest.getTel();
 //   String N_patente=authenticationRequest.getN_patente();
	String n_cin= authenticationRequest.getN_cin();
	 String adress=authenticationRequest.getAdress();
	
	// String conf_mail=authenticationRequest.getConf_mail();
	// String n_immatriculation=authenticationRequest.getN_immatriculation();
	// String description=authenticationRequest.getDescription();
	 try {
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tel, password));
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthenticationResponse("error authentication "));
	}
	
	return ResponseEntity.ok(new AuthenticationResponse("client autentification "));
}
}
