package spring.sherli.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Troupeau extends AuditModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long troupeauId;
	
	private String name;

	private String desciption;

	public Long getTroupeauId() {
		return troupeauId;
	}

	public void setTroupeauId(Long troupeauId) {
		this.troupeauId = troupeauId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	
	
}
