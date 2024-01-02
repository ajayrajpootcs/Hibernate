package hibernate.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString

@Entity(name="teamar")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userName")
	private String name;
	private String gender;
	private int salary;
	

}
