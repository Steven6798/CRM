package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunityTCRMView extends TCRMView {

	String getTextId();
	String getTextDescription();
	String getTextValue();
	String getTextDate();
	
	void setTextId(String textId);
	void setTextDescription(String textDescription);
	void setTextValue(String textValue);
	void setTextDate(String textDate);
	
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	int getSelectedStatusIndex();
	void setSelectedStatusIndex(int index);
	void setSelectStatusItems();
	void setSelectStatusListener(ActionListener listener);
	
	String getErrorDescription();
	String getErrorValue();
	String getErrorDate();
	
	void setErrorDescription(String errorDescription);
	void setErrorValue(String errorValue);
	void setErrorDate(String errorDate);
	
}