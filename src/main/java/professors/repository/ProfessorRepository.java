package professors.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import professors.entity.ProfessorEntity;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer>{
	
	@Query("SELECT p FROM ProfessorEntity p WHERE p.id=?1")
	Optional<ProfessorEntity> findProfessorById(Integer id);
}