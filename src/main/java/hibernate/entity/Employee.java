package hibernate.entity;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@NamedQueries({
		@NamedQuery(name = "getEmployeeByName", query = "from Employee e where e.name=:name"),
		@NamedQuery(name = "findByGender", query = "from Employee e where e.gender=:gender")
})

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private int salary;

}
