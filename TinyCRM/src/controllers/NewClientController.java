package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import main.CRMMain;
import models.CRMModel;
import models.ContactModel;
import models.OpportunityModel;
import swingViews.NewClientSwingView;
import swingViews.SwingView;
import views.ClientTCRMView;
import views.NewClientTCRMView;

public class NewClientController extends ClientController {
	
	public NewClientController(SwingView view, CRMModel model, CRMModel contactModel, CRMModel opportunityModel) {
		super(view, model);
		
		NewClientSwingView cv = (NewClientSwingView) view;
		ContactModel contactModel2 = (ContactModel) contactModel;
		OpportunityModel opportunityModel2 = (OpportunityModel) opportunityModel;

		cv.setSelectContactItems(contactModel2.getAllBeans());
		cv.setSelectOpportunityItems(opportunityModel2.getAllBeans());
		cv.clearFieldErrors();
		cv.setSelectContactListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Contact Combo Box Selected");
			}
		});
		cv.setSelectOpportunityListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opportunity Combo Box Selected");
			}
		});
	}
	
	@Override
	public void doInit() {
		super.doInit();
		refreshDropdowns();
	}
	
	@Override
	public void doLeft() {
		super.doLeft();
		refreshDropdowns();
	}

	@Override
	public void doRight() {
		super.doRight();
		refreshDropdowns();
	}
	
	@Override
	public void doEdit() {
		super.doEdit();
	}
	
	@Override
	public void doAdd() {
		super.doAdd();
		refreshDropdowns();
	}
	
	public void doSelectContact() {
		this.refreshView();
	}
	
	public void doSelectOpportunity() {
		this.refreshView();
	}

	@Override
	public void validateCompany() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if(!view.getTextCompany().matches("(?!\\s)(?!.*\\s$)(?=.*[a-zA-Z0-9])[a-zA-Z0-9 '~?!&]{2,}")) {
			addValidationError("Company", "Company names can only contain letters, numbers, and the symbols '~?!&.");
		}
		super.validateCompany();
	}
	
	@Override
	public void validateTelephone() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if(!view.getTextTelephone().matches("[(]{1}[0-9]{3}[)]{1} {1}[0-9]{3}-{1}[0-9]{4}")) {
			addValidationError("Telephone", "Invalid telephone structure.");
		}
		super.validateTelephone();
	}
	
	@Override
	public void validateEmail() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if(!view.getTextEmail().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
			addValidationError("Email", "Invalid email structure.");
		}
		super.validateEmail();
	}
	
	@Override
	public void validateWebsite() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if(!view.getTextWebsite().matches("^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*")) {
			addValidationError("Website", "Invalid website structure.");
		}
		super.validateWebsite();
	}
	
	@Override
	public void validateFacebook() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if(!view.getTextFacebook().matches("[a-zA-Z0-9\\. \r]{5,}")) {
			addValidationError("Facebook", "Facebook names can only contain letters, numbers and spaces and must be at least 5 characters long.");
		}
		super.validateFacebook();
	}
	
	@Override
	public void refreshDropdowns() {
		NewClientTCRMView cv = (NewClientTCRMView) getView();
		cv.setSelectContactItems(CRMMain.contactModel.getAllBeans());
		cv.setSelectOpportunityItems(CRMMain.opportunityModel.getAllBeans());
	}
	
	@Override
	protected void refreshView() {
		super.refreshView();
		String errorString;
		NewClientSwingView cv = (NewClientSwingView) getView();
		cv.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("Company")) { cv.setErrorCompany(validationErrors.get("Company")); }
			if (validationErrors.containsKey("Telephone")) { cv.setErrorTelephone(validationErrors.get("Telephone")); }
			if (validationErrors.containsKey("Email")) { cv.setErrorEmail(validationErrors.get("Email")); }
			if (validationErrors.containsKey("Website")) { cv.setErrorWebsite(validationErrors.get("Website")); }
			if (validationErrors.containsKey("Facebook")) { cv.setErrorFacebook(validationErrors.get("Facebook")); }
			cv.setMessagesText(errorString);
		}
	}
	
}