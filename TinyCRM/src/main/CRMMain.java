package main;

import java.util.HashMap;
import java.util.Map;

import controllers.CRMController;
import controllers.NewClientController;
import controllers.NewContactController;
import controllers.OpportunityController;
import models.CRMModel;
import models.ContactModel;
import models.NewClientModel;
import models.OpportunityModel;
import swingViews.ContactSwingView;
import swingViews.NewClientSwingView;
import swingViews.OpportunitySwingView;
import swingViews.SwingView;

public class CRMMain {

	public static CRMModel clientModel = new NewClientModel();
	public static CRMModel contactModel = new ContactModel();
	public static CRMModel opportunityModel = new OpportunityModel();
	
	// Create Client module MVC objects
	public static SwingView clientView = new NewClientSwingView();
	// Client module has relationship with Contact and Opportunity modules
	// so we pass the Contact and Opportunity models objects to the Client controller
	public static CRMController clientController = new NewClientController(clientView, clientModel, contactModel, opportunityModel);

	// Create Contact module MVC objects
	public static SwingView contactView = new ContactSwingView();
	// Contacts module has relationship with Client module so we pass the Clients model object to the Contacts controller
	public static CRMController contactController = new NewContactController(contactView, contactModel, clientModel); 
	
	// Create Opportunity module MVC objects
	public static SwingView opportunityView = new OpportunitySwingView();
	// Opportunity module has relationship with Client module so we pass the Clients model object to the Opportunity controller
	public static CRMController opportunityController = new OpportunityController(opportunityView, opportunityModel, clientModel); 
	
	private static String currentModule;
	private static SwingView currentView;

	// mapModuleToView holds the view object for each module
	public static Map<String, SwingView> mapModuleToView = new HashMap<String, SwingView>();
	// mapModuleToIndex holds the index in the module selection combo box for each module
	public static Map<String, Integer> mapModuleToIndex = new HashMap<String, Integer>();

	public static void main (String[] args) {

		contactView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		clientView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		opportunityView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});

		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);
		mapModuleToView.put("Opportunities", opportunityView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);
		mapModuleToIndex.put("Opportunities", 2);
		mapModuleToIndex.put("Reports", 3);
		
		clientController.doInit();
		clientController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		contactController.doInit();
		contactController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));
		
		opportunityController.doInit();
		opportunityController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		switchToModule("Contacts"); // Initially open the Contacts module
	}

	public static void switchToModule(String moduleName) {
		if (moduleName.equals(currentModule)) return;
		SwingView nextView = mapModuleToView.get(moduleName);
		if (nextView != null) {
			nextView.setMessagesText("Welcome to TinyCRM: " + moduleName);
			nextView.setVisible(true);
			if (currentView != null) currentView.setVisible(false);
			
			currentModule = moduleName;
			currentView = nextView;
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
		}
		else {
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
			currentView.setMessagesText(moduleName + " Module Not Available Yet");
		}
	}
}