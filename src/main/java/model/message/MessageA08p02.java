package model.message;

import java.text.SimpleDateFormat;
import java.util.Date;

import help.RandomGUID;

import org.jdom2.Element;
import org.jdom2.Namespace;

public class MessageA08p02 extends MessageCommon{
	public MessageA08p02(){}

	public MessageA08p02(int PERSON_SERDOC, int PERSON_NUMDOC, int PERSON_DOCPERSONID, int PERSON_SURNAME, int PERSON_KINDFIRSTNAME, int PERSON_KINDLASTNAME, int PERSON_BIRTHDAY, int PERSON_SEX, int PERSON_LINKSMOESTABLISHMENTID, int ENP, int PERSON_ADDRESSID, int PERSON_DATEINPUT, int SNILS, int BORN, int DATEPASSPORT, int ENP_PA, int VS_NUM, int VS_DATE, int ZAD, int d2, int SMO, int d_12, int d_13, int OKATO_3, int TYPE_POL, int POL, int ENP_1, int ENP_2, int p14CX1, int p14CX5, int p14CX6, int p14CX7, int XPN1, int XPN2, int XPN3, int USERNAME, int ZADMINUS1, int ZADPLUS40, int NBLANC, int VS_DATEPLUS1, int USER_ENP, int USER_PERSON_SURNAME, int USER_PERSON_KINDFIRSTNAME, int USER_PERSON_KINDLASTNAME, int USER_SMO, int USER_D_12, int USER_D_13, int USER_OKATO_3, int USER_TYPE_POL, int USER_POL, int RUSSIAN, int d_V, int d_SER, int d_NUM, int PR_FAM, int PR_IM, int PR_OT, int LAST_FAM, int LAST_IM, int LAST_OT, int LAST_DR, int PFR_SNILS, int PFR_ID, int PFR_NOTID, int USER_SERDOC, int USER_NUMDOC, int USER_DOCID, int USER_DOC_DATE, int d_12_PLUS1, int KATEG, int pid29, int d1) {
		super(PERSON_SERDOC, PERSON_NUMDOC, PERSON_DOCPERSONID, PERSON_SURNAME, PERSON_KINDFIRSTNAME, PERSON_KINDLASTNAME, PERSON_BIRTHDAY, PERSON_SEX, PERSON_LINKSMOESTABLISHMENTID, ENP, PERSON_ADDRESSID, PERSON_DATEINPUT, SNILS, BORN, DATEPASSPORT, ENP_PA, VS_NUM, VS_DATE, ZAD, d2, SMO, d_12, d_13, OKATO_3, TYPE_POL, POL, ENP_1, ENP_2, p14CX1, p14CX5, p14CX6, p14CX7, XPN1, XPN2, XPN3, USERNAME, ZADMINUS1, ZADPLUS40, NBLANC, VS_DATEPLUS1, USER_ENP, USER_PERSON_SURNAME, USER_PERSON_KINDFIRSTNAME, USER_PERSON_KINDLASTNAME, USER_SMO, USER_D_12, USER_D_13, USER_OKATO_3, USER_TYPE_POL, USER_POL, RUSSIAN, d_V, d_SER, d_NUM, PR_FAM, PR_IM, PR_OT, LAST_FAM, LAST_IM, LAST_OT, LAST_DR, PFR_SNILS, PFR_ID, PFR_NOTID, USER_SERDOC, USER_NUMDOC, USER_DOCID, USER_DOC_DATE, d_12_PLUS1, KATEG, pid29, d1);
	}

	public MessageA08p02(int pERSON_SERDOC, int pERSON_NUMDOC,
						 int pERSON_DOCPERSONID, int pERSON_SURNAME,
						 int pERSON_KINDFIRSTNAME, int pERSON_KINDLASTNAME,
						 int pERSON_BIRTHDAY, int pERSON_SEX,
						 int pERSON_LINKSMOESTABLISHMENTID, int eNP, int pERSON_ADDRESSID,
						 int pERSON_DATEINPUT, int sNILS, int bORN, int dATEPASSPORT,
						 int eNP_PA, int vS_NUM, int vS_DATE, int zAD, int d2, int sMO,
						 int d_12, int d_13, int oKATO_3, int tYPE_POL, int pOL, int eNP_1,
						 int eNP_2, int p14cx1, int p14cx5, int p14cx6, int p14cx7,
						 int xPN1, int xPN2, int xPN3, int uSERNAME, int zADMINUS1,
						 int zADPLUS40, int nBLANC, int vS_DATEPLUS1, int uSER_ENP,
						 int uSER_PERSON_SURNAME, int uSER_PERSON_KINDFIRSTNAME,
						 int uSER_PERSON_KINDLASTNAME, int uSER_SMO, int uSER_D_12,
						 int uSER_D_13, int uSER_OKATO_3, int uSER_TYPE_POL, int uSER_POL,
						 int rUSSIAN, int d_V, int d_SER, int d_NUM, int pR_FAM, int pR_IM,
						 int pR_OT, int lAST_FAM, int lAST_IM, int lAST_OT, int lAST_DR,
						 int pFR_SNILS, int pFR_ID, int pFR_NOTID, int uSER_SERDOC,
						 int uSER_NUMDOC, int uSER_DOCID, int uSER_DOC_DATE, int d_12_PLUS1, int pid29) {
		
		super(pERSON_SERDOC, pERSON_NUMDOC, pERSON_DOCPERSONID, pERSON_SURNAME,
				pERSON_KINDFIRSTNAME, pERSON_KINDLASTNAME, pERSON_BIRTHDAY, pERSON_SEX,
				pERSON_LINKSMOESTABLISHMENTID, eNP, pERSON_ADDRESSID, pERSON_DATEINPUT,
				sNILS, bORN, dATEPASSPORT, eNP_PA, vS_NUM, vS_DATE, zAD, d2, sMO, d_12,
				d_13, oKATO_3, tYPE_POL, pOL, eNP_1, eNP_2, p14cx1, p14cx5, p14cx6,
				p14cx7, xPN1, xPN2, xPN3, uSERNAME, zADMINUS1, zADPLUS40, nBLANC,
				vS_DATEPLUS1, uSER_ENP, uSER_PERSON_SURNAME, uSER_PERSON_KINDFIRSTNAME,
				uSER_PERSON_KINDLASTNAME, uSER_SMO, uSER_D_12, uSER_D_13, uSER_OKATO_3,
				uSER_TYPE_POL, uSER_POL, rUSSIAN, d_V, d_SER, d_NUM, pR_FAM, pR_IM,
				pR_OT, lAST_FAM, lAST_IM, lAST_OT, lAST_DR, pFR_SNILS, pFR_ID,
				pFR_NOTID, uSER_SERDOC, uSER_NUMDOC, uSER_DOCID, uSER_DOC_DATE,
				d_12_PLUS1,pid29);
		// TODO Auto-generated constructor stub
	}
	public MessageA08p02(int pERSON_SERDOC, int pERSON_NUMDOC,
						 int pERSON_DOCPERSONID, int pERSON_SURNAME,
						 int pERSON_KINDFIRSTNAME, int pERSON_KINDLASTNAME,
						 int pERSON_BIRTHDAY, int pERSON_SEX,
						 int pERSON_LINKSMOESTABLISHMENTID, int eNP, int pERSON_ADDRESSID,
						 int pERSON_DATEINPUT, int sNILS, int bORN, int dATEPASSPORT,
						 int eNP_PA, int vS_NUM, int vS_DATE, int zAD, int d2, int sMO,
						 int d_12, int d_13, int oKATO_3, int tYPE_POL, int pOL, int eNP_1,
						 int eNP_2, int p14cx1, int p14cx5, int p14cx6, int p14cx7,
						 int xPN1, int xPN2, int xPN3, int uSERNAME, int zADMINUS1,
						 int zADPLUS40, int nBLANC, int vS_DATEPLUS1, int uSER_ENP,
						 int uSER_PERSON_SURNAME, int uSER_PERSON_KINDFIRSTNAME,
						 int uSER_PERSON_KINDLASTNAME, int uSER_SMO, int uSER_D_12,
						 int uSER_D_13, int uSER_OKATO_3, int uSER_TYPE_POL, int uSER_POL,
						 int rUSSIAN, int d_V, int d_SER, int d_NUM, int pR_FAM, int pR_IM,
						 int pR_OT, int lAST_FAM, int lAST_IM, int lAST_OT, int lAST_DR,
						 int pFR_SNILS, int pFR_ID, int pFR_NOTID, int uSER_SERDOC,
						 int uSER_NUMDOC, int uSER_DOCID, int uSER_DOC_DATE, int d_12_PLUS1, int pid29,int d1) {

		super(pERSON_SERDOC, pERSON_NUMDOC, pERSON_DOCPERSONID, pERSON_SURNAME,
				pERSON_KINDFIRSTNAME, pERSON_KINDLASTNAME, pERSON_BIRTHDAY, pERSON_SEX,
				pERSON_LINKSMOESTABLISHMENTID, eNP, pERSON_ADDRESSID, pERSON_DATEINPUT,
				sNILS, bORN, dATEPASSPORT, eNP_PA, vS_NUM, vS_DATE, zAD, d2, sMO, d_12,
				d_13, oKATO_3, tYPE_POL, pOL, eNP_1, eNP_2, p14cx1, p14cx5, p14cx6,
				p14cx7, xPN1, xPN2, xPN3, uSERNAME, zADMINUS1, zADPLUS40, nBLANC,
				vS_DATEPLUS1, uSER_ENP, uSER_PERSON_SURNAME, uSER_PERSON_KINDFIRSTNAME,
				uSER_PERSON_KINDLASTNAME, uSER_SMO, uSER_D_12, uSER_D_13, uSER_OKATO_3,
				uSER_TYPE_POL, uSER_POL, rUSSIAN, d_V, d_SER, d_NUM, pR_FAM, pR_IM,
				pR_OT, lAST_FAM, lAST_IM, lAST_OT, lAST_DR, pFR_SNILS, pFR_ID,
				pFR_NOTID, uSER_SERDOC, uSER_NUMDOC, uSER_DOCID, uSER_DOC_DATE,
				d_12_PLUS1,pid29, d1);
		// TODO Auto-generated constructor stub
	}

	protected void createMiddle(int count, Namespace namespace,
			Element rootElement, String curDate) {
		for (int i = 1; i < count; i++) {
			
			Element adt_a01 = new Element("ADT_A01", namespace);
			rootElement.addContent(adt_a01);
			
			RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");	
			
			Element evn = new Element("EVN", namespace);
			adt_a01.addContent(evn);
			evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
			evn.addContent(new Element("EVN.4", namespace).addContent("�02"));
					
			createPid(namespace, i, adt_a01);

			Element pv1 = new Element("PV1", namespace);
			pv1.addContent(new Element("PV1.2", namespace).addContent("1"));

			adt_a01.addContent(pv1);
				
			Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
			adt_a01.addContent(adt_a01insurance);
			
			Element in1 = new Element("IN1", namespace);
			adt_a01insurance.addContent(in1);
				
			in1.addContent(new Element("IN1.1", namespace).addContent("1"));
	
			in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("���")));
						
			Element in1_3 = new Element("IN1.3", namespace);
			in1.addContent(in1_3);
			in1_3.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(SMO)));
			in1_3.addContent(new Element("CX.5", namespace).addContent("NII"));
	
			in1.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12)));
	
			in1.addContent(new Element("IN1.13", namespace).addContent(dataList.get(i).get(PERSON_DATEINPUT)));
	
			in1.addContent(new Element("IN1.15", namespace).addContent(dataList.get(i).get(OKATO_3)));
		
			Element in1_16 = new Element("IN1.16", namespace);
			in1_16.addContent(new Element("XPN.1", namespace).addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
			in1_16.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));
			
			
			in1_16.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));
	
			in1.addContent(new Element("IN1.18", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));
			
			in1.addContent(new Element("IN1.35", namespace).addContent(dataList.get(i).get(TYPE_POL)));
			
			in1.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(POL)));
	
			in1.addContent(new Element("IN1.52", namespace).addContent(dataList.get(i).get(BORN)));
//			System.out.println("���� ������ ���� ����� � kist guid" + guidMsh);
			listGuid(guidMsh, i, "2");
		}
		
		
	}

	protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate,boolean tt) {
		for (int i = 0; i < count; i++) {
			
			Element adt_a01 = new Element("ADT_A01", namespace);
			rootElement.addContent(adt_a01);
			
			RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");	
			
			Element evn = new Element("EVN", namespace);
			adt_a01.addContent(evn);
			evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
			evn.addContent(new Element("EVN.4", namespace).addContent("�02"));
					
			createPid(namespace, i, adt_a01);
	
			adt_a01.addContent(new Element("PV1", namespace).addContent(new Element("PV1.2", namespace).addContent("1")));
				
			Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
			adt_a01.addContent(adt_a01insurance);
			
			Element in1 = new Element("IN1", namespace);
			adt_a01insurance.addContent(in1);
				
			in1.addContent(new Element("IN1.1", namespace).addContent("1"));
	
			in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("���")));
						
			Element in1_3 = new Element("IN1.3", namespace);
			in1.addContent(in1_3);
			in1_3.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(SMO)));
			in1_3.addContent(new Element("CX.5", namespace).addContent("NII"));
	
			in1.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12)));
	
			in1.addContent(new Element("IN1.13", namespace).addContent(dataList.get(i).get(PERSON_DATEINPUT)));
	
			in1.addContent(new Element("IN1.15", namespace).addContent(dataList.get(i).get(OKATO_3)));
		
			Element in1_16 = new Element("IN1.16", namespace);
			in1_16.addContent(new Element("XPN.1", namespace).addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
			in1_16.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));
			in1_16.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));
	
			in1.addContent(new Element("IN1.18", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));
			
			in1.addContent(new Element("IN1.35", namespace).addContent(dataList.get(i).get(TYPE_POL)));
			
			in1.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(POL)));
	
			in1.addContent(new Element("IN1.52", namespace).addContent(dataList.get(i).get(BORN)));
			System.out.println("���� ������ ���� ����� � kist guid" + guidMsh);
			listGuid(guidMsh, i, "2");
		}
		
		
	}


	@Override
	protected void createMiddle(int count, Namespace namespace,
			Element rootElement, String curDate, boolean tt, String kluch) {
		for (int i = 1; i < count; i++) {

			Element adt_a01 = new Element("ADT_A01", namespace);
			rootElement.addContent(adt_a01);

			RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");

			Element evn = new Element("EVN", namespace);
			adt_a01.addContent(evn);
			evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
			evn.addContent(new Element("EVN.4", namespace).addContent("�02"));

			createPid(namespace, i, adt_a01);

			Element pv1 = new Element("PV1", namespace);
			pv1.addContent(new Element("PV1.2", namespace).addContent("1"));
			String rus =  dataList.get(i).get(RUSSIAN);
			if(!rus.equals("RUS")){
				pv1.addContent(new Element("PV1.36",namespace).addContent("7"));
			}else if(kluch.equals("prizyv")){
                pv1.addContent(new Element("PV1.36",namespace).addContent("7"));
            }



			adt_a01.addContent(pv1);

			Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
			adt_a01.addContent(adt_a01insurance);

			Element in1 = new Element("IN1", namespace);
			adt_a01insurance.addContent(in1);

			in1.addContent(new Element("IN1.1", namespace).addContent("1"));

			in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("���")));

			Element in1_3 = new Element("IN1.3", namespace);
			in1.addContent(in1_3);
			in1_3.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(SMO)));
			in1_3.addContent(new Element("CX.5", namespace).addContent("NII"));

			in1.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12)));

			in1.addContent(new Element("IN1.13", namespace).addContent(dataList.get(i).get(PERSON_DATEINPUT)));

			in1.addContent(new Element("IN1.15", namespace).addContent(dataList.get(i).get(OKATO_3)));

			Element in1_16 = new Element("IN1.16", namespace);
			in1_16.addContent(new Element("XPN.1", namespace).addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
			in1_16.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));


			in1_16.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));

			in1.addContent(new Element("IN1.18", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));

			in1.addContent(new Element("IN1.35", namespace).addContent(dataList.get(i).get(TYPE_POL)));

			in1.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(POL)));

			in1.addContent(new Element("IN1.52", namespace).addContent(dataList.get(i).get(BORN)));
//			System.out.println("���� ������ ���� ����� � kist guid" + guidMsh);
			listGuid(guidMsh, i, "2");
		}
		
	}


	@Override
	protected void createMiddle(Namespace namespace, Element rootElement, String curDate) {
		// TODO Auto-generated method stub
		
	}
}
