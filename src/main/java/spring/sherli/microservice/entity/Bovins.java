package spring.sherli.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bovins extends AuditModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bovinId;
	private String uniqeId;
	private String firstPhysicId;
	private String secPhysicId;
	//@JsonFormat(pattern = "dd-MM-YYYY")
	private String birthDay;
	//private String sex;
	private String modeReproduction;
	private Double weightAtBirth;
	private Double heightAtBirth;
	private String race;
	private String robe;
	private String cornage;
	/*@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "recorded_at", nullable = false, updatable = false)
    @CreatedDate
    private Date recordedAt;
   */
	/*@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;
	*/
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "troupeau_id")
    private  Troupeau troupeau;

	public Long getBovinId() {
		return bovinId;
	}

	public void setBovinId(Long bovinId) {
		this.bovinId = bovinId;
	}

	public String getUniqeId() {
		return uniqeId;
	}

	public void setUniqeId(String uniqeId) {
		this.uniqeId = uniqeId;
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

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getRobe() {
		return robe;
	}

	public void setRobe(String robe) {
		this.robe = robe;
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


	public Bovins(Long bovinId, String uniqeId, String firstPhysicId, String secPhysicId, String birthDay, String sex,
			String modeReproduction, Double weightAtBirth, Double heightAtBirth, String race, String robe,
			String cornage,Troupeau troupeau) {
		this.bovinId = bovinId;
		this.uniqeId = uniqeId;
		this.firstPhysicId = firstPhysicId;
		this.secPhysicId = secPhysicId;
		this.birthDay = birthDay;
		this.modeReproduction = modeReproduction;
		this.weightAtBirth = weightAtBirth;
		this.heightAtBirth = heightAtBirth;
		this.race = race;
		this.robe = robe;
		this.cornage = cornage;
		this.troupeau = troupeau;
	}

	public Bovins() {
		// TODO Auto-generated constructor stub
	}

	
	
}
