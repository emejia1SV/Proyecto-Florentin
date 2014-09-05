package com.claro.beans;

import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.axis2.AxisFault;

import sv.avantia.depurador.agregadores.ws.WsDepuradorAgregadoresStub;
import sv.avantia.depurador.agregadores.ws.WsDepuradorAgregadoresStub.BajarServicios;
import sv.avantia.depurador.agregadores.ws.WsDepuradorAgregadoresStub.BajarServiciosResponse;
import sv.avantia.depurador.agregadores.ws.WsDepuradorAgregadoresStub.Numeros;

import java.util.HashMap;
import java.util.Map;

import com.claro.report.common.AbstractReportBean;

@RequestScoped
@ManagedBean(name = "jSFManagedBean")
public class jSFManagedBeanForlimpiarAgregadores extends AbstractReportBean {

	public String Select1() {
		return "Select1";
	}

	public Integer LimpiarServicios() throws AxisFault {
		Integer respuesta = 50;
		try {
			WsDepuradorAgregadoresStub stub = new WsDepuradorAgregadoresStub();
			Numeros objnumeros = new Numeros();
			objnumeros.setUsuario("Florentin");
			objnumeros.setPassword("Password");
			String arr[] = new String[1];
			arr[0] = numero;
			objnumeros.setNumeros(arr);
			BajarServicios bajarServicios0 = new BajarServicios();
			bajarServicios0.setNumeros(objnumeros);
			BajarServiciosResponse out = stub.bajarServicios(bajarServicios0);
			respuesta = out.get_return();
			System.out.println("Aplicando Quitarservicios al: " + numero);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	private String numero = "";

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////

	private final String COMPILE_FILE_NAME = "report6";

	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}

	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		reportParameters
				.put("nombre",
						"Claro depurador de agregadores a continuacion se muestran los numeros preocesados:");
		reportParameters.put("numeros", "El numero " + numero
				+ " fue Procesado Correctamente");
		return reportParameters;
	}

	public String execute() {
		try {
			Integer respuesta = LimpiarServicios();
			if (respuesta != 0) {
				System.out
						.println("La Transaccion a devuelto el codigo de error"
								+ respuesta);

			} else {
				System.out
						.println("La Transaccion se completo exitosamente con el codigo de retorno: "
								+ respuesta);
				super.prepareReport();
			}

		} catch (Exception e) {
			// make your own exception handling
			e.printStackTrace();
		}
		return null;
	}
}
