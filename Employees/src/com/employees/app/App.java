package com.employees.app;

import com.employees.models.*;

import java.util.ArrayList;
import java.util.Scanner;

import com.employees.config.ConnectDB;

public class App {
	
	static ArrayList<EmployeVente> listEmployesVente = new ArrayList<EmployeVente>();
	static ArrayList<EmployeManutention> listEmployesManutention = new ArrayList<EmployeManutention>();
	static ArrayList<EmployeProduction> listEmployesProduction = new ArrayList<EmployeProduction>();
	static ArrayList<EmployeRepresentation> listEmployesRepresentation = new ArrayList<EmployeRepresentation>();
	
	public static Boolean AjouterEmploye(String Employe,Employe obj) {
		
		
		switch(Employe) {
		case"em":
			
			if(listEmployesManutention.size() == 0) {
				listEmployesManutention.add((EmployeManutention) obj);
				return true;
			}else {
				return false;
			}
			
			
		case"ep":
			if(listEmployesProduction.size() == 0) {
				listEmployesProduction.add((EmployeProduction) obj);
				return true;
			}else {
				return false;
			}
			
		case"er":
			if(listEmployesRepresentation.size() == 0) {
				listEmployesRepresentation.add((EmployeRepresentation) obj);
				return true;
			}else {
				return false;
			}
			
		case"ev":
			if(listEmployesVente.size() == 0) {
				listEmployesVente.add((EmployeVente) obj);
				return true;
			}else {
				return false;
			}
			
		}
		return null;
		
		
	}
	
	public static void SalaireMoyen(String table) {
		ConnectDB conn = new ConnectDB();
		conn.Connect("jdbc:mysql://localhost/bdgestionpersonnel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root", "");
		conn.AffichageAVG(table);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner reader = new Scanner(System.in);
		
		
		
		
		while(true) {
			ConnectDB conn = new ConnectDB();
			conn.Connect("jdbc:mysql://localhost/bdgestionpersonnel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root", "");
			
			
			System.out.println("Employé de Manutention, Production, Representation ou Vente ? (em, ep, er, ev) :");
			String key = reader.next();
			
			switch (key) {
			
			//------------------------------ EM ---------------------------//
			case "em": 
				conn.Affichage("employemanutention");
				SalaireMoyen("employemanutention");
				
				System.out.println("Add, Update, Delete ? (a,u,d) :");
				String choix = reader.next();
				
				switch(choix){
					case"a":
						System.out.println("\t Nom :");
						String nom = reader.next();
						
						System.out.println("\t Prenom :");
						String prenom = reader.next();
						
						System.out.println("\t Age :");
						int age = reader.nextInt();
						
						System.out.println("\t Date :");
						int date = reader.nextInt();
						
						System.out.println("\t Heures de travail :");
						int heures = reader.nextInt();
						
						System.out.println("\t Risque (true/false):");
						boolean risque = reader.nextBoolean();
						
						EmployeManutention employeManutention = new EmployeManutention(nom,prenom,age,date,heures,risque);
					
						
						if(AjouterEmploye(key,employeManutention).equals(true)) {
							conn.InsertReq("INSERT INTO employemanutention (nom,prenom,age,dateEntree,heuresTravail,salaire,risque) VALUES ('"+nom+"','"+prenom+"',"+age+","+date+","+heures+","+employeManutention.calculerSalaire()+","+risque+")");
							
						}else {
							System.out.println("The list is full !");
						}
						break;
						
					case"u":
						System.out.println("\t Id :");
						int id = reader.nextInt();
						
						System.out.println("\t Nom :");
						nom = reader.next();
						
						System.out.println("\t Prenom :");
						prenom = reader.next();
						
						System.out.println("\t Age :");
						age = reader.nextInt();
						
						System.out.println("\t Date :");
						date = reader.nextInt();
						
						System.out.println("\t HeuresTravail :");
						heures = reader.nextInt();
						
						System.out.println("\t Risque (true/false):");
						risque = reader.nextBoolean();
						
						employeManutention = new EmployeManutention(nom,prenom,age,date,heures,risque);
					
						
							conn.InsertReq("UPDATE employemanutention SET nom='"+nom+"',prenom='"+prenom+"', age='"+age+"', dateEntree='"+date+"', heuresTravail='"+heures+"', salaire="+employeManutention.calculerSalaire()+", risque="+risque+" WHERE id="+id+"");
												
						break;
						
					case"d":
						System.out.println("\t Id :");
						id = reader.nextInt();
						conn.DeleteReq("Delete FROM employemanutention WHERE id="+id);
												
						break;
						
					default:
						System.out.println("Choix incorrect !");
						break;
						
				}

				break;
				
				//--------------------------- EP -----------------------//
				
			case "ep": 
				conn.Affichage("employeproduction");
				SalaireMoyen("employeproduction");
				System.out.println("Add, Update, Delete ? (a,u,d) :");
				choix = reader.next();
				
				switch(choix){
					case"a":
						System.out.println("\t Nom :");
						String nom = reader.next();
						
						System.out.println("\t Prenom :");
						String prenom = reader.next();
						
						System.out.println("\t Age :");
						int age = reader.nextInt();
						
						System.out.println("\t Date :");
						int date = reader.nextInt();
						
						System.out.println("\t NombreUnites :");
						int nombreUnites = reader.nextInt();
						
						System.out.println("\t Risque (true/false):");
						boolean risque = reader.nextBoolean();
						
						EmployeProduction employeProduction = new EmployeProduction(nom,prenom,age,date,nombreUnites,risque);
					
						
						if(AjouterEmploye(key,employeProduction).equals(true)) {
							conn.InsertReq("INSERT INTO employeproduction (nom,prenom,age,dateEntree,nombreUnites,salaire,risque) VALUES ('"+nom+"','"+prenom+"',"+age+","+date+","+nombreUnites+","+employeProduction.calculerSalaire()+","+risque+")");
							
						}else {
							System.out.println("The list is full !");
						}
						break;
						
					case"u":
						System.out.println("\t Id :");
						int id = reader.nextInt();
						
						System.out.println("\t Nom :");
						nom = reader.next();
						
						System.out.println("\t Prenom :");
						prenom = reader.next();
						
						System.out.println("\t Age :");
						age = reader.nextInt();
						
						System.out.println("\t Date :");
						date = reader.nextInt();
						
						System.out.println("\t Nombre unites :");
						nombreUnites = reader.nextInt();
						
						System.out.println("\t Risque (true/false):");
						risque = reader.nextBoolean();
						
						employeProduction = new EmployeProduction(nom,prenom,age,date,nombreUnites,risque);
					
						
							conn.InsertReq("UPDATE employeproduction SET nom='"+nom+"',prenom='"+prenom+"', age='"+age+"', dateEntree='"+date+"', nombreUnites='"+nombreUnites+"', salaire="+employeProduction.calculerSalaire()+", risque="+risque+" WHERE id="+id+"");
												
						break;
						
					case"d":
						System.out.println("\t Id :");
						id = reader.nextInt();
						conn.DeleteReq("Delete FROM employeproduction WHERE id="+id);
												
						break;
						
					default:
						System.out.println("Choix incorrect !");
						break;
						
				}

				break;
				
				
//--------------------------- ER -----------------------//
				
			case "er": 
				conn.Affichage("employerepresentation");
				SalaireMoyen("employerepresentation");
				System.out.println("Add, Update, Delete ? (a,u,d) :");
				choix = reader.next();
				
				switch(choix){
					case"a":
						System.out.println("\t Nom :");
						String nom = reader.next();
						
						System.out.println("\t Prenom :");
						String prenom = reader.next();
						
						System.out.println("\t Age :");
						int age = reader.nextInt();
						
						System.out.println("\t Date :");
						int date = reader.nextInt();
						
						System.out.println("\t Chiffre affaires :");
						int chiffreaffaires = reader.nextInt();
						
						EmployeRepresentation employeRepresentation = new EmployeRepresentation(nom,prenom,age,date,chiffreaffaires);
					
						
						if(AjouterEmploye(key,employeRepresentation).equals(true)) {
							conn.InsertReq("INSERT INTO employerepresentation (nom,prenom,age,dateEntree,chiffreAffaires,salaire) VALUES ('"+nom+"','"+prenom+"',"+age+","+date+","+chiffreaffaires+","+employeRepresentation.calculerSalaire()+")");
							
						}else {
							System.out.println("The list is full !");
						}
						break;
						
					case"u":
						System.out.println("\t Id :");
						int id = reader.nextInt();
						
						System.out.println("\t Nom :");
						nom = reader.next();
						
						System.out.println("\t Prenom :");
						prenom = reader.next();
						
						System.out.println("\t Age :");
						age = reader.nextInt();
						
						System.out.println("\t Date :");
						date = reader.nextInt();
						
						System.out.println("\t Chiffre affaires :");
						chiffreaffaires = reader.nextInt();
						
						employeRepresentation = new EmployeRepresentation(nom,prenom,age,date,chiffreaffaires);
					
						
							conn.InsertReq("UPDATE employerepresentation SET nom='"+nom+"',prenom='"+prenom+"', age='"+age+"', dateEntree='"+date+"', chiffreAffaires='"+chiffreaffaires+"', salaire="+employeRepresentation.calculerSalaire()+" WHERE id="+id+"");
												
						break;
						
					case"d":
						System.out.println("\t Id :");
						id = reader.nextInt();
						conn.DeleteReq("Delete FROM employerepresentation WHERE id="+id);
												
						break;
						
					default:
						System.out.println("Choix incorrect !");
						break;
						
				}

				break;
			
				
//--------------------------- ER -----------------------//
				
			case "ev": 
				conn.Affichage("employevente");
				SalaireMoyen("employevente");
				System.out.println("Add, Update, Delete ? (a,u,d) :");
				choix = reader.next();
				
				switch(choix){
					case"a":
						System.out.println("\t Nom :");
						String nom = reader.next();
						
						System.out.println("\t Prenom :");
						String prenom = reader.next();
						
						System.out.println("\t Age :");
						int age = reader.nextInt();
						
						System.out.println("\t Date :");
						int date = reader.nextInt();
						
						System.out.println("\t Chiffre d'affaires :");
						int chiffreaffaires = reader.nextInt();
						
						EmployeVente employeVente = new EmployeVente(nom,prenom,age,date,chiffreaffaires);
					
						
						if(AjouterEmploye(key,employeVente).equals(true)) {
							conn.InsertReq("INSERT INTO employeVente (nom,prenom,age,dateEntree,chiffreAffaires,salaire) VALUES ('"+nom+"','"+prenom+"',"+age+","+date+","+chiffreaffaires+","+employeVente.calculerSalaire()+")");
							
						}else {
							System.out.println("The list is full !");
						}
						break;
						
					case"u":
						System.out.println("\t Id :");
						int id = reader.nextInt();
						
						System.out.println("\t Nom :");
						nom = reader.next();
						
						System.out.println("\t Prenom :");
						prenom = reader.next();
						
						System.out.println("\t Age :");
						age = reader.nextInt();
						
						System.out.println("\t Date :");
						date = reader.nextInt();
						
						System.out.println("\t Chiffre d'affaires :");
						chiffreaffaires = reader.nextInt();
						
						employeVente = new EmployeVente(nom,prenom,age,date,chiffreaffaires);
					
						conn.InsertReq("UPDATE employevente SET nom='"+nom+"',prenom='"+prenom+"', age='"+age+"', dateEntree='"+date+"', chiffreAffaires='"+chiffreaffaires+"', salaire="+employeVente.calculerSalaire()+" WHERE id="+id+"");
												
						break;
						
					case"d":
						System.out.println("\t Id :");
						id = reader.nextInt();
						conn.DeleteReq("Delete FROM employevente WHERE id="+id);
												
						break;
						
					default:
						System.out.println("Choix incorrect !");
						break;
						
				}

				break;
			
				
			
			
			
			default:
				break;
			}
			
		}
		
		
		
		
		
		
	}

}
