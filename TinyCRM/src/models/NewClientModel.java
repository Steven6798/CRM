package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.NewClientBean;

public class NewClientModel extends ClientModel {
	
	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((NewClientBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new NewClientBean(id));
		this.setIndex(this.getCount() - 1);
	}
	
	@Override
	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> clientBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				NewClientBean newBean = new NewClientBean(id);
				String contact = inputScanner.next();
				int contactId = Integer.parseInt(contact);
				newBean.setContact(contactId);
				String opportunity = inputScanner.next();
				int opportunityId = Integer.parseInt(opportunity);
				newBean.setOpportunity(opportunityId);
				String company = inputScanner.next();
				newBean.setCompany(company);
				String telephone = inputScanner.next();
				newBean.setTelephone(telephone);
				String email = inputScanner.next();
				newBean.setEmail(email);
				String website = inputScanner.next();
				newBean.setWebsite(website);
				String facebook = inputScanner.next();
				newBean.setFacebook(facebook);
				inputScanner.nextLine();  // Skip over anything left in line
				clientBeans.add(newBean);
			}
			inputScanner.close();
			return clientBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}
	
	@Override
	public String beanToFileLine(CRMBean bean) {
		String result = "";
		NewClientBean cb = (NewClientBean) bean;
		result += cb.getId();
		result += '\t';
		if (cb.getContact() < 0) {
			result += "-1";
		}
		else {
			result += ""+cb.getContact();
		}
		result += '\t';
		if (cb.getOpportunity() < 0) {
			result += "-1";
		}
		else {
			result += ""+cb.getOpportunity();
		}
		result += '\t';
		result += cb.getCompany();
		result += '\t';
		result += cb.getTelephone();
		result += '\t';
		result += cb.getEmail();
		result += '\t';
		result += cb.getWebsite();
		result += '\t';
		result += cb.getFacebook();
		return result;
	}

}