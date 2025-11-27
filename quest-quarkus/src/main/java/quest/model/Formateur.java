package quest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import io.quarkus.security.jpa.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Formateur extends Personne {

	private boolean admin;

	// @OneToMany(mappedBy = "formateur")
	// private List<Module> formations;

	public Formateur() {
	}

	public Formateur(Integer id, String login, String password, String nom, String prenom, Civilite civilite,
			boolean admin) {
		super(id, login, password, nom, prenom, civilite);
		this.admin = admin;
	}

	public Formateur(String login, String password, String nom, String prenom, Civilite civilite, boolean admin) {
		super(login, password, nom, prenom, civilite);
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	// public List<Module> getFormations() {
	// return formations;
	// }

	// public void setFormations(List<Module> formations) {
	// this.formations = formations;
	// }

	
	public String getRole() {
		return (this.admin) ? "admin" : "user";
	}

	@Override
	public String toString() {
		return "Formateur [admin=" + admin + ", id=" + id + ", login=" + login + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}

}
