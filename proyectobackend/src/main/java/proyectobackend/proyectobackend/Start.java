package proyectobackend.proyectobackend;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
public class Start {
	
	@PostConstruct
	public void init() {
		System.out.println("Hola mundo");
		
	}

}
