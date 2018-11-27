package productServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Category;

@Local
public interface CategoriesServicesLocal {
	public List<Category> FindAllCateogorie();
	public void AddCategorie(Category categorie);
	public List<Category> findWithName(String model_product);
}
