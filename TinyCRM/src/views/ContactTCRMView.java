package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface ContactTCRMView extends TCRMView {

	String getTextId();
	String getTextFirstName();
	String getTextLastName();
	String getTextCompany();
	String getTextTelephone();
	String getTextEmail();
	String getTextFacebook();
	
	void setTextId(String textId);
	void setTextFirstName(String textFirstName);
	void setTextLastName(String textLastName);
	void setTextCompany(String textCompany);
	void setTextTelephone(String textTelephone);
	void setTextEmail(String textEmail);
	void setTextFacebook(String textFacebook);

	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorFirstName();
	String getErrorLastName();
	String getErrorCompany();
	String getErrorTelephone();
	String getErrorEmail();
	String getErrorFacebook();
	
	void setErrorFirstName(String errorFirstName);
	void setErrorLastName(String errorLastName);
	void setErrorCompany(String errorCompany);
	void setErrorTelephone(String errorTelephone);
	void setErrorEmail(String errorEmail);
	void setErrorFacebook(String errorFacebook);

}