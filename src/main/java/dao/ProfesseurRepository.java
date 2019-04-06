package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long>{
	
	@Query(value="select * from users where role = 'ROLE_PROF' and email = ?", nativeQuery=true)
	public List<Professeur> findProfesseurByEmail(String email); 
	
	@Query(value="select * from users where role = 'ROLE_PROF' and email = ?", nativeQuery=true)
	public Professeur findOneProfesseurByEmail(String email); 
	
	@Query(value="select * from users where role = 'ROLE_PROF' and username = ?", nativeQuery=true)
	public Professeur findOneProfesseurByUsername(String username); 


}
