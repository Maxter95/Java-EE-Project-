package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import productServices.CategoriesServicesRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Category;



@ManagedBean
@SessionScoped
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private CategoriesServicesRemote CategoryService;
	private List<Category> ListCat=new ArrayList<Category>();
	private Category C=new Category();
	private List<String> ListNameGat=new ArrayList<String>();
	private List<String> ListBrandCat=new ArrayList<String>();

	

	public Categorie() {}
	
	@PostConstruct
	public void init() {

	ListCat=CategoryService.FindAllCateogorie();
	C =new Category();
	
	}
public List<Category> findallCategories(){
		
    	ListCat=CategoryService.FindAllCateogorie();
		return ListCat;
		
	}
	public CategoriesServicesRemote getCategorieService() {
		return CategoryService;
	}

	public void setCategoryService(CategoriesServicesRemote categoryService) {
		CategoryService = categoryService;
	}


	/*
	 public Category getCategory(Integer id) {
	        if (id == null){
	            throw new IllegalArgumentException("no id provided");
	        }
	        for (Category p : ListCat){
	        
	     
	        	Integer i = (int) (long) p.getId_();
	        
	            if (id.equals(i)){
	           
	                return p;
	            }
	        }
	        return null;
	    }
	*/
	
	public List<String> findall(){
		
		ListCat=CategoryService.FindAllCateogorie();
		for(Category C :ListCat){
			
			
			ListNameGat.add(C.getModel_category());
		}
		return ListNameGat;
	}
		public List<String> findallb(){
			
			ListCat=CategoryService.FindAllCateogorie();
			for(Category C :ListCat){			
				ListBrandCat.add(C.getBrand_category());
			}
		
		return ListBrandCat;
	}

		public List<Category> getListCat() {
			return ListCat;
		}

		public void setListCat(List<Category> listCat) {
			ListCat = listCat;
		}

		public Category getC() {
			return C;
		}

		public void setC(Category c) {
			C = c;
		}

		public List<String> getListNameGat() {
			return ListNameGat;
		}

		public void setListNameGat(List<String> listNameGat) {
			ListNameGat = listNameGat;
		}

		public List<String> getListBrandCat() {
			return ListBrandCat;
		}

		public void setListBrandCat(List<String> listBrandCat) {
			ListBrandCat = listBrandCat;
		}

		public CategoriesServicesRemote getCategoryService() {
			return CategoryService;
		}
		
}