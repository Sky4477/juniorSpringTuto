package jn.spring.tuto;

import jn.spring.tuto.Model.Employe;
import jn.spring.tuto.Model.Librairie;
import jn.spring.tuto.Model.Livre;
import jn.spring.tuto.Service.Interface.EmployManager;
import jn.spring.tuto.Service.Interface.LibrairieManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class TutoApplication {

	@Value("${root.employ.name}")
	private String rootEmployNom;

	@Value("${root.employ.prenom}")
	private String rootEmployPrenom;

	@Value("${root.employ.email}")
	private String rootEmployEmail;
	public static void main(String[] args) {
		SpringApplication.run(TutoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(LibrairieManager librairieManager, EmployManager employManager) {
		return args -> {

			Employe employe = new Employe(rootEmployNom,rootEmployPrenom,rootEmployEmail);
			Librairie librairie = new Librairie("Librairie Root","Adresse Root");
			employe.setLibrairie(librairie);
			librairieManager.createLibrairie(librairie);
			librairieManager.addEmployeToLibrairie(librairie.getNom(),employe);

			Livre livre = new Livre("Livre Root","Auteur Root","Genre Root");
			librairieManager.addLivreToLibrairie(librairie.getNom(),livre);
		};
	}
}