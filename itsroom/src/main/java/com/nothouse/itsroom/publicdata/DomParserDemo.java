package com.nothouse.itsroom.publicdata;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
/**
 * 기본 돔 라이브러리로 파싱해서 저장하는거
 * 이부분을 웹으로 바꿔야 됨
 * 로컬에서 DB인서트 했음
 */
public class DomParserDemo {

   public static void main(String[] args) {

      try {
         File inputFile = new File("Output3.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("row");
         System.out.println("----------------------------");
         Class.forName("org.postgresql.Driver");
         String url = "jdbc:postgresql://localhost/mrkim";
         Properties props = new Properties();
         props.setProperty("user", "postgres");
         props.setProperty("password", "mrkim");
         props.setProperty("ssl", "false");
         Connection conn = DriverManager.getConnection(url, props);
         PreparedStatement st = conn.prepareStatement("INSERT INTO public.stanregincd (region_cd, sido_cd, sgg_cd, umd_cd, ri_cd, locatjumin_cd, locatjijuk_cd, locatadd_nm, locat_order, locat_rm, locathigh_cd, locallow_nm, adpt_de) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
         System.out.println("----------------------------");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               // System.out.println("region_cd : " + eElement.getElementsByTagName("region_cd").item(0).getTextContent());
               // System.out.println("sido_cd : " + eElement.getElementsByTagName("sido_cd").item(0).getTextContent());
               // System.out.println("sgg_cd : " + eElement.getElementsByTagName("sgg_cd").item(0).getTextContent());
               // System.out.println("umd_cd : " + eElement.getElementsByTagName("umd_cd").item(0).getTextContent());
               // System.out.println("ri_cd : " + eElement.getElementsByTagName("ri_cd").item(0).getTextContent());
               // System.out.println("locatjumin_cd : " + eElement.getElementsByTagName("locatjumin_cd").item(0).getTextContent());
               // System.out.println("locatjijuk_cd : " + eElement.getElementsByTagName("locatjijuk_cd").item(0).getTextContent());
               // System.out.println("locatadd_nm : " + eElement.getElementsByTagName("locatadd_nm").item(0).getTextContent());
               // System.out.println("locat_order : " + eElement.getElementsByTagName("locat_order").item(0).getTextContent());
               // System.out.println("locat_rm : " + eElement.getElementsByTagName("locat_rm").item(0).getTextContent());
               // System.out.println("locathigh_cd : " + eElement.getElementsByTagName("locathigh_cd").item(0).getTextContent());
               // System.out.println("locallow_nm : " + eElement.getElementsByTagName("locallow_nm").item(0).getTextContent());
               // System.out.println("adpt_de : " + eElement.getElementsByTagName("adpt_de").item(0).getTextContent());
               st.setString(1, eElement.getElementsByTagName("region_cd").item(0).getTextContent());
               st.setString(2, eElement.getElementsByTagName("sido_cd").item(0).getTextContent());
               st.setString(3, eElement.getElementsByTagName("sgg_cd").item(0).getTextContent());
               st.setString(4, eElement.getElementsByTagName("umd_cd").item(0).getTextContent());
               st.setString(5, eElement.getElementsByTagName("ri_cd").item(0).getTextContent());
               st.setString(6, eElement.getElementsByTagName("locatjumin_cd").item(0).getTextContent());
               st.setString(7, eElement.getElementsByTagName("locatjijuk_cd").item(0).getTextContent());
               st.setString(8, eElement.getElementsByTagName("locatadd_nm").item(0).getTextContent());
               st.setString(9, eElement.getElementsByTagName("locat_order").item(0).getTextContent());
               st.setString(10, eElement.getElementsByTagName("locat_rm").item(0).getTextContent());
               st.setString(11, eElement.getElementsByTagName("locathigh_cd").item(0).getTextContent());
               st.setString(12, eElement.getElementsByTagName("locallow_nm").item(0).getTextContent());
               st.setString(13, eElement.getElementsByTagName("adpt_de").item(0).getTextContent());
               st.addBatch();
            }
         }
         int[] result = st.executeBatch();
         System.out.println("result"+result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}