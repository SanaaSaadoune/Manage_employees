package com.employees.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public abstract class Employe {

	private String nom;
	private String prenom;
	private int age;
	private int dateEntree;
	
	
	
	public abstract double calculerSalaire();
	
	public String getNom() {
		return "L'employé : " + nom + prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getDateEntree() {
		return dateEntree;
	}
	
	public void setDateEntree(int dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	public Employe(String nom, String prenom, int age, int dateEntree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
	}

	@Override
	public String toString() {
		return "Employee [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", dateEntree=" + dateEntree + "]";
	}

	
	
}
