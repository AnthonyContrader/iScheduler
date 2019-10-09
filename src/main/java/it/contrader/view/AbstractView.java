package it.contrader.view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public abstract class AbstractView implements View {

	private Scanner scanner;

	/**
	*Questo metodo è usato da tutti i controller che lo ereditano (non devono definirlo) estendendo questa classe
	*/
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public java.sql.Date getInputDate() {
		scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed  = null;
		try {
			parsed = sdf.parse(scanner.nextLine());
		}catch(ParseException p) {
			p.printStackTrace();
		}
		java.sql.Date data = new java.sql.Date(parsed.getTime());
		return data;
		
	}
}
