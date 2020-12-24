package com.employees.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class EmployeVente extends Employe {
	
	private double chiffreAffaires;

	public double getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(double chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	public EmployeVente(String nom, String prenom, int age, int dateEntree, double chiffreAffaires) {
		super(nom, prenom, age, dateEntree);
		// TODO Auto-generated constructor stub
		this.chiffreAffaires = chiffreAffaires;
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return ( this.chiffreAffaires * 20/100 ) + 1500;
	}
	
	@Override
	public String getNom() {
		return "L'employé de vente : " + this.getNom() + this.getPrenom();
	}

	@Override
	public String toString() {
		return "EmployeVente [chiffreAffaires=" + chiffreAffaires + "]";
	}
	
}
