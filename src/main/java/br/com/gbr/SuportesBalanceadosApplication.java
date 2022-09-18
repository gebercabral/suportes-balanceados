package br.com.gbr;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gbr.util.ColchetesUtil;

@SpringBootApplication
public class SuportesBalanceadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuportesBalanceadosApplication.class, args);
		
		Scanner entrada =  new Scanner(System.in);
		
		try {
			System.out.println("Digite a sequência de colchetes :");
			String sequencia = entrada.nextLine();
			System.out.println(ColchetesUtil.colchetesValidos(sequencia));

			
		}finally {
			entrada.close();
		}
	}

}
