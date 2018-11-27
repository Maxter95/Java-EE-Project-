package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: PosterLinePK
 *
 */


@Embeddable

public class PosterLinePK implements Serializable {

	

	private int id_fair_PK;
	private int id_poster_PK;
	private static final long serialVersionUID = 1L;

	public PosterLinePK() {
		super();
	}   
	
	public int getId_fair_PK() {
		return id_fair_PK;
	}

	public void setId_fair_PK(int id_fair_PK) {
		this.id_fair_PK = id_fair_PK;
	}

	public int getId_poster_PK() {
		return id_poster_PK;
	}

	public void setId_poster_PK(int id_poster_PK) {
		this.id_poster_PK = id_poster_PK;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_fair_PK;
		result = prime * result + id_poster_PK;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosterLinePK other = (PosterLinePK) obj;
		if (id_fair_PK != other.id_fair_PK)
			return false;
		if (id_poster_PK != other.id_poster_PK)
			return false;
		return true;
	}

	
	
   
}
