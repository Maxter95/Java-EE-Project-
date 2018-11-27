package productServices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Category;

@Remote
public interface CategoriesServicesRemote {
	public List<Category> FindAllCateogorie();
	public void AddCategorie(Category categorie);
	public List<Category> findWithName(String model_product);
}
