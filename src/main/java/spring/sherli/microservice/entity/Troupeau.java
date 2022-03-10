package spring.sherli.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Troupeau {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long troupeauId;
	
	private String name;

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

	public Troupeau(Long troupeauId, String name) {
		
		this.troupeauId = troupeauId;
		this.name = name;
	}

	public Troupeau() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
