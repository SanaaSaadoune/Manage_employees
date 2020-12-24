package com.employees.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class EmployeManutention extends Employe {
	
	private int heuresTravail;
	private boolean risque;

	public EmployeManutention(String nom, String prenom, int age, int dateEntree, int heuresTravail,boolean risque) {
		super(nom, prenom, age, dateEntree);
		// TODO Auto-generated constructor stub
		this.heuresTravail = heuresTravail;
		this.risque = risque;
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		
		if(this.risque) {
			EmployeManutentionRisque EmplyeRisque = new EmployeManutentionRisque();
			return heuresTravail * 50 + EmplyeRisque.prime();
		}else {
			return heuresTravail * 50;
		}
	}
	
	@Override
	public String getNom() {
		return "L'employé de manutention : " + this.getNom() + this.getPrenom();
	}

	@Override
	public String toString() {
		return "EmployeManutention [heuresTravail=" + heuresTravail + "]";
	}
	
	

}
