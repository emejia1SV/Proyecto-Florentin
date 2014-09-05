package com.claro.beans;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "JSFManagedBeanLogin")
public class JSFManagedBeanLogin {

	HashMap<String, String> usuarios = new HashMap<String, String>();
	private String usuario =  "";
	private String pass = "";

	@PostConstruct
	public void init() {
		usuarios.put("admin", "admin");
		usuarios.put("Edwin", "Mejia");
	}

	public void voyLogin() 
	{
		try 
		{
			Iterator<Entry<String, String>> itr = usuarios.entrySet().iterator();
			while(itr.hasNext()){
				Entry<String, String> datos = itr.next();
				if(getUsuario().equals(datos.getKey()) && getPass().equals(datos.getValue())){
					FacesContext.getCurrentInstance().getExternalContext().redirect("Select1.xhtml");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void voyParaLogin() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
