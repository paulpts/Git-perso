package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Stagiaire extends Personne {

	@Column(length = 50)
	private String email;
	// @Embedded
	// private Adresse adresse;

	// @OneToOne
	// @JoinColumn(name="ordinateur")
	// private Ordinateur ordinateur;

	// @ManyToOne
	// @JoinColumn(name="filiere")

	// private Filiere filiere;

	public Stagiaire() {
	}

	public Stagiaire(Integer id, String login, String password, String nom, String prenom, Civilite civilite,
			String email,
			String numero, String voie, String ville, String cp) {// , Ordinateur ordinateur,Filiere filiere) {
		super(id, login, password, nom, prenom, civilite);
		this.email = email;
		// this.adresse = new Adresse(numero,voie,ville,cp);
		// this.ordinateur = ordinateur;
		// this.filiere=filiere;
	}

	public Stagiaire(String login, String password, String nom, String prenom, Civilite civilite, String email,
			String numero, String voie, String ville, String cp) {// , Ordinateur ordinateur,Filiere filiere) {
		super(login, password, nom, prenom, civilite);
		this.email = email;
		// this.adresse = new Adresse(numero,voie,ville,cp);
		// this.ordinateur = ordinateur;
		// this.filiere=filiere;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Stagiaire [email=" + email + ", id=" + id + ", login=" + login + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}

	// public Adresse getAdresse() {
	// return adresse;
	// }

	// public void setAdresse(Adresse adresse) {
	// this.adresse = adresse;
	// }

	// public Ordinateur getOrdinateur() {
	// return ordinateur;
	// }

	// public void setOrdinateur(Ordinateur ordinateur) {
	// this.ordinateur = ordinateur;
	// }

	// public Filiere getFiliere() {
	// return filiere;
	// }

	// public void setFiliere(Filiere filiere) {
	// this.filiere = filiere;
	// }

	// @Override
	// public String toString() {
	// return "Stagiaire [email=" + email + ", adresse=" + adresse + ", ordinateur="
	// + ordinateur + ", filiere="
	// + filiere + ", id=" + id + ", login=" + login + ", password=" + password + ",
	// nom=" + nom + ", prenom="
	// + prenom + ", civilite=" + civilite + "]";
	// }

	public String getRole() {
		return "user";
	}

}
