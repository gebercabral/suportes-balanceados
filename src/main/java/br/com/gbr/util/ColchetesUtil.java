package br.com.gbr.util;

/**
 * 
 * @author Geber
 *
 */

public class ColchetesUtil{
	
	private static char[] caracteresPermitidos = {'(', '{','[',']','}',')'};
	
	
	public static String colchetesValidos(String sequencia) {
		try {
			validarTamanhoSequencia(sequencia);
			validarCaracteresValidos(sequencia);
			validarPares(sequencia);
			validarAberturaFechamento(sequencia);
			return "A ordem dos colchetes é válida";
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	//Verifica se a quantidade de colchetes, parêntesis e chaves de abertura são os mesmos de fechamento. {} () []
	private static void validarPares(String sequencia) throws Exception {
		int qtdeChaveA = 0;
		int qtdeParenteseA = 0;
		int qtdeColcheteA = 0;
		int qtdeChaveB = 0;
		int qtdeParenteseB = 0;
		int qtdeColcheteB = 0;
		
		for(int i = 0; i < sequencia.length(); i++) {
			if(sequencia.charAt(i) == '{') {
				qtdeChaveA++;
			}
			else if(sequencia.charAt(i) == '(') {
				qtdeParenteseA++;
			}
			else if(sequencia.charAt(i) == '[') {
				qtdeColcheteA++;
			}
			else if(sequencia.charAt(i) == '}') {
				qtdeChaveB++;
			}
			else if(sequencia.charAt(i) == ')') {
				qtdeParenteseB++;
			}
			else if(sequencia.charAt(i) == ']') {
				qtdeColcheteB++;
			}
			
		}
		
		if(qtdeChaveA != qtdeChaveB || qtdeParenteseA != qtdeParenteseB || qtdeColcheteA != qtdeColcheteB ) { 
			throw new Exception("A ordem dos colchetes é inválida");
		}
		
		
	}

	//Verifica se os colchetes tem seu par, ex.: {} [] ou ()
		private static void validarAberturaFechamento(String sequencia)throws Exception{
		
			StringBuilder sb = new StringBuilder(sequencia);
			int pos = 0;
			int loop = 0;
			int tamanhoSequencia = 0;
			int tamanhoSequenciaAnterior = 0;
			
			while(sb.length() > 1) {
				
				tamanhoSequencia = sb.length();
				if(pos >= sb.length() -1) {
					pos = 0;
					loop++;
				}
				
				char v1 = sb.charAt(pos);
				char v2 = sb.charAt(pos+1);
				
				if(
						(v1 == '{' && v2 == '}') ||
						(v1 == '(' && v2 == ')') ||
						(v1 == '[' && v2 == ']')
				) {
					sb.deleteCharAt(pos);
					sb.deleteCharAt(pos);
					tamanhoSequenciaAnterior = sb.length();
					loop = 0;
				}else { 
					if(loop > 1 && tamanhoSequencia == tamanhoSequenciaAnterior) {
						throw new Exception("A ordem dos colchetes é inválida");
					}
					pos++;
				}
			}
					
		}		
		
		//Verifica se o tamanho não é vazio, e se não é ímpar, pois significa que algum colchete está sem par.
		private static void validarTamanhoSequencia(String sequencia) throws Exception {
			
			if(sequencia.trim().length() == 0) {
				throw new Exception("A sequência de caracteres está vazia");
			}
			
			if(sequencia.length() % 2 == 1) 
				throw new Exception("A sequência de caracteres precisa ser par ");
			
		}
		
		
		//Verifica se o a sequência de caracteres é de colchetes, chaves ou parêntesis.
		private static void validarCaracteresValidos(String sequencia) throws Exception{
			
			for(int i = 0; i < sequencia.length(); i++) {
				boolean caractereEncontrado = false;
				char caractere = 0;
				for(int j = 0; j < caracteresPermitidos.length; j++ ) {
					caractere = sequencia.charAt(i);
					if(sequencia.charAt(i) == caracteresPermitidos[j]) {
						caractereEncontrado = true;
					}
				}
				if(!caractereEncontrado) 
					throw new Exception("Foi encontrado caractere inválido : " + caractere);
				
			}
		}
	
}
