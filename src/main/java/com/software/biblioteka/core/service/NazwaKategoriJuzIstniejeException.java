package com.software.biblioteka.core.service;
//weryfikowalne Exception
//nie weryfikowalne RuntimeException
public class NazwaKategoriJuzIstniejeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NazwaKategoriJuzIstniejeException(String message) {
		super(message);
		
	}
	
	

}
