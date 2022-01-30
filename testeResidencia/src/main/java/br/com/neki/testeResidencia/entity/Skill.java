package br.com.neki.testeResidencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "skill", schema = "teste_residencia")
public class Skill {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_generator")
	@SequenceGenerator(name = "skill_generator", sequenceName = "skill_seq", schema = "teste_residencia")
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	@Size(max = 100)
	private String name;

	@Column(name = "version", nullable = true, length = 10)
	@Size(max = 10)
	private String version;

	@Column(name = "description", nullable = false, length = 255)
	@Size(max = 255)
	private String description;

	@Column(name = "image_url", nullable = true, length = 255)
	@Size(max = 255)
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
