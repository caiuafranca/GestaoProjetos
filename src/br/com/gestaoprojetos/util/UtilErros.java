package br.com.gestaoprojetos.util;

public class UtilErros {
	
	public static String getMessageError(Exception e){
		
		while(e.getCause() != null){
			e = (Exception) e.getCause();
		}
		String retorno = e.getMessage();
		return retorno;
	}

}
