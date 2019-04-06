package entities;

import javax.persistence.CascadeType;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Matiere")
public class Matiere {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMatiere;
	private String nomMatiere = " ";
	private Date dateMatiere;
	
	 @OneToMany(mappedBy="matiere",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<EmploiTemps> emploitempss;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Matiere_Professeur", 
        joinColumns = { @JoinColumn(name = "ID_Professeur")}, 
        inverseJoinColumns = { @JoinColumn(name = "ID_matiere") }
    )
    private List<Professeur> professeurs;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Matiere_Groupe", 
        joinColumns = { @JoinColumn(name = "ID_Groupe")}, 
        inverseJoinColumns = { @JoinColumn(name = "ID_matiere") }
    ) 
    private List<Groupe> groupes;
    
	/*
    @OneToMany(mappedBy="matiere",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
    private List<Salle> salles;*/
    
    @ManyToOne
    @JoinColumn(name="ID_Semestre")
    private Semestre semestre;


	public Matiere(){}


	public Matiere(String nomMatiere, Date dateMatiere,
			List<EmploiTemps> emploitempss, List<Professeur> professeurs,
			List<Groupe> groupes, List<Salle> salles, Semestre semestre) {
		super();
		this.nomMatiere = nomMatiere;
		this.dateMatiere = dateMatiere;
		this.emploitempss = emploitempss;
		this.professeurs = professeurs;
		this.groupes = groupes;
		//this.salles = salles;
		this.semestre = semestre;
	}


	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public Date getDateMatiere() {
		return dateMatiere;
	}

	public void setDateMatiere(Date dateMatiere) {
		this.dateMatiere = dateMatiere;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	/*
	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}*/
	

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
    
    public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}


	public List<EmploiTemps> getEmploitempss() {
		return emploitempss;
	}


	public void setEmploitempss(List<EmploiTemps> emploitempss) {
		this.emploitempss = emploitempss;
	}
	
	
}
