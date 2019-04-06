package entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("ROLE_PROF")
public class Professeur extends User
{
	
	private static final long serialVersionUID = 1L;
	
	private String nomProfesseur = "";
    private String prenomProfesseur = " ";
    private String cin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String sexe;
    private String tel;
    private String adresse;
    
 
	 @ManyToMany(mappedBy = "professeurs")
	 private List<Matiere> matieres;

	 
	 @OneToMany(mappedBy="professeur",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<EmploiTemps> emploitempss;
	 

	@OneToMany(mappedBy="professeur",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<Disponibilite> disponibilites;
	 
	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Professeur()
	{
		this.setRole("ROLE_PROF");
	}



	public Professeur(String nomProfesseur, String prenomProfesseur,
			String cin, Date dateNaissance, String sexe, String tel,
			String adresse, List<Matiere> matieres,
			List<EmploiTemps> emploitempss, List<Disponibilite> disponibilites) {
		super();
		this.nomProfesseur = nomProfesseur;
		this.prenomProfesseur = prenomProfesseur;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.tel = tel;
		this.adresse = adresse;
		this.matieres = matieres;
		this.emploitempss = emploitempss;
		this.disponibilites = disponibilites;
	}

	public List<EmploiTemps> getEmploitempss() {
		return emploitempss;
	}

	public void setEmploitempss(List<EmploiTemps> emploitempss) {
		this.emploitempss = emploitempss;
	}

	public String getNomProfesseur() {
		return nomProfesseur;
	}

	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur = nomProfesseur;
	}

	public String getPrenomProfesseur() {
		return prenomProfesseur;
	}

	public void setPrenomProfesseur(String prenomProfesseur) {
		this.prenomProfesseur = prenomProfesseur;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}


}
