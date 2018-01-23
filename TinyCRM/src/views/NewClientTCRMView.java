package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface NewClientTCRMView extends ClientTCRMView {
	
	int getSelectedContactIndex();
	void setSelectedContactIndex(int index);
	void setSelectContactItems(ArrayList<CRMBean> list);
	void setSelectContactListener(ActionListener listener);
	
	int getSelectedOpportunityIndex();
	void setSelectedOpportunityIndex(int index);
	void setSelectOpportunityItems(ArrayList<CRMBean> list);
	void setSelectOpportunityListener(ActionListener listener);

}