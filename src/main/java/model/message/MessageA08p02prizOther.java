package model.message;

import help.RandomGUID;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.io.IOException;
import java.util.ArrayList;

public class MessageA08p02prizOther extends MessageCommon{

    public MessageA08p02prizOther() {
        int person_surname = 0, person_firstname = 1, person_lastname = 2,
                person_birthday = 3, person_sex = 4, person_serdoc = 5,
                person_numdoc = 6, person_docid = 7, person_snils = 8, person_enp = 10, person_d12 = 11,
                person_d13 = 12, person_smo=13, person_typepol=14, person_numpolis = 15;
        PERSON_SURNAME = person_surname;
        PERSON_KINDFIRSTNAME = person_firstname;
        PERSON_KINDLASTNAME = person_lastname;
        PERSON_BIRTHDAY = person_birthday;
        PERSON_SEX = person_sex;
        PERSON_SERDOC = person_serdoc;
        PERSON_NUMDOC = person_numdoc;
        PERSON_DOCPERSONID = person_docid;
        SNILS = person_snils;
        ENP = person_enp;
        D_12 = person_d12;
        D_13 = person_d13;
        SMO = person_smo;
        TYPE_POL = person_typepol;
        POL = person_numpolis;
    }

    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate) {
        for (int i = 1; i < count; i++) {

            Element adt_a01 = new Element("ADT_A01", namespace);
            rootElement.addContent(adt_a01);

            RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");

            Element evn = new Element("EVN", namespace);
            adt_a01.addContent(evn);
            evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
            evn.addContent(new Element("EVN.4", namespace).addContent("Ï02"));

            createPid(namespace, i, adt_a01);

            Element pv1 = new Element("PV1", namespace);
            pv1.addContent(new Element("PV1.2", namespace).addContent("1"));
            pv1.addContent(new Element("PV1.36",namespace).addContent("7"));

            adt_a01.addContent(pv1);

            Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
            adt_a01.addContent(adt_a01insurance);

            Element in1 = new Element("IN1", namespace);
            adt_a01insurance.addContent(in1);

            in1.addContent(new Element("IN1.1", namespace).addContent("1"));

            in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("ÎÌÑ")));

//            Element in1_3 = new Element("IN1.3", namespace);
//            in1.addContent(in1_3);
//            in1_3.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(SMO)));
//            in1_3.addContent(new Element("CX.5", namespace).addContent("NII"));

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
//			System.out.println("Ýòîò ñðàíûé ãóèä ïîøåë â kist guid" + guidMsh);
            listGuid(guidMsh, i, "2");
        }
    }

    @Override
    protected void createPid(Namespace namespace, int i, Element rootEl) {
        Element pid = new Element("PID", namespace);
        rootEl.addContent(pid);

        Element pid3_1 = new Element("PID.3", namespace);
        pid.addContent(pid3_1);
        String seria = dataList.get(i).get(PERSON_SERDOC);
        pid3_1.addContent(new Element("CX.1", namespace).addContent((("".equals(seria) || seria == null) ? "" : seria + " ¹ ") + dataList.get(i).get(PERSON_NUMDOC)));
        pid3_1.addContent(new Element("CX.5", namespace).addContent(dataList.get(i).get(PERSON_DOCPERSONID)));
//        pid3_1.addContent(new Element("CX.7", namespace).addContent(dataList.get(i).get(DATEPASSPORT)));
//        pid3_1.addContent(new Element("CX.8", namespace).addContent(dataList.get(i).get(D2)));


        Element pid3_4 = new Element("PID.3", namespace);
        pid.addContent(pid3_4);
        pid3_4.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(ENP)));
        Element pid3_4cx4 = new Element("CX.4", namespace);
        pid3_4.addContent(pid3_4cx4);
        pid3_4cx4.addContent(new Element("HD.1", namespace).addContent("50000"));
        pid3_4cx4.addContent(new Element("HD.2", namespace).addContent("1.2.643.2.40.3.3.1"));
        pid3_4cx4.addContent(new Element("HD.3", namespace).addContent("ISO"));
        pid3_4.addContent(new Element("CX.5", namespace).addContent("NI"));

        Element pid5 = new Element("PID.5", namespace);
        pid.addContent(pid5);
        pid5.addContent(new Element("XPN.1", namespace)
                .addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
        pid5.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));

        if (dataList.get(i).get(PERSON_KINDLASTNAME).equals("-") || dataList.get(i).get(PERSON_KINDLASTNAME).equals("ÍÅÒ"))
        {
            pid5.addContent(new Element("XPN.3", namespace).addContent(""));
        }
        else
        {
            pid5.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));
        }

        pid.addContent(new Element("PID.7", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));

        pid.addContent(new Element("PID.8", namespace).addContent(dataList.get(i).get(PERSON_SEX)));


        Element pid26 = new Element("PID.26", namespace);
        String rus = "RUS";
        pid.addContent(pid26);
        pid26.addContent(new Element("CWE.1", namespace).addContent(rus));
        pid26.addContent(new Element("CWE.3", namespace).addContent("1.2.643.2.40.5.0.25.3"));

    }

    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate, boolean tt) {
        System.out.println("createMiddle a08p02prizOther:" + dataList);
        for (int i = 0; i < count; i++) {

            Element adt_a01 = new Element("ADT_A01", namespace);
            rootElement.addContent(adt_a01);

            RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");

            Element evn = new Element("EVN", namespace);
            adt_a01.addContent(evn);
            evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
            evn.addContent(new Element("EVN.4", namespace).addContent("Ï02"));

            createPid(namespace, i, adt_a01);

            Element pv1 = new Element("PV1", namespace);
            pv1.addContent(new Element("PV1.2", namespace).addContent("1"));
            pv1.addContent(new Element("PV1.36",namespace).addContent("7"));

            adt_a01.addContent(pv1);

            Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
            adt_a01.addContent(adt_a01insurance);

            Element in1 = new Element("IN1", namespace);
            adt_a01insurance.addContent(in1);

            in1.addContent(new Element("IN1.1", namespace).addContent("1"));

            in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("ÎÌÑ")));

            Element in1_3 = new Element("IN1.3", namespace);
            in1.addContent(in1_3);
            in1_3.addContent(new Element("CX.1", namespace).addContent(dataList.get(i).get(SMO)));
            in1_3.addContent(new Element("CX.5", namespace).addContent("NII"));

            in1.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12)));

            in1.addContent(new Element("IN1.13", namespace).addContent(dataList.get(i).get(D_13)));

            in1.addContent(new Element("IN1.15", namespace).addContent("50000"));

            Element in1_16 = new Element("IN1.16", namespace);
            in1_16.addContent(new Element("XPN.1", namespace).addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
            in1_16.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));


            in1_16.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));

            in1.addContent(new Element("IN1.18", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));

            in1.addContent(new Element("IN1.35", namespace).addContent(dataList.get(i).get(TYPE_POL)));

            in1.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(POL)));

            in1.addContent(new Element("IN1.52", namespace).addContent(dataList.get(i).get(BORN)));
        }
    }

    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate, boolean tt, String kluch) {
        int person_surname = 0, person_firstname = 1, person_lastname = 2, person_birthday = 3, person_sex = 4, person_serdoc = 5, person_numdoc = 6, person_docid = 7, person_snils = 8;
        PERSON_SURNAME = person_surname;
        PERSON_KINDFIRSTNAME = person_firstname;
        PERSON_KINDLASTNAME = person_lastname;
        PERSON_BIRTHDAY = person_birthday;
        PERSON_SEX = person_sex;
        PERSON_SERDOC = person_serdoc;
        PERSON_NUMDOC = person_numdoc;
        PERSON_DOCPERSONID = person_docid;
        SNILS = person_snils;

        for (int i = 1; i < count; i++) {

            Element adt_a01 = new Element("ADT_A01", namespace);
            rootElement.addContent(adt_a01);

            RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");

            Element evn = new Element("EVN", namespace);
            adt_a01.addContent(evn);
            evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
            evn.addContent(new Element("EVN.4", namespace).addContent("Ï02"));

            createPid(namespace, i, adt_a01);

            Element pv1 = new Element("PV1", namespace);
            pv1.addContent(new Element("PV1.2", namespace).addContent("1"));
            pv1.addContent(new Element("PV1.36",namespace).addContent("7"));

            adt_a01.addContent(pv1);

            Element adt_a01insurance = new Element("ADT_A01.INSURANCE", namespace);
            adt_a01.addContent(adt_a01insurance);

            Element in1 = new Element("IN1", namespace);
            adt_a01insurance.addContent(in1);

            in1.addContent(new Element("IN1.1", namespace).addContent("1"));

            in1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("ÎÌÑ")));

            Element in1_16 = new Element("IN1.16", namespace);
            in1_16.addContent(new Element("XPN.1", namespace).addContent(new Element("FN.1", namespace).addContent(dataList.get(i).get(PERSON_SURNAME))));
            in1_16.addContent(new Element("XPN.2", namespace).addContent(dataList.get(i).get(PERSON_KINDFIRSTNAME)));


            in1_16.addContent(new Element("XPN.3", namespace).addContent(dataList.get(i).get(PERSON_KINDLASTNAME)));

            in1.addContent(new Element("IN1.18", namespace).addContent(dataList.get(i).get(PERSON_BIRTHDAY)));

            listGuid(guidMsh, i, "2");
        }
    }

    @Override
    protected void createMiddle(Namespace namespace, Element rootElement, String curDate) {

    }
}
