package productServices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;

@Remote
public interface ProductServicesRemote {
	  public void AddProduct(Product1 product);
	  public void DeleteProduct(Product1 product);
	  public void UpdateProduct(Product1 product);
	  public Product1 FindProductById(Integer id);
	  public void DeleteProductById(int id);
	  public List<Product1> FindAllProducts();
	  public List<Product1> findWithName(String name_product);
	  public void buy(int id);
	  public void view(int id);
	  public List<Product1> findTopProduit();
	  public List<Product1> findTopRatedProduit();



}
