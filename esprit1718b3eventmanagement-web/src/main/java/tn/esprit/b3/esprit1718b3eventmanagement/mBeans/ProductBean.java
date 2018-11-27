package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import productServices.ProductServices;
import productServices.ProductServicesRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;

@ManagedBean
@ViewScoped
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProductServices productServices;
	private Product1 product;
	private String name_product;
	private List<Product1> listproduct = new ArrayList<Product1>();
	private Product1 productshow;
	public static Product1 name12;
	private String recherche;
	

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public static Product1 getName12() {
		return name12;
	}

	public static void setName12(Product1 name12) {
		ProductBean.name12 = name12;
	}

	public String getName() {
		return name12.getName_product();
	}
	
	public int getViews() {
		return name12.getViews();
	}
	
	public String getDel(){
		return name12.getDelivery_mode();
	}
	public String getBrand(){
		return name12.getBrand_categorie();
	}
	public String getPayment(){
		return name12.getPayment_type();
	}
	public float getPrice(){
		return name12.getPrice_product();
	}
	
	
	public int getNumberavailable(){
		return name12.getNumber_available();
	}
	
	public int getID(){
		return name12.getId_p();
	}

	public Product1 getProductshow() {
		return productshow;
	}

	public void setProductshow(Product1 productshow) {
		this.productshow = productshow;
	}

	public ProductBean() {
	}

	@PostConstruct
	public void init() {
		listproduct = productServices.FindAllProducts();
		product = new Product1();
	}


	public String addProduct() {
		product.setName_product(name_product);
		//product.setImage(fileName);
		productServices.AddProduct(product);
		return "adminPage2?faces-redirect=true";
	}
	public String showDetails(Product1 p) {
		name12=p;
		System.out.println("  "+name12+"   ");
		productServices.buy(p.getId_p());
		productServices.view(p.getId_p());
		return "detailsPage?faces-redirect=true";
	}
	public String Buy(Product1 p) {
		productServices.buy(p.getId_p());
		return "detailsPage?faces-redirect=true";
	}
	



	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String removeProduct(Product1 pro) {
		productServices.DeleteProduct(pro);
		product = new Product1();
		return "product?faces-redirect=true";
	}

	public List<Product1> displayallProduct() {
		listproduct = productServices.FindAllProducts();
		System.out.println(listproduct);
		return listproduct;
	}

	public Product1 getProduct() {
		return product;
	}

	public void setProduct(Product1 product) {
		this.product = product;
	}

	public List<Product1> getListproduct() {
		return listproduct;
	}

	public void setListproduct(List<Product1> listproduct) {
		this.listproduct = listproduct;
	}


//////////////////
	
	public String removeProduit(Product1 P) {
		System.out.println(P);
		productServices.DeleteProductById(product.getId_p());;
	return "adminPage2?faces-redirect=true";
	}
	

	 public List<Product1> FindWithName(String name){
			
		 listproduct=productServices.findWithName(name);
	    	System.out.println(listproduct);
			return listproduct;
			
		}
	 public String redirecttoname(){
		 return "adminPage3?faces-redirect=true";
	 }
	 public String redirecttoname1(){
		 return "addPage?faces-redirect=true";
	 }
	 public void PDF() 
	    {
	    	Document document = new Document();
	    try
	    {
	       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/Details_produit.pdf"));
	       document.open();
	      
	      PdfPTable table = new PdfPTable(5); // 3 columns.
	      table.setWidthPercentage(100); //Width 100%
	      table.setSpacingBefore(10f); //Space before table
	      table.setSpacingAfter(10f); //Space after table
	
	      //Set Column widths
	      float[] columnWidths = {1f,1f,1f,1f,1f};
	      table.setWidths(columnWidths);
	
	       PdfPCell c1 = new PdfPCell(new Phrase("Name Product"));
	      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	      table.addCell(c1);
	      
		      c1 = new PdfPCell(new Phrase("Price"));
		      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(c1);
		      c1 = new PdfPCell(new Phrase("Brand category"));
		      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(c1);
		      c1 = new PdfPCell(new Phrase("Delivery"));
		      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(c1);
		
		      c1 = new PdfPCell(new Phrase("Payment via"));
		      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(c1);
		      table.setHeaderRows(1);
		      
			  Product1 c = new Product1();
				List<Product1> o = productServices.FindAllProducts();
				
				//tableProduit.setItems(data1);
		      for (int i = 0; i < o.size(); i++) {
		        
	            table.addCell(o.get(i).getName_product());
	            table.addCell(o.get(i).getPrice_product()+"");
	            table.addCell(o.get(i).getBrand_categorie());
	            table.addCell(o.get(i).getDelivery_mode());
	            table.addCell(o.get(i).getPayment_type());  } 
	      		document.add(new Paragraph("******Liste Des produits******"));
			      document.add(table);
			      
			      document.close();
			      writer.close();
			    } catch (DocumentException e)
			    {
			       e.printStackTrace();
			    } catch (FileNotFoundException e)
			    {
			       e.printStackTrace();
}}
	
	
	
	
	
}
