package servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
  
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import dao.impl.QueryAkaExcelfromPool;

  
@WebServlet("/GenEnp")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100)      // 100 MB

public class GenEnp extends HttpServlet {
  
    private static final long serialVersionUID = 205242440643911308L;
     
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "uploads";
      
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
		//String applicationPath = getServletContext().getRealPath("");

        System.out.println(applicationPath);
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println(uploadFilePath);
          
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
         
        String fileName ="";
        String absolutePath = null;

        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts())
        {
		            fileName = getFileName(part);
		            
		            if(!fileName.equals(""))
		            {
				            /*
				             * 
				             * ����� ���� ������������ ��� ����� ��� ������
				             * 
				             */
				            try
				            {
				            part.write(uploadFilePath + File.separator + fileName);
				            }
				            catch(Throwable e)
				            {
				            	System.out.println("�������� ������ �������������� ����!!! ������ � ���� �� ����������� "+fileName);
				           
				            	fileName = fileName.substring(fileName.indexOf("=")+2, fileName.length());
				            	
				            	System.out.println("���������� �� : "+fileName);
				            	
				            	part.write(uploadFilePath + File.separator + fileName);
				            }
				            // ��������� ���� ����!!
				            absolutePath = uploadFilePath + File.separator + fileName;
				            System.out.println("�������� !!"+absolutePath);
				            /*
				             * ������ ������ -�������� � ��������� - ������� ������ - �����������
				             */
				        
				            List<ArrayList<String>> resaltQuery = null;
									try {
										resaltQuery =  paseInputStreamExcelForQuery(absolutePath);
									} catch (Exception e) {
										e.printStackTrace();
									}
								
							
				            
				            loadToExcelResalt(resaltQuery,absolutePath);
				            downloadExcel(response,absolutePath);
		            }
		            else
		            {
		            	
		            }
				            
		          
		        
		        
				
        }
            
       String ss = fileSaveDir.getAbsolutePath() + File.separator;
       System.out.println("����1 "+ss);
        
  
       request.getSession().setAttribute("message", fileName + " File uploaded successfully!");
       request.getSession().setAttribute("absolutePath",absolutePath);
       getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
    }
  
    private void loadToExcelResalt( List<ArrayList<String>> resaltQuery, String absolutePath) throws FileNotFoundException, IOException
    {
    	POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(absolutePath));
		HSSFWorkbook wb = new HSSFWorkbook(fs);	
		HSSFSheet sheet = wb.getSheetAt(1);	
		
		HSSFRow excelRow = null;
		HSSFCell excelCell = null;
		
		// ���������� ���������� ����� � ����� ���������
		int rows = resaltQuery.size();
		
		for(int i = 0; i < rows ; i++)
		{
			excelRow = sheet.createRow(i);
			excelRow = sheet.getRow(i);			
			excelCell = excelRow.createCell(0);
			excelCell = excelRow.getCell(0);
			excelCell.setCellValue(resaltQuery.get(i).get(0));
		}	
	
		wb.setSheetName(0, "�������� ������");
		wb.setSheetName(1, "���������");
		
		FileOutputStream fileOut = new FileOutputStream(absolutePath);
		wb.write(fileOut);
		fileOut.close();
    }
    
    /*
     * ����� ������ ����������� ������, ������� ������ � ���������� ��������� � 
     * ������� ������� � ��� �� ������� Person
     */
    private List<ArrayList<String>> paseInputStreamExcelForQuery(String absolutePath) throws Exception
    {
    	/*
    	 *  ��������� � ��� ��������� ������ �� ������������� ������
    	 */
    	List<ArrayList<String>>  listRow = new ArrayList<ArrayList<String>>();
    	POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(absolutePath));
		HSSFWorkbook wb = new HSSFWorkbook(fs);	
		
		HSSFSheet sheet = wb.getSheetAt(0);		
		int rowsIn = sheet.getPhysicalNumberOfRows();
		System.out.println("���������� �������� ����� "+ rowsIn);
		/*
		 * ��������� �� ����� ������ � ��������� �������� 
		 * (����� ������ - �������)
		 * 
		 */
		
		Iterator<Row> rows = sheet.rowIterator();
		/*
		 * ����� �� �������
		 */
		while (rows.hasNext())
		{
		    HSSFRow row = (HSSFRow) rows.next();

		    Iterator<Cell> cells = row.cellIterator();
		    
		    /*
		     * ����� �� ��������
		     */
		    ArrayList<String> listCell = new ArrayList<String>();
		    while (cells.hasNext())
		    {
		    	 HSSFCell cell = (HSSFCell) cells.next();
		    
			    	
			    	 switch (cell.getCellType()) 
			    	 {
			            case HSSFCell.CELL_TYPE_STRING:
			            	//for debug
			               // System.out.println(cell.getStringCellValue());
			                listCell.add(cell.getStringCellValue());
			            break;
			            default: break;
			        }
			        
		    }
		    // ��������� ������������ ������ �� ��������
		    listRow.add(listCell);
		    
		    
		    
		}
		// ������� ����� ������� ������������ � ������
		System.out.println("text "+listRow);
		String text = textQuery(listRow);
		// ������� ����������� � ������ 
		//System.out.println("text "+text);
		//Thread.sleep(10000000);
		List<ArrayList<String>> listRowWithEnpPerson = new QueryAkaExcelfromPool().queryGenENP(text);
				
		FileOutputStream fileOut = new FileOutputStream(absolutePath);
		wb.write(fileOut);
		fileOut.close();
		
		return listRowWithEnpPerson;
    }
    
    
    /**
     * Utility method to get file name from HTTP header content-disposition
     * 
     */
    private String getFileName(Part part) throws UnsupportedEncodingException {
        String contentDisp = part.getHeader("content-disposition");
      //  System.out.println("���������� ��������� ��� jetty "+part.getHeader("content-disposition").format("UTF-8",part.getHeader("content-disposition") ));
        
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) 
        {
        	/*
        	 * 
        	 * ��������� �� ��������� ������� � �������� ������� �����
        	 * 
        	 * 
        	 */
        	int count = 0;
            if (token.trim().startsWith("filename")) 
            {
            	String [] mas = token.split("");
            	
            	for(int i=0;i<mas.length;i++)
            	{
            		if(mas[i].equals("\\"))
            		{
            			count = i;
            		}
            	}
            	
            	if(count == 0)
            	{
            		System.out.println("!!!!!!!!1 "+ token.substring(token.indexOf("=")+2,token.length()-1));
	                return token.substring(token.indexOf("=")+2,token.length()-1);
            	}
            	else
            	{
	            	System.out.println("!!!!!!!!2 "+ token.substring(count,token.length()-1));
	                return token.substring(count,token.length()-1);
            	}
            }
        }
        return "";
    }
   /*
    * ��������� ����� ������� 
    */
    private String textQuery(List<ArrayList<String>> listRow)
    {
    	/*
    	 * query = session.createSQLQuery("update personadd pa set pa.enp = (select  enp.calc_kr('54'|| enp.calc_mmggggdd(persoN_birthday,person_sex + 1) || (enp.calc_nnnnn(person_birthday,person_sex + 1))) from person pp where pp.person_addressid = pa.personadd_addressid) where pa.personadd_addressid in (select p.person_addressid from person p where p.enp = :enp)");
    	 */
    	
    	
    	StringBuilder sqlStr = new StringBuilder();
    	sqlStr.append("");
    	
    	for(int i=0;i<listRow.size();i++)
		{
    		
			ArrayList<String> list = listRow.get(i);
			sqlStr.append("select  enp.calc_kr('54'|| enp.calc_mmggggdd(pp.person_birthday,pp.person_sex + 1) || (enp.calc_nnnnn(pp.person_birthday,pp.person_sex + 1)) ) from person pp where pp.enp ='").append(list.get(0)).append("' union ");
		}
    	String query = sqlStr.toString();
       query=query.substring(0, query.length()-6);
    			//for debug
    			System.out.println("Test "+ query );
    			return query ;
    }
    
    
    /*
     * ��������� ���� � ������� � �������
     * 
     */
    
    private void downloadExcel(HttpServletResponse response, String absolutePath) throws ServletException, IOException
    {
		System.out.println("pach....."+absolutePath);
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try {
			stream = response.getOutputStream();
			File doc = new File(absolutePath);
			response.setCharacterEncoding("application/msexcel");
			response.addHeader("Content-Disposition", "attachment; filename=" + absolutePath);
			response.setContentLength((int)doc.length());
			FileInputStream input = new FileInputStream(doc);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			while((readBytes = buf.read()) != -1) { stream.write(readBytes); }
		} catch (IOException ioe) {
			throw new ServletException(ioe.getMessage());
		} finally {
			if(stream != null) { stream.close(); }
			if(buf != null) { buf.close(); }
			
			File file =new File(absolutePath);
			System.out.println(file.delete());
		}
    }
}
