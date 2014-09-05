package com.claro.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "JSFManagedBeanSelect2")
public class JSFManagedBeanSelect2 {

	private String Selct2 = "";
	
	/**
	 * Metodo que va a realizar la llamada a la pagina XXX
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @return void
	 * @throws Exception
	 * 
	 * */
	public void voySelect2() throws Exception {
		try 
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect(this.Selct2 + ".xhtml");
		} catch (IOException e) {
			throw new Exception("hubo un  error  al  querer redireccionar  al pagina select 2");
		}

	}
	
	public String getSelct2() {
		return Selct2;
	}

	public void setSelct2(String option) {
		this.Selct2 = option;
	}
}