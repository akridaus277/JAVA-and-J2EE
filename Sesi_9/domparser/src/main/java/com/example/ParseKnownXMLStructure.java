package com.example;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.ArrayList;

public class ParseKnownXMLStructure{
    public static void main(String[] args) throws Exception{
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File("employees.xml"));

        //Normalize the XML Structure; It's just too important
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get all employees
        NodeList nList = document.getElementsByTagName("employee");
        System.out.println("=====================================");

        //Employee
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        System.out.println("");//just separator
        for (int index = 0; index < nList.getLength(); index++) {
            Node node = nList.item(index);
            
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                employee = new Employee();
                employee.setId(Integer.parseInt(eElement.getAttribute("id")));
                employee.setFisrtName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                employee.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                employee.setLocation(eElement.getElementsByTagName("location").item(0).getTextContent());
                employees.add(employee);
                // System.out.println("Employee id : " + eElement.getAttribute("id"));
                // System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                // System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                // System.out.println("Location : " + eElement.getElementsByTagName("location").item(0).getTextContent());
            }
        }
        for (Employee index : employees) {
            System.out.println("Employee id : " + index.getId());
                System.out.println("First Name : " + index.getFisrtName());
                System.out.println("Last Name : " + index.getLastName());
                System.out.println("Location : " + index.getLocation());
                System.out.println();
        }
        // System.out.println(employees);
    }
}