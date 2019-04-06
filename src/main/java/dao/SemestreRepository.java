package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long>
{
	

}
