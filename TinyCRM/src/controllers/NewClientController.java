package controllers;

import models.CRMModel;
import swingViews.SwingView;
import views.ClientTCRMView;

public class NewClientController extends ClientController{
	
	ClientTCRMView view = (ClientTCRMView) getView();
	
	public NewClientController(SwingView view, CRMModel model) {
		super(view, model);
	}

	@Override
	public void validateCompany() {
		if(!view.getTextCompany().matches("[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]")) {
			addValidationError("Company", "Invalid company name structure. Examples: 'Energy online', 'Steven Online media blog'");
		}
		super.validateCompany();
	}
	
	@Override
	public void validateTelephone() {
		if(!view.getTextTelephone().matches("[0-9]{3} ?\\-?[0-9]{3} ?\\-?[0-9]{4}")) {
			addValidationError("Telephone", "Invalid telephone structure. Examples: '787 222 2222', '787-222-2222'");
		}
		super.validateTelephone();
	}
	
	@Override
	public void validateEmail() {
		if(!view.getTextEmail().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
			addValidationError("Email", "Invalid email structure. Examples: 'journaldev.100@journaldev.com.au', 'journaldev-100@yahoo.com'");
		}
		super.validateEmail();
	}
	
	@Override
	public void validateWebsite() {
		if(!view.getTextWebsite().matches("^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*")) {
			addValidationError("Website", "Invalid website structure. Examples: 'http://www.holahola.com'");
		}
		super.validateWebsite();
	}
	
	@Override
	public void validateFacebook() {
		if(!view.getTextFacebook().matches("[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]")) {
			addValidationError("Facebook", "Invalid facebook name structure. Examples: 'Carl Jhonson', 'Mia S Savelli Ruiz'");
		}
		super.validateFacebook();
	}
}