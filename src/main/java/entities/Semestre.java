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
@Table(name="Semestre")
public class Semestre 
{
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long idSemestre;
	  
	  private String nomSemestre;
	  private String periodeSemestre;
	  
	  @OneToMany(mappedBy="semestre",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<Matiere> matieres;
	  
	  @OneToMany(mappedBy="semestre",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 private List<EmploiTemps> emploitempss;

	  public Semestre() {}

	  
	  
	public Semestre(String nomSemestre, String periodeSemestre,
			List<Matiere> matieres, List<EmploiTemps> emploitempss) {
		super();
		this.nomSemestre = nomSemestre;
		this.periodeSemestre = periodeSemestre;
		this.matieres = matieres;
		this.emploitempss = emploitempss;
	}



	public Long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getNomSemestre() {
		return nomSemestre;
	}

	public void setNomSemestre(String nomSemestre) {
		this.nomSemestre = nomSemestre;
	}

	public String getPeriodeSemestre() {
		return periodeSemestre;
	}

	public void setPeriodeSemestre(String periodeSemestre) {
		this.periodeSemestre = periodeSemestre;
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
