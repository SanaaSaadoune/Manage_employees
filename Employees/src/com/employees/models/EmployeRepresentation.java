package com.employees.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class EmployeRepresentation extends Employe {
	
	private double chiffreAffaires;

	public EmployeRepresentation(String nom, String prenom, int age, int dateEntree, double chiffreAffaires) {
		super(nom, prenom, age, dateEntree);
		// TODO Auto-generated constructor stub
		this.chiffreAffaires = chiffreAffaires;
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return ( this.chiffreAffaires * 20/100 ) + 2500;
	}

	@Override
	public String getNom() {
		return "L'employé de représentation : " + this.getNom() + this.getPrenom();
	}

	@Override
	public String toString() {
		return "EmployeRepresentation [chiffreAffaires=" + chiffreAffaires + "]";
	}
	
	
}
