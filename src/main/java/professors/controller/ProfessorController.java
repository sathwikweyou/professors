package professors.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import professors.entity.ProfessorEntity;
import professors.service.ProfessorService;


@RestController
@RequestMapping(path = "/api/professor")

public class ProfessorController {
	
	@Autowired
	private final ProfessorService professorservice;

	public ProfessorController(ProfessorService professorservice) {
		this.professorservice = professorservice;
	}

	@PostMapping
	public void addProfessor(@RequestBody ProfessorEntity professorentity){
		professorservice.addProfessor(professorentity);
	}

	@GetMapping(path = "{id}")
	public Optional<ProfessorEntity> getProfessorById(@PathVariable Integer id){
		return professorservice.getProfessorById(id);
	}

	@GetMapping
	public List<ProfessorEntity> getProfessorByAsc(){
		return professorservice.getProfessorByAsc();
	}

	@PutMapping(path = "{id}")
	public void updateProfessorSalary(@PathVariable("id") Integer id,@RequestParam Double salary){
		professorservice.updateProfessorSalary(id,salary);
	}


}
