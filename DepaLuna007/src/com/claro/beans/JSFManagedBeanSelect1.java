package com.claro.beans;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "JSFManagedBeanSelect1")
public class JSFManagedBeanSelect1 {

	/**
	 * 
	 * */
	public void voyAReportes() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Reportes.xhtml");
			} catch (IOException e) {
		e.printStackTrace();
			}
    
	}
       
	/**
	 * 
	 * */
	public void voyASelect2() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Select2.xhtml");
			} catch (IOException e) {
		e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * */
	public void voyAconfiguracion() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("configuracion.xhtml");
			} catch (IOException e) {
		e.printStackTrace();
			}
	}
}