package com.claro.report.bean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.claro.report.common.AbstractReportBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.sf.jasperreports.engine.JRException;
@ManagedBean(name = "reportsBean")
@ApplicationScoped

public class ReportsBean extends AbstractReportBean {
	  private final String COMPILE_FILE_NAME = "report6";
	    
	  
	    @Override
	    protected String getCompileFileName() {
	        return COMPILE_FILE_NAME;
	    }
	 
	    @Override
	    protected Map<String, Object> getReportParameters() {
	        Map<String, Object> reportParameters = new HashMap<String, Object>();
	 
	        reportParameters.put("nombre", "Claro depurador de agregadores a continuacion se muestran los numeros preocesados:");
	        reportParameters.put("numeros", "50370170722 \n 50370172230");
	 
	        return reportParameters;
	    }
	 
	    public String execute() {
	        try {
	            super.prepareReport();
	        } catch (Exception e) {
	            // make your own exception handling
	            e.printStackTrace();
	        }
	 
	        return null;
	    }
	    
	 
}


