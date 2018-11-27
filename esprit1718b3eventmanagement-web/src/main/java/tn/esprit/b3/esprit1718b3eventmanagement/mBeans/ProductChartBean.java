package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

import productServices.ProductServicesRemote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;




@ManagedBean
@ViewScoped
public class ProductChartBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	public ProductServicesRemote ProduitCrudLocal;


	private List<Product1> listProduit = new ArrayList<Product1>();
	private List<Product1> listTopRatedProduit = new ArrayList<Product1>();



	public List<Product1> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Product1> listProduit) {
		this.listProduit = listProduit;
	}

	private PieChartModel pieModel1;
	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	private PieChartModel pieModel2;
	private HorizontalBarChartModel horizontalBarModel;

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	@PostConstruct
	public void init() {

	    setListProduit(ProduitCrudLocal.findTopProduit());
		setListTopRatedProduit(ProduitCrudLocal.findTopRatedProduit());
		createPieModels();
		createHorizontalBarModel();
		 createPieModel1();

	}

    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
       // createPieModel2();
    }
	

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		for (int i = 0; i < listProduit.size(); i++) {
			pieModel1.set(listProduit.get(i).getName_product().toString(), listProduit.get(i).getViews());

		}

		pieModel1.setTitle("TOP Viewed Product");
		pieModel1.setLegendPosition("c");
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		for (int i = 0; i < listProduit.size(); i++) {
			boys.set(listTopRatedProduit.get(i).getName_product().toString(), listTopRatedProduit.get(i).getPrice_product());

		}
		boys.setLabel("BEST PORDUCT");

		horizontalBarModel.addSeries(boys);

		horizontalBarModel.setTitle("TOP Sales Product");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Prix");
		xAxis.setMin(0);
		xAxis.setMax(100);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Produit");
	}

	public List<Product1> getListTopRatedProduit() {
		return listTopRatedProduit;
	}

	public void setListTopRatedProduit(List<Product1> listTopRatedProduit) {
		this.listTopRatedProduit = listTopRatedProduit;
	}

}