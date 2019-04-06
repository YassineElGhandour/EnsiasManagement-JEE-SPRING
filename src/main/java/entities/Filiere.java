package entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Filiere")
public class Filiere 
{

	//Attributs
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idFiliere;
	 
	 private String nomFiliere = " ";
	 private Long nombreClasse;
	
	 @OneToMany(mappedBy="filiere",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<Groupe> groupes;
	 
	 @OneToMany(mappedBy="filiere",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<EmploiTemps> emploitempss;

	 //Constructors
	 
	 public Filiere(){}

	 
	
	public Filiere(String nomFiliere, Long nombreClasse, List<Groupe> groupes,
			List<EmploiTemps> emploitempss) {
		super();
		this.nomFiliere = nomFiliere;
		this.nombreClasse = nombreClasse;
		this.groupes = groupes;
		this.emploitempss = emploitempss;
	}



	//Getters and Setters
	
	public List<EmploiTemps> getEmploitempss() {
		return emploitempss;
	}



	public void setEmploitempss(List<EmploiTemps> emploitempss) {
		this.emploitempss = emploitempss;
	}



	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getNomFiliere() {
		return nomFiliere;
	}

	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public Long getNombreClasse() {
		return nombreClasse;
	}

	public void setNombreClasse(Long nombreClasse) {
		this.nombreClasse = nombreClasse;
	}


	public List<Groupe> getGroupes() {
		return groupes;
	}


	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	 
	 
}
