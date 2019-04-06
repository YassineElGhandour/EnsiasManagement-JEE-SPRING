package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long>
{

}
