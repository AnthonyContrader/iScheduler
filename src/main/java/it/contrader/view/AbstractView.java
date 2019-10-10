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
		Date parsed  = null;
		scanner = new Scanner(System.in);
		java.sql.Date data = null;
		do {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String input = scanner.nextLine();
				if (input.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
					parsed = sdf.parse(input);
					data = new java.sql.Date(parsed.getTime());
				}
				else
				{
					System.out.println("Errore . Inserire formato valido:");
					parsed = null;
				}
			}catch(ParseException p) {
				p.printStackTrace();
			}
		}while(parsed == null);
		return data;
	}
	
	public float getInputCheckValueFloat(String dataType) {
		String input = dataType;
		while(!input.matches("([0-9]*)\\.([0-9]*)")) {
			System.out.println("Errore. Inserire formato valido:\n");
			input = getInput().toString();
		}
		float ret = Float.parseFloat(input);
		return ret;
	}
	public int getInputCheckValueInt(String dataType) {
		String input = dataType;
		while(!input.matches("([0-9]*)")) {
			System.out.println("Errore. Inserire formato valido:\n");
			input = getInput().toString();
		}
		int ret = Integer.parseInt(input);
		return ret;
	}
	public int getInputCheckValueIntLimit(String dataType) {
		String input = dataType;
		while(!input.matches("([1-2])")) {
			System.out.println("Errore. Inserire formato valido:\n");
			input = getInput();
		}
		int ret = Integer.parseInt(input);
		return ret;
	}
}
