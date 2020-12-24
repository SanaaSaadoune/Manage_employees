package com.employees.controllers;

import com.employees.config.ConnectDB;

public class Query {

	ConnectDB con;
	
	public Query() {
		con.Connect("jdbc:mysql://localhost/bdustensiles?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root", "");
	}
	
	
}
