package professors.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProfessorEntity {
	
	@Id
	private Integer id;
	private String name;
	private Double salary;
	private String subject;
	
	public ProfessorEntity() {
	}
	
	public ProfessorEntity(Integer id, String name, Double salary, String subject) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", subject='" + subject + '\'' +
				", salary=" + salary +
				'}';
	}

}
