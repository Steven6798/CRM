package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import models.ClientModel;
import swingViews.ContactSwingView;
import swingViews.SwingView;
import views.ContactTCRMView;

public class NewContactController extends ContactController {

	ContactTCRMView view = (ContactTCRMView) getView();

	public NewContactController(SwingView contactView, CRMModel contactModel, CRMModel clientModel) {
		super(contactView, contactModel, clientModel);

		ContactSwingView cv = (ContactSwingView) contactView;
		ClientModel clientModel2 = (ClientModel) clientModel;

		cv.setSelectClientItems(clientModel2.getAllBeans());
		cv.clearFieldErrors();
		cv.setSelectClientListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Combo Box Selected");
			}
		});
	}

	@Override
	public void validateFirstName() throws InvalidFormFieldData {
		if(!view.getTextFirstName().matches("[a-zA-Z]* ?[a-zA-Z]{1}")) {
			if(view.getTextFirstName().matches("[a-zA-Z]* {2,}[a-zA-Z]{1}")) {
				addValidationError("FirstName", "The first name can only contain one space between name and middle name.");
			}
			else if(view.getTextFirstName().matches("[a-zA-Z]* {1}")) {
				addValidationError("FirstName", "If there is a space after the name, there must be a middle name.");
			}
			else {
				addValidationError("FirstName", "Invalid name structure. Examples: 'Bruce', 'Bruce L'.");
			}
		}
		super.validateFirstName();
	}

	@Override
	public void validateLastName() throws InvalidFormFieldData {
		if(!view.getTextLastName().matches("[a-zA-Z]* ?[a-zA-Z]+")) {
			if(view.getTextLastName().matches("[a-zA-Z]* {2,}[a-zA-Z]*")) {
				addValidationError("LastName", "The last name can only contain one space between the first and second last names.");
			}
			else if(view.getTextLastName().matches("[a-zA-Z]* {1}")) {
				addValidationError("LastName", "If there is a space after the last name, there must be a second last name.");
			}
			else {
				addValidationError("LastName", "Invalid last name structure. Examples: 'Dew', 'Dew Gray'.");
			}
		}
		super.validateLastName();
	}

	@Override
	public void validateCompany() throws InvalidFormFieldData {
		if(!view.getTextCompany().matches("[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]")) {
			addValidationError("Company", "Invalid company name structure. Examples: 'Energy online', 'Steven Online media blog'");
		}
		super.validateCompany();
	}

	@Override
	public void validateTelephone() throws InvalidFormFieldData {
		if(!view.getTextTelephone().matches("[0-9]{3} ?\\-?[0-9]{3} ?\\-?[0-9]{4}")) {
			addValidationError("Telephone", "Invalid telephone structure. Examples: '787 222 2222', '787-222-2222'");
		}
		super.validateTelephone();
	}

	@Override
	public void validateEmail() throws InvalidFormFieldData {
		if(!view.getTextEmail().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
			addValidationError("Email", "Invalid email structure. Examples: 'journaldev.100@journaldev.com.au', 'journaldev-100@yahoo.com'");
		}
		super.validateEmail();
	}

	@Override
	public void validateFacebook() throws InvalidFormFieldData {
		if(!view.getTextFacebook().matches("[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]* ?[a-zA-Z]")) {
			addValidationError("Facebook", "Invalid facebook name structure. Examples: 'Carl Jhonson', 'Mia S Savelli Ruiz'");
		}
		super.validateFacebook();
	}

}