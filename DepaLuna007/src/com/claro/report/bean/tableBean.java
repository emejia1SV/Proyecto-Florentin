package com.claro.report.bean;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class tableBean {

	private List<ReportesLista> fecha;
	private ReportesLista selectedFecha;
	
	//constructor
	public tableBean() {
		fecha= new ArrayList<ReportesLista>();
		ReportesLista fecha1 = new ReportesLista("01/01/2014");
		ReportesLista fecha2 = new ReportesLista("10/02/2014");
		ReportesLista fecha3 = new ReportesLista("12/03/2014");
		ReportesLista fecha4 = new ReportesLista("15/04/2014");
		ReportesLista fecha5 = new ReportesLista("18/05/2014");
		ReportesLista fecha6 = new ReportesLista("25/06/2014");
		ReportesLista fecha7 = new ReportesLista("30/07/2014");
		fecha.add(fecha1);
		fecha.add(fecha2);
		fecha.add(fecha3);
		fecha.add(fecha4);
		fecha.add(fecha5);
		fecha.add(fecha6);
		fecha.add(fecha7);
		
		
	}
	
	
	public List<ReportesLista> getFecha() {
		return fecha;
	}
	public void setFecha(List<ReportesLista> fecha) {
		this.fecha = fecha;
	}
	public ReportesLista getSelectedFecha() {
		return selectedFecha;
	}
	public void setSelectedFecha(ReportesLista selectedFecha) {
		this.selectedFecha = selectedFecha;
	}
	
}
