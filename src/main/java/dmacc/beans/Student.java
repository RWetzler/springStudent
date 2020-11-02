package dmacc.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String grade;
	
	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
	public Student(long id,String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
}
