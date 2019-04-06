package entities;

import java.util.List;





import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name="Groupe")
public class Groupe 
{
	
	//Attributs
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idGroupe;
	
	 private String nomGroupe =" ";
	 private String UE;
	 
	 @ManyToMany(mappedBy = "groupes")
	 private List<Matiere> matieres;
	 
	 @ManyToOne
	 @JoinColumn(name="ID_Filiere")
	 private Filiere filiere;
	 
	 @OneToMany(mappedBy="groupe",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<EmploiTemps> emploitempss;
	 
	 //Constructors
	 
	public Groupe(){}

	//Getters and Setters
	
	public Groupe(Long idGroupe, String nomGroupe, String uE,
			List<Matiere> matieres, Filiere filiere,
			List<EmploiTemps> emploitempss) {
		super();
		this.idGroupe = idGroupe;
		this.nomGroupe = nomGroupe;
		UE = uE;
		this.matieres = matieres;
		this.filiere = filiere;
		this.emploitempss = emploitempss;
	}



	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public String getUE() {
		return UE;
	}

	public void setUE(String uE) {
		UE = uE;
	}
	 
	 public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public List<EmploiTemps> getEmploitempss() {
		return emploitempss;
	}

	public void setEmploitempss(List<EmploiTemps> emploitempss) {
		this.emploitempss = emploitempss;
	}
	 
	

}
