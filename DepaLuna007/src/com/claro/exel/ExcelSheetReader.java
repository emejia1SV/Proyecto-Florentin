package com.claro.exel;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader  {

	/**
	 * Este metodo es usado para leer el contenido de un archivo de excel.
	 * 
	 * @param fileName
	 *            - Nombre del archivo de excel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List readExcelFile(FileInputStream fileInputStream) {
		
		 // Creando una nueva instancia para cellDataList.
		List cellDataList = new ArrayList();
		try {
			/**
			 * Creando una nueva instancia para la clase FileInputStream.
			 */
			// FileInputStream fileInputStream = new FileInputStream(fileName);
			
			 //Creando una nueva instancia para la clase POIFSFileSystem.
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			/*
			 * Creando una nueva instancia para la clase HSSFWorkBook.
			 */
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			HSSFSheet hssfSheet = workBook.getSheetAt(0);
			/**
			 * Iterando las filas y celdas de la hoja de calculo para obtener
			 * todos los datos.
			 */
			Iterator rowIterator = hssfSheet.rowIterator();
			while (rowIterator.hasNext()) {
				HSSFRow hssfRow = (HSSFRow) rowIterator.next();
				Iterator iterator = hssfRow.cellIterator();
				//List cellTempList = new ArrayList();
				while (iterator.hasNext()) {
					HSSFCell hssfCell = (HSSFCell) iterator.next();
					//cellTempList.add(hssfCell);
					double doubleCellValue = hssfCell.getNumericCellValue();
					DecimalFormat dFormat = new DecimalFormat("###########");
					String stringCellValue = dFormat.format(doubleCellValue);
					//System.out.print(stringCellValue + "\t");
					cellDataList.add(stringCellValue);
				}
				
				//cellDataList.add(cellTempList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cellDataList;
	}


		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public List readExcelxFile(FileInputStream fileInputStream) {
		List cellDataList = new ArrayList();
		try {
			// Creando la instancia Workbook haciendo referencia al archivo
			// .xlsx que fue cargado desde la web
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			// obteniendo la primer hoja del workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterando cada una de las filas una por una
			Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet
					.iterator();
			while (rowIterator.hasNext()) {
				//System.out.print("Dentro del Primer While"+"\t");
				Row row = (Row) rowIterator.next();
				// Por cada fila, Recorremos cada columna
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					//System.out.print("Dentro del Segundo While"+"\t");
					Cell cell = cellIterator.next();
					// Agregamos la celda a la lista temporal
					//cellTempList.add(cell);
					//cellDataList.add(cellTempList);
					double doubleCellValue = cell.getNumericCellValue();
					DecimalFormat dFormat = new DecimalFormat("###########");
					String stringCellValue = dFormat.format(doubleCellValue);
					//System.out.print(stringCellValue + "\t");
					cellDataList.add(stringCellValue);

				}
				// agregando la lista temporal a la lista completa
				//cellDataList.add(cellTempList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cellDataList;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}
