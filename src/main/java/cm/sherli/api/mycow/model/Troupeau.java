package cm.sherli.api.mycow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Troupeau extends AuditModel {
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="troupeauid")
    private Long troupeauId;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Troupeau(String name, String description) {
		this.name = name;
		this.description = description;
	}
	

	
	
}
