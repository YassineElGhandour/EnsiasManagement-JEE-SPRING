package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;

import entities.Disponibilite;;

public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long>
{
	@Query(value="select * from Disponibilite where heure_dispo = ? AND jour_dispo = ? AND semaine_dispo = ?", nativeQuery=true)
	public List<Disponibilite> findDisponibiliteBySemaine(String heure, String jour, String semaine); 

}
