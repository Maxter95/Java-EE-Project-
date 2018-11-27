package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity

public class Company implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_company;
	private String name_company;
	private String description_company;
	private String domain_company;
	private String address_company;
	@ManyToOne
	private Stand stand;
	@OneToOne
    private CompanyDirector director ;
	
	@OneToMany(mappedBy="companyP")
	private List<ProductLine> lproductLine;
	private static final long serialVersionUID = 1L;

	public Company() {
		super();
	}   
	
	public Company(int id_company, String name_company, String description_company, Stand stand,
			CompanyDirector director, List<ProductLine> lproductLine) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
		this.description_company = description_company;
		this.stand = stand;
		this.director = director;
		this.lproductLine = lproductLine;
	}
	
	public Company(int id_company, String name_company, String description_company, String domain_company,
			String address_company) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
		this.description_company = description_company;
		this.domain_company = domain_company;
		this.address_company = address_company;
	}
	

	public Company(int id_company, String name_company, String description_company, String domain_company,
			String address_company, CompanyDirector director) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
		this.description_company = description_company;
		this.domain_company = domain_company;
		this.address_company = address_company;
		this.director = director;
	}

	public Company(int id_company, String name_company, String description_company, Stand stand) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
		this.description_company = description_company;
		this.stand = stand;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int getId_c() {
		return id_company;
	}

	public void setId_c(int id_c) {
		this.id_company = id_c;
	}

	public String getName_company() {
		return this.name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}   
	public String getDescription_company() {
		return this.description_company;
	}

	public void setDescription_company(String description_company) {
		this.description_company = description_company;
	}
	
	public List<ProductLine> getLproductLine() {
		return lproductLine;
	}

	public void setLproductLine(List<ProductLine> lproductLine) {
		this.lproductLine = lproductLine;
	}

	public int getId_company() {
		return id_company;
	}

	public void setId_company(int id_company) {
		this.id_company = id_company;
	}

	public String getDomain_company() {
		return domain_company;
	}

	public void setDomain_company(String domain_company) {
		this.domain_company = domain_company;
	}

	public String getAddress_company() {
		return address_company;
	}

	public void setAddress_company(String address_company) {
		this.address_company = address_company;
	}

	public CompanyDirector getDirector() {
		return director;
	}

	public void setDirector(CompanyDirector director) {
		this.director = director;
	}
	
	
   
}
