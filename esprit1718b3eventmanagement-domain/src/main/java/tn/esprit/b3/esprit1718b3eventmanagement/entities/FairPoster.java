package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: FairPoster
 *
 */
@Entity

public class FairPoster implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_poster;
	private Blob image_poster;
	private String description_poster;
	@OneToMany(mappedBy="posterP")
	private List<PosterLine> lPosterLine;
	
	private static final long serialVersionUID = 1L;

	public FairPoster() {
		super();
	}   
	public int getId_poster() {
		return this.id_poster;
	}

	public void setId_poster(int id_poster) {
		this.id_poster = id_poster;
	}   
	public Blob getImage_poster() {
		return this.image_poster;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setImage_poster(Blob image_poster) {
		this.image_poster = image_poster;
	}   
	public String getDescription_poster() {
		return this.description_poster;
	}

	public void setDescription_poster(String description_poster) {
		this.description_poster = description_poster;
	}
	
	public List<PosterLine> getlPosterLine() {
		return lPosterLine;
	}
	public void setlPosterLine(List<PosterLine> lPosterLine) {
		this.lPosterLine = lPosterLine;
	}
	
	   
}
