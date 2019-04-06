package entities;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="Salle")
public class Salle 
{
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idSalle;
    
    @Column(name = "nom_salle", nullable = false)
    @ColumnDefault("' '")
    private String nomSalle = " ";
    
    /*
    @ManyToOne
    @JoinColumn(name="ID_Matiere")
    private Matiere matiere;
    */
    
    
	@OneToMany(mappedBy="salle",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<EmploiTemps> emploitempss;
	
	/*
    private Date dateSalle;
	
	private String heureSalle;
*/
	
	public Salle() {}

	public Salle(String nomSalle, Matiere matiere,
			List<EmploiTemps> emploitempss, Date dateSalle, String heureSalle) {
		super();
		this.nomSalle = nomSalle;
		//this.matiere = matiere;
		this.emploitempss = emploitempss;
		//this.dateSalle = dateSalle;
		//this.heureSalle = heureSalle;
	}





	public Long getIdSalle() {
		return idSalle;
	}



	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}



	public String getNomSalle() {
		return nomSalle;
	}



	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}    
    
	/*
	  public Matiere getMatiere() {
			return matiere;
		}

	public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
	}

	public Date getDateSalle() {
		return dateSalle;
	}

	public void setDateSalle(Date dateSalle) {
		this.dateSalle = dateSalle;
	}

	public String getHeureSalle() {
		return heureSalle;
	}

	public void setHeureSalle(String heureSalle) {
		this.heureSalle = heureSalle;
	}*/

	public List<EmploiTemps> getEmploitempss() {
		return emploitempss;
	}

	public void setEmploitempss(List<EmploiTemps> emploitempss) {
		this.emploitempss = emploitempss;
	}	

}
