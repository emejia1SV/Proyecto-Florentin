package com.claro.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.claro.exel.ExcelSheetReader;
import com.claro.report.common.AbstractReportBean;

@ManagedBean
@RequestScoped
public class uploadbean extends AbstractReportBean {

	private int typeXls = -1;
	private Part file;
	private String fileContent;

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	@SuppressWarnings("rawtypes")
	private List exelDataList = new ArrayList();

	public void upload() 
	{
		try 
		{
			fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();

			switch (this.typeXls) 
			{
			case 0:
				this.exelDataList = new ExcelSheetReader().readExcelFile((FileInputStream) file.getInputStream());
				execute();
				break;
			case 1:
				this.exelDataList = new ExcelSheetReader().readExcelxFile((FileInputStream) file.getInputStream());
				execute();
				break;
			case -1:
				System.out.println("error en la carga del archivo no se pudo determinar el tipo");
				break;
			default:
				break;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void validateFile(FacesContext ctx, UIComponent comp, Object value) 
	{
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part) value;

		// validar tipo de archivo
		this.typeXls = 0;
		if (!"application/vnd.ms-excel".equals(file.getContentType())) 
		{
			this.typeXls = 1;
			if (!"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(file.getContentType())) 
			{
				this.typeXls = -1;
				msgs.add(new FacesMessage("El Archivo que intenta procesar no es un archivo valido de excel el tipo de archivo que intenta procesar es del tipo: "	+ file.getContentType()));
			}
		}

		if (!msgs.isEmpty()) 
		{
			throw new ValidatorException(msgs);
		}
	}

	public Part getFile() 
	{
		return file;
	}

	public void setFile(Part file) 
	{
		this.file = file;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private final String COMPILE_FILE_NAME = "report6";

	@Override
	protected String getCompileFileName() 
	{
		return COMPILE_FILE_NAME;
	}

	@Override
	protected Map<String, Object> getReportParameters() 
	{
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		String cadena = "";
		reportParameters.put("nombre", "Claro depurador de agregadores a continuacion se muestran los numeros preocesados:");
		for (int i = 0; i < exelDataList.size(); i++) 
		{
			cadena = cadena + "El numero " + exelDataList.get(i) + " fue Procesado correctamente\n";
		}
		
		reportParameters.put("numeros", cadena);

		return reportParameters;
	}

	public String execute() 
	{
		try 
		{
			super.prepareReport();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return null;
	}
}
