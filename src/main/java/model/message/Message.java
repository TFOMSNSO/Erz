package model.message;

import java.io.IOException;
import java.util.ArrayList;

import help.RandomGUID;

public interface Message{
	
	public boolean create(String userMachine) throws IOException;
	
	public boolean create(String userMachine,ArrayList<ArrayList<String>> listList1, String kluch) throws IOException;
	
	public boolean create(String userMachine,String stList) throws IOException;
	
	public boolean create(String userMachine,String stList,int kluch) throws IOException;
		
	public boolean prepareData(String userMachine);

	public boolean prepareData(String userMachine,ArrayList<ArrayList<String>> listList1);

	RandomGUID getGuidBhs();

	ArrayList<ArrayList<String>> getDataList();

	boolean rememberGuid();

	ArrayList<ArrayList<String>> getDataList(String userMachine);

	boolean writeToArchive();


	default void setPERSON_SERDOC(int i){
		throw new UnsupportedOperationException("operation not implemented");
	}

	default void setPERSON_NUMDOC(int i){
		throw new UnsupportedOperationException("operation not implemented");
	}

	default void setSNILS(int i){
		throw new UnsupportedOperationException("operation nit implemented");
	}

	default void setEnp(int i){
		throw new UnsupportedOperationException("operation not implemented");
	}

	default boolean createPrizyv(String userMachine) {
		return false;
	}
}
