package SoftwareLanguages.Languages.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="SoftwareLanguages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftwareLanguages {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
private int id;
	@Column(name="name")
private String name;
}
