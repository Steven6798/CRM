package controllers;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.SwingView;
import views.ContactTCRMView;

public class NewContactController extends ContactController {

	public NewContactController(SwingView contactView, CRMModel contactModel, CRMModel clientModel) {
		super(contactView, contactModel, clientModel);
	}

	@Override
	public void validateFirstName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextFirstName().matches("[a-zA-Z]* ?[a-zA-Z]{1}")) {
			if(view.getTextFirstName().matches("[a-zA-Z]* {2,}[a-zA-Z]{1}")) {
				addValidationError("FirstName", "The first name can only contain one space between name and middle name.");
			}
			else if(view.getTextFirstName().matches("[a-zA-Z]* +")) {
				addValidationError("FirstName", "If there is a space after the name, there must be a middle name.");
			}
			else {
				addValidationError("FirstName", "Invalid name structure.");
			}
		}
		super.validateFirstName();
	}

	@Override
	public void validateLastName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextLastName().matches("[a-zA-Z]* ?[a-zA-Z]+")) {
			if(view.getTextLastName().matches("[a-zA-Z]* {2,}[a-zA-Z]+")) {
				addValidationError("LastName", "The last name can only contain one space between the first and second last names.");
			}
			else if(view.getTextLastName().matches("[a-zA-Z]* +")) {
				addValidationError("LastName", "If there is a space after the last name, there must be a second last name.");
			}
			else {
				addValidationError("LastName", "Invalid last name structure.");
			}
		}
		super.validateLastName();
	}

	@Override
	public void validateCompany() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextCompany().matches("(?!\\s)(?!.*\\s$)(?=.*[a-zA-Z0-9])[a-zA-Z0-9 '~?!&]{2,}")) {
			addValidationError("Company", "Company names must only contain letters, numbers, and the symbols '~?!&.");
		}
		super.validateCompany();
	}

	@Override
	public void validateTelephone() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextTelephone().matches("[(]{1}[0-9]{3}[)]{1} {1}[0-9]{3}-{1}[0-9]{4}")) {
			addValidationError("Telephone", "Invalid telephone structure.");
		}
		super.validateTelephone();
	}

	@Override
	public void validateEmail() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextEmail().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
			addValidationError("Email", "Invalid email structure.");
		}
		super.validateEmail();
	}

	@Override
	public void validateFacebook() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if(!view.getTextFacebook().matches("[a-zA-Z0-9\\. \r]{5,}")) {
			addValidationError("Facebook", "Facebook names can only contain leters, numbers and spaces and must be at least 5 characters long.");
		}
		super.validateFacebook();
	}

}