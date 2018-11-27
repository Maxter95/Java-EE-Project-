package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.util.Duration;
import rhservices.DemandeCongeServiceLocal;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

@ManagedBean
@SessionScoped
public class Holiday {

	private List<Conge> conge = new ArrayList<Conge>();
	private List<Conge> congeez = new ArrayList<Conge>();
	private List<Staff> Users = new ArrayList<Staff>();
	private Conge conges = new Conge();
	private Conge congi = new Conge();
	private RepeatPaginator paginator;
	@ManagedProperty("#{identity}")
	private Identity identity;
	private int id_co;
	private String type_co;
	@EJB
	private DemandeCongeServiceLocal demandeCongeServiceLocal;
	private Conge SelectedTable;
	Date d = new Date();
	private boolean formDisplay = false;

	public String doDeleteCo(int id) {
		demandeCongeServiceLocal.DeleteDemandeConge(congi);
		intitialization();
		paginator = new RepeatPaginator(conge);
		String n = "/template/index3?faces-redirect=true";

		return n;
	}

	public String doUpdate() {
		System.out.println("seeeeeeeeeeelecyed table ::::::" + SelectedTable.getCertificat());

		demandeCongeServiceLocal.UpdateDemandeConge(SelectedTable);
		intitialization();

		String n = "/AddConge?faces-redirect=true";
		return n;
	}

	public String affiche() {
		System.out.println("mmmmmmmmmmmaaaaaaaaa certtiiiiiiifff:::::" + SelectedTable.getCertificat());
		intitialization();
		String n = "/AddConge?faces-redirect=true";

		return n;
	}

	public String doRemove(Conge congi) {

		demandeCongeServiceLocal.DeleteDemandeConge(congi);
		intitialization();
		// formDisplay = false;
		// paginator = new RepeatPaginator(congeez);
		congi = new Conge();
		String n = "/AddConge?faces-redirect=true";
		return n;

	}

	public String DoCheckSalary() {

		for (Staff str : Users) {
			if (str.getIncrease() < str.getYearswork()) {
				Staff ss = demandeCongeServiceLocal.ChangeDisponibility(str.getCin());
				ss.setSalary_staff((((str.getYearswork()) - (str.getIncrease())) * 2 * (str.getSalary_staff() / 100))
						+ str.getSalary_staff());
				ss.setIncrease(str.getIncrease() + ((str.getYearswork()) - (str.getIncrease())));
				demandeCongeServiceLocal.UpdateStaff(ss);
				intitialization();
			}

		}

		String n = "/Salary?faces-redirect=true";
		return n;
	}

	public String doRemovee(int id_co) {

		demandeCongeServiceLocal.DeleteDemandeCongeByID(id_co);
		intitialization();
		String n = "/AddConge?faces-redirect=true";
		return n;
	}

	public String doUpdateCo() {
		demandeCongeServiceLocal.UpdateDemandeConge(conges);
		intitialization();
		paginator = new RepeatPaginator(conge);
		conges = new Conge();
		String n = "/AddConge?faces-redirect=true";
		return n;
	}

	public String doUppdateCo() {

		// String navigateTo = "";
		String n = "/updateConge?faces-redirect=true";

		// navigateTo = "/updateConge?faces-redirect=true";
		// return navigateTo;
		return n;
	}

	public String doAddCo() {

		// conges.setDate_co(d);
		conges.setCin(identity.getUser().getCin());
		conges.setStatus_co("not yet exhaminated");
		demandeCongeServiceLocal.AddDemandeConge(conges);
		intitialization();
		paginator = new RepeatPaginator(conge);
		conges = new Conge();
		String n = "/AddConge?faces-redirect=true";
		return n;
	}

	public String DoCheckHolidays() {
		// ****************
		for (Conge str : congeez) {

			if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Available")) {
				str.setStatus_co("Accepted");
				demandeCongeServiceLocal.UpdateDemandeConge(str);

			} else if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Unavailable")) {
				str.setStatus_co("Rejected");
				demandeCongeServiceLocal.UpdateDemandeConge(str);

			} else if ((str.getType_co()).equals("Normal") && (str.getCertificat()).equals("Available")
					&& (demandeCongeServiceLocal.ChangeDisponibility(str.getCin()).getNbjrscp()
							+ str.getNbjrs_co()) <= 30) {
				str.setStatus_co("Your request is confusing");
				demandeCongeServiceLocal.UpdateDemandeConge(str);

			} else if ((str.getType_co()).equals("Normal")
					&& (demandeCongeServiceLocal.ChangeDisponibility(str.getCin()).getNbjrscp()
							+ str.getNbjrs_co()) <= 30) {
				str.setStatus_co("Accepted");
				Staff ss = demandeCongeServiceLocal.ChangeDisponibility(str.getCin());
				ss.setNbjrscp((ss.getNbjrscp()) + (str.getNbjrs_co()));
				demandeCongeServiceLocal.UpdateStaff(ss);
				demandeCongeServiceLocal.UpdateDemandeConge(str);

			} else if ((str.getType_co()).equals("Normal")
					&& (demandeCongeServiceLocal.ChangeDisponibility(str.getCin()).getNbjrscp()
							+ str.getNbjrs_co()) > 30) {
				str.setStatus_co("Rejected");
				demandeCongeServiceLocal.UpdateDemandeConge(str);

			}

		}

		// *****************

		String n = "/Holidays?faces-redirect=true";
		return n;
	}
	// @PostConstruct
	// public void init() {
	// conge=demandeCongeServiceLocal.FindAllDemandeConge();
	// setConge(demandeCongeServiceLocal.FindAllDemandeConge());

	// }
	@PostConstruct
	public void intitialization() {

		congeez = demandeCongeServiceLocal.FindAllDemandeConge();
		Users = demandeCongeServiceLocal.FindAllStaff();
		createPieModels();
		createHorizontalBarModel();
		formDisplay = false;
	}

	public List<Conge> getCongeez() {
		return congeez;
	}

	public Conge getSelectedTable() {
		return SelectedTable;
	}

	public List<Staff> getUsers() {
		return Users;
	}

	public void setUsers(List<Staff> users) {
		Users = users;
	}

	public void setSelectedTable(Conge selectedTable) {
		this.SelectedTable = selectedTable;
	}

	public void setCongeez(List<Conge> congeez) {
		this.congeez = congeez;
	}

	public tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge getConges() {
		return conges;
	}

	public void setConges(tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge conges) {
		this.conges = conges;
	}

	public RepeatPaginator getPaginator() {
		return paginator;
	}

	public void setPaginator(RepeatPaginator paginator) {
		this.paginator = paginator;
	}

	public DemandeCongeServiceLocal getDemandeCongeServiceLocal() {
		return demandeCongeServiceLocal;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String getType_co() {
		return type_co;
	}

	public void setType_co(String type_co) {
		this.type_co = type_co;
	}

	public void setDemandeCongeServiceLocal(DemandeCongeServiceLocal demandeCongeServiceLocal) {
		this.demandeCongeServiceLocal = demandeCongeServiceLocal;
	}

	public int getId_co() {
		return id_co;
	}

	public void setId_co(int id_co) {
		this.id_co = id_co;
	}

	public Date getD() {
		return d;
	}

	public boolean isFormDisplay() {
		return formDisplay;
	}

	public void setFormDisplay(boolean formDisplay) {
		this.formDisplay = formDisplay;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public void setConge(List<Conge> conge) {
		this.conge = conge;
	}

	public List<Conge> getConge() {
		return conge;
	}

	public Conge getCongi() {
		return congi;
	}

	public void setCongi(Conge congi) {
		this.congi = congi;
	}

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private HorizontalBarChartModel horizontalBarModel;

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
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

		for (int i = 0; i < congeez.size(); i++) {
			pieModel1.set(congeez.get(i).getType_co().toString(), congeez.get(i).getNbjrs_co());

		}

		pieModel1.setTitle("Holiday requests");
		pieModel1.setLegendPosition("c");
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		for (int i = 0; i < Users.size(); i++) {
			boys.set(Users.get(i).getFirst_name(), Users.get(i).getSalary_staff());

		}
		boys.setLabel("Salary");

		horizontalBarModel.addSeries(boys);

		horizontalBarModel.setTitle("Salary");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Salary");
		xAxis.setMin(0);
		xAxis.setMax(3000);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("FirstName");
	}

}
