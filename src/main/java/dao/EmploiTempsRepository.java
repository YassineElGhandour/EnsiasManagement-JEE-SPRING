package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.EmploiTemps;

public interface EmploiTempsRepository extends JpaRepository<EmploiTemps, Long>
{
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND Id_filiere = 1", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDay(String heure, String jour);
	
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND Id_filiere = 1", nativeQuery=true)
	public EmploiTemps findOneEmploiByHourAndDay(String heure, String jour); 

	/* --- ICI ---*/
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND Id_filiere = ? AND semaine_emploi = ?", nativeQuery=true)
	public EmploiTemps findOneEmploiByHourAndDayAndFiliereAndSemaine(String heure, String jour, Long idFiliere, String nomSemaine); 
	
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND id_filiere = ? AND semaine_emploi = ?", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDayAndFiliereAndSemaine(String heure, String jour, Long idFiliere, String semaine); 
	
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ?", nativeQuery=true)
	public EmploiTemps[][] findEmploiByHourAndDayEasyWay(String hour, String day);

	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND id_filiere = ? AND semaine_emploi = ? AND id_groupe = ?", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(String heure, String jour, Long idFiliere, String semaine, Long idGroupe); 

	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND semaine_emploi = ? AND id_salle = ?", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(String heure, String jour,  String semaine, Long idSalle); 

	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND semaine_emploi = ? AND id_professeur IN (SELECT userid from users where email = ?) ", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDayAndFiliereAndSemaineAndProf(String heure, String jour, String semaine, String emailProfesseur); 
	
	@Query(value="SELECT * from emploi_temps WHERE heure_emploi = ? AND jour_emploi = ? AND semaine_emploi = ? AND id_matiere = ? ", nativeQuery=true)
	public List<EmploiTemps> findEmploiByHourAndDayAndFiliereAndSemaineAndMat(String heure, String jour, String semaine, Long idMatiere); 

}
