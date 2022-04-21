package professors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import professors.entity.ProfessorEntity;
import professors.repository.ProfessorRepository;

import javax.transaction.Transactional;


@Component
public class ProfessorService {
	@Autowired
	private final ProfessorRepository professorrepository;

	public ProfessorService(ProfessorRepository professorrepository) {
		this.professorrepository = professorrepository;
	}

	public void addProfessor(ProfessorEntity professorentity) {
		Optional<ProfessorEntity> professorOptional = professorrepository.findProfessorById(professorentity.getId());
		if(professorOptional.isPresent()){
			throw new IllegalArgumentException("Professor already exists in the database");
		}
		professorrepository.save(professorentity);
	}


	@Transactional
	public void updateProfessorSalary(Integer id, Double salary) {
		ProfessorEntity professorentity = professorrepository.findProfessorById(id).orElseThrow(() -> new IllegalArgumentException("Professor with id"+id+" does not exist"));
			if(salary>0){
				professorentity.setSalary(salary);
			}else {
				throw new IllegalArgumentException("Salary should be greater than zero");
			}
	}


	public Optional<ProfessorEntity> getProfessorById(Integer id) {
		return professorrepository.findProfessorById(id);
	}

	public List<ProfessorEntity> getProfessorByAsc() {
		return professorrepository.findAll(Sort.by("salary").descending().and(Sort.by("name")));
	}

}
