package ajc.formation.soprasteria.projetQuizzSB.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CompteException extends UsernameNotFoundException {
	
	public CompteException() {
		super("compte inconnu");
	}
	
	public CompteException(String message) {
		super(message);
	}

}
