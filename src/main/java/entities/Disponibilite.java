package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Disponibilite")
public class Disponibilite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDisponibilite;

	@ManyToOne
	@JoinColumn(name="ID_professeur")
	private Professeur professeur;
	 
	private String heureDispo;
	private String dateDispo;
	private String semaineDispo;
	private String jourDispo;

	public Disponibilite() {
		
	}
	
	public Disponibilite(Professeur professeur, String heureDispo,
			String dateDispo, String semaineDispo, String jourDispo) {
		super();
		this.professeur = professeur;
		this.heureDispo = heureDispo;
		this.dateDispo = dateDispo;
		this.semaineDispo = semaineDispo;
		this.jourDispo = jourDispo;
	}

	public Long getIdDisponibilite() {
		return idDisponibilite;
	}
	public void setIdDisponibilite(Long idDisponibilite) {
		this.idDisponibilite = idDisponibilite;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public String getHeureDispo() {
		return heureDispo;
	}
	public void setHeureDispo(String heureDispo) {
		this.heureDispo = heureDispo;
	}
	public String getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(String dateDispo) {
		this.dateDispo = dateDispo;
	}
	public String getSemaineDispo() {
		return semaineDispo;
	}
	public void setSemaineDispo(String semaineDispo) {
		this.semaineDispo = semaineDispo;
	}

	public String getJourDispo() {
		return jourDispo;
	}

	public void setJourDispo(String jourDispo) {
		this.jourDispo = jourDispo;
	}

}
