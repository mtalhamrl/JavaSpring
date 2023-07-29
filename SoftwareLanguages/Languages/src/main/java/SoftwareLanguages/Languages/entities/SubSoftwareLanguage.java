package SoftwareLanguages.Languages.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="SubSoftwareLanguages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubSoftwareLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
private int id;
	@Column(name="subName")
private String subName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="softwareLanguages_id")
	private SoftwareLanguages softwareLanguages;

}
