package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;


import java.util.Date;
import javax.persistence.*;

import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: PosterLine
 *
 */
@Entity

public class PosterLine implements Serializable {

	@EmbeddedId 
	private PosterLinePK PosterLinePK ;
	
	private Date dateFair;
	@ManyToOne 
	@JoinColumn(name="id_fair_PK",referencedColumnName="id_fair",insertable=false,updatable=false)
	private Fair fair2P;
	@ManyToOne
	@JoinColumn(name="id_poster_PK",referencedColumnName="id_poster",insertable=false,updatable=false)
	private FairPoster posterP;

	private static final long serialVersionUID = 1L;

	public PosterLine() {
		super();
	}   
	public Date getDateFair() {
		return this.dateFair;
	}

	public void setDateFair(Date dateFair) {
		this.dateFair = dateFair;
	}
	

	public PosterLinePK getPosterLinePK() {
		return PosterLinePK;
	}
	public void setPosterLinePK(PosterLinePK posterLinePK) {
		PosterLinePK = posterLinePK;
	}
	
	

	public Fair getFair2P() {
		return fair2P;
	}
	public void setFair2P(Fair fair2p) {
		fair2P = fair2p;
	}
	
	public FairPoster getPosterP() {
		return posterP;
	}
	public void setPosterP(FairPoster posterP) {
		this.posterP = posterP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
}
