package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;



import javax.persistence.*;

import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: StandLine
 *
 */
@Entity

public class StandLine implements Serializable {

	@EmbeddedId 
	private StandLinePK standLinePK ;
	private float amount;
	@ManyToOne 
	@JoinColumn(name="id_stand_PK",referencedColumnName="id_stand",insertable=false,updatable=false)
	private Stand standP;
	@ManyToOne
	@JoinColumn(name="id_fair_PK",referencedColumnName="id_fair",insertable=false,updatable=false)
	private Fair fairP;

	private static final long serialVersionUID = 1L;

	public StandLine() {
		super();
	}
	
	public StandLinePK getStandLinePK() {
		return standLinePK;
	}

	public void setStandLinePK(StandLinePK standLinePK) {
		this.standLinePK = standLinePK;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
	public Stand getStandP() {
		return standP;
	}
	public void setStandP(Stand standP) {
		this.standP = standP;
	}

	public Fair getFairP() {
		return fairP;
	}
	public void setFairP(Fair fairP) {
		this.fairP = fairP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}   
	


	
	
	
   
}
