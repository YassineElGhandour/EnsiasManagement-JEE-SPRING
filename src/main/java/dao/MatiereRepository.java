package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Matiere;

public interface MatiereRepository extends  JpaRepository<Matiere, Long>
{

}
