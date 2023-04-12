package ajc.formation.soprasteria.projetQuizzSB.entities;

public enum Role {
    ROLE_ADMIN("Admin"),ROLE_UTILISATEUR("Utilisateur");
    
private String role;
	
	private Role (String role) {
		this.role=role;
		}
	
	public String getRole() {
		return role;
	}
}
