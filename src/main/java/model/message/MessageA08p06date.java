package model.message;

import help.RandomGUID;
import org.jdom2.Element;
import org.jdom2.Namespace;

public class MessageA08p06date extends MessageCommon {
    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate) {
        for (int i = 1; i < count; i++) {
            for(int j = 0; j < dataList.get(i).size(); j++){
                System.out.print("[" + j + ":" + dataList.get(i).get(j) + "] ");
            }
            System.out.println();
            Element adt_a01 = new Element("ADT_A01", namespace);
            rootElement.addContent(adt_a01);

            RandomGUID guidMsh = createMsh(namespace, curDate, adt_a01, "ADT", "A08", "ADT_A01");

            Element evn = new Element("EVN", namespace);
            adt_a01.addContent(evn);
            evn.addContent(new Element("EVN.2", namespace).addContent(curDate));
            evn.addContent(new Element("EVN.4", namespace).addContent("Ï06"));

            createPid(namespace, i, adt_a01);

            adt_a01.addContent(new Element("PV1", namespace).addContent(new Element("PV1.2", namespace).addContent("1")));

            //IN1-1
            Element adt_a01_1insurance = new Element("ADT_A01.INSURANCE", namespace);
            adt_a01.addContent(adt_a01_1insurance);

            Element in1_1 = new Element("IN1", namespace);
            adt_a01_1insurance.addContent(in1_1);

            in1_1.addContent(new Element("IN1.1", namespace).addContent("1"));

            in1_1.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("ÎÌÑ")));

            Element in1_1_3 = new Element("IN1.3", namespace);
            in1_1.addContent(in1_1_3);
            String smo;


            switch (dataList.get(i).get(PERSON_LINKSMOESTABLISHMENTID)) {
                case "1" : smo = "1025403200151";
                    break;
                case "2" : smo = "1177746612581";
                    break;
                case "3" : smo = "1024201390740";
                    break;
                case "4" : smo = "1045207042528";
                    break;
                default : smo = "0";
                    break;
            }
            in1_1_3.addContent(new Element("CX.1", namespace).addContent(smo));
            in1_1_3.addContent(new Element("CX.5", namespace).addContent("NII"));


            in1_1.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12)));

            in1_1.addContent(new Element("IN1.13", namespace).addContent(dataList.get(i).get(D_13)));

            in1_1.addContent(new Element("IN1.15", namespace).addContent(dataList.get(i).get(OKATO_3)));

            in1_1.addContent(new Element("IN1.35", namespace).addContent("Â"));

            in1_1.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(POL)));

            //IN1-2
            Element adt_a01_2insurance = new Element("ADT_A01.INSURANCE", namespace);
            adt_a01.addContent(adt_a01_2insurance);

            Element in1_2 = new Element("IN1", namespace);
            adt_a01_2insurance.addContent(in1_2);

            in1_2.addContent(new Element("IN1.1", namespace).addContent("2"));

            in1_2.addContent(new Element("IN1.2", namespace).addContent(new Element("CWE.1", namespace).addContent("ÎÌÑ")));

            Element in1_2_3 = new Element("IN1.3", namespace);
            in1_2.addContent(in1_2_3);
            in1_2_3.addContent(new Element("CX.1", namespace).addContent(smo));
            in1_2_3.addContent(new Element("CX.5", namespace).addContent("NII"));

            in1_2.addContent(new Element("IN1.12", namespace).addContent(dataList.get(i).get(D_12_PLUS1).substring(0,10)));

            in1_2.addContent(new Element("IN1.13", namespace).addContent(""));

            in1_2.addContent(new Element("IN1.15", namespace).addContent("50000"));

            if(dataList.get(i).get(TYPE_POL).equals("Ý")){
                in1_2.addContent(new Element("IN1.35", namespace).addContent("Ý"));
                in1_2.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(NBLANC)));
            }else{
                in1_2.addContent(new Element("IN1.35", namespace).addContent("Ï"));
                in1_2.addContent(new Element("IN1.36", namespace).addContent(dataList.get(i).get(NBLANC)));
            }

            listGuid(guidMsh, i, "6");
        }
    }

    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate, boolean tt) {

    }

    @Override
    protected void createMiddle(int count, Namespace namespace, Element rootElement, String curDate, boolean tt, String kluch) {

    }

    @Override
    protected void createMiddle(Namespace namespace, Element rootElement, String curDate) {

    }
}
