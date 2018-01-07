package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunityTCRMView extends TCRMView {

	String getTextId();
	String getTextDescription();
	String getTextValue();
	String getTextDate();
	String getTextStatus();
	
	void setTextId(String textId);
	void setTextDescription(String textDescription);
	void setTextValue(String textValue);
	void setTextDate(String textDate);
	void setTextStatus(String textStatus);
	
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorDescription();
	String getErrorValue();
	String getErrorDate();
	String getErrorStatus();
	
	void setErrorDescription(String errorDescription);
	void setErrorValue(String errorValue);
	void setErrorDate(String errorDate);
	void setErrorStatus(String errorStatus);
	
}