package spring.sherli.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bovins extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bovinId;
	@Value("SODEPA_")
	private String uniqueid;
	private String firstPhysicId;
	private String secPhysicId;
	//@JsonFormat(pattern = "dd-MM-YYYY")
	private String birthDay;
	private String sex;
	private String modeReproduction;
	private Double weightAtBirth;
	private Double heightAtBirth;
	private String country;
	
	private String cornage;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "troupeauid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private  Troupeau troupeau;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "robe_id")
	private Robe robe;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "race_id")
	private Race race;

	public Long getBovinId() {
		return bovinId;
	}

	public void setBovinId(Long bovinId) {
		this.bovinId = bovinId;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getFirstPhysicId() {
		return firstPhysicId;
	}

	public void setFirstPhysicId(String firstPhysicId) {
		this.firstPhysicId = firstPhysicId;
	}

	public String getSecPhysicId() {
		return secPhysicId;
	}

	public void setSecPhysicId(String secPhysicId) {
		this.secPhysicId = secPhysicId;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getModeReproduction() {
		return modeReproduction;
	}

	public void setModeReproduction(String modeReproduction) {
		this.modeReproduction = modeReproduction;
	}

	public Double getWeightAtBirth() {
		return weightAtBirth;
	}

	public void setWeightAtBirth(Double weightAtBirth) {
		this.weightAtBirth = weightAtBirth;
	}

	public Double getHeightAtBirth() {
		return heightAtBirth;
	}

	public void setHeightAtBirth(Double heightAtBirth) {
		this.heightAtBirth = heightAtBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCornage() {
		return cornage;
	}

	public void setCornage(String cornage) {
		this.cornage = cornage;
	}

	public Troupeau getTroupeau() {
		return troupeau;
	}

	public void setTroupeau(Troupeau troupeau) {
		this.troupeau = troupeau;
	}

	public Robe getRobe() {
		return robe;
	}

	public void setRobe(Robe robe) {
		this.robe = robe;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	
}
