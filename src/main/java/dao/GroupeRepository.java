package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long>
{
	@Query(value="select * from groupe where id_groupe = ? ", nativeQuery=true)
	public List<Groupe> findGroupeById(Long id_groupe); 	
	
	@Query(value="select * from groupe where id_groupe = ? ", nativeQuery=true)
	public Groupe findOneGroupeById(Long id_groupe); 

}
