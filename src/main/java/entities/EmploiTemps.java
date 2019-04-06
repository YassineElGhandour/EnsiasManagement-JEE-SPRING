package entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="EmploiTemps")
public class EmploiTemps
{

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idEmploiTemps;
	
	
	@ManyToOne
	@JoinColumn(name="ID_Professeur")
	private Professeur professeur;
	
	
	@ManyToOne
	@JoinColumn(name="ID_matiere")
	private Matiere matiere;
	

	@ManyToOne
	@JoinColumn(name="ID_filiere")
	private Filiere filiere;
	
	@ManyToOne
	@JoinColumn(name="ID_groupe")
	private Groupe groupe;
	
	@ManyToOne
	@JoinColumn(name="ID_salle")
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name="ID_Semestre")
	private Semestre semestre;
	
	private Date dateDebutEmploi;
	
	private Date dateFinEmploi;
	
	private String heureEmploi;
	
	private String jourEmploi;
	
	private String semaineEmploi;
	
	public EmploiTemps(){
		matiere = new Matiere();
		professeur = new Professeur();
		filiere = new Filiere();
		groupe = new Groupe();
		salle = new Salle();
	}

	public EmploiTemps(Professeur professeur, Matiere matiere, Filiere filiere,
			Groupe groupe, Salle salle, Semestre semestre,
			Date dateDebutEmploi, Date dateFinEmploi, String heureEmploi,
			String jourEmploi, String semaineEmploi) {
		super();
		this.professeur = professeur;
		this.matiere = matiere;
		this.filiere = filiere;
		this.groupe = groupe;
		this.salle = salle;
		this.semestre = semestre;
		this.dateDebutEmploi = dateDebutEmploi;
		this.dateFinEmploi = dateFinEmploi;
		this.heureEmploi = heureEmploi;
		this.jourEmploi = jourEmploi;
		this.semaineEmploi = semaineEmploi;
	}



	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public String getHeureEmploi() {
		return heureEmploi;
	}

	public void setHeureEmploi(String heureEmploi) {
		this.heureEmploi = heureEmploi;
	}


	public Date getDateDebutEmploi() {
		return dateDebutEmploi;
	}


	public void setDateDebutEmploi(Date dateDebutEmploi) {
		this.dateDebutEmploi = dateDebutEmploi;
	}


	public Date getDateFinEmploi() {
		return dateFinEmploi;
	}


	public void setDateFinEmploi(Date dateFinEmploi) {
		this.dateFinEmploi = dateFinEmploi;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public String getJourEmploi() {
		return jourEmploi;
	}

	public void setJourEmploi(String jourEmploi) {
		this.jourEmploi = jourEmploi;
	}



	public Long getIdEmploiTemps() {
		return idEmploiTemps;
	}



	public void setIdEmploiTemps(Long idEmploiTemps) {
		this.idEmploiTemps = idEmploiTemps;
	}



	public Semestre getSemestre() {
		return semestre;
	}



	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}



	public String getSemaineEmploi() {
		return semaineEmploi;
	}



	public void setSemaineEmploi(String semaineEmploi) {
		this.semaineEmploi = semaineEmploi;
	}
	
	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}



}
