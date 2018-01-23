package swingViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import beans.CRMBean;
import beans.NewClientBean;
import views.NewClientTCRMView;

public class NewClientSwingView extends ClientSwingView implements NewClientTCRMView {
	
	private static final long serialVersionUID = 1L;

	protected class ContactForComboBox {
		private long id;
		private String description;
		
		protected long getId() {
			return id;
		}

		protected ContactForComboBox(long id, String description) {
			this.id = id;
			this.description = description;
		}

		protected String getDescription() {
			return description;
		}
		
		protected void setId(long id) {
			this.id = id;
		}
		
		protected void setDescription(String description) {
			this.description = description;
		}
		
		public String toString() {
			return description;
		}
	}
	
	protected class OpportunityForComboBox {
		private long id;
		private String description;
		
		protected long getId() {
			return id;
		}

		protected OpportunityForComboBox(long id, String description) {
			this.id = id;
			this.description = description;
		}

		protected String getDescription() {
			return description;
		}
		
		protected void setId(long id) {
			this.id = id;
		}
		
		protected void setDescription(String description) {
			this.description = description;
		}
		
		public String toString() {
			return description;
		}
	}
	
	private JComboBox<ContactForComboBox> comboBoxContact;
	private JComboBox<OpportunityForComboBox> comboBoxOpportunity;
	
	private JLabel contactLblError;
	private JLabel opportunityLblError;
	
	/**
	 * Create the frame.
	 */
	public NewClientSwingView() {
		super();
		setTitle("Clients");
		
		JScrollPane centerScrollPane = new JScrollPane();
		centerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setCenterPanel(centerScrollPane);

		JPanel centerGrid = new JPanel();
		centerScrollPane.setViewportView(centerGrid);
		GridBagLayout gbl_centerGrid = new GridBagLayout();
		gbl_centerGrid.columnWidths = new int[]{100, 475, 0};
		gbl_centerGrid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		centerGrid.setLayout(gbl_centerGrid);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		centerGrid.add(lblId, gbc_lblId);

		textId = new JTextField();
		textId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		centerGrid.add(textId, gbc_txtId);
		textId.setColumns(10);

		idLblError = new JLabel("New label");
		idLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		idLblError.setForeground(Color.RED);
		GridBagConstraints gbc_IdLblError = new GridBagConstraints();
		gbc_IdLblError.anchor = GridBagConstraints.WEST;
		gbc_IdLblError.insets = new Insets(0, 0, 5, 0);
		gbc_IdLblError.gridx = 1;
		gbc_IdLblError.gridy = 1;
		centerGrid.add(idLblError, gbc_IdLblError);
		
		JLabel lblContact = new JLabel("Contact");
		GridBagConstraints gbc_lblContact = new GridBagConstraints();
		gbc_lblContact.anchor = GridBagConstraints.EAST;
		gbc_lblContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact.gridx = 0;
		gbc_lblContact.gridy = 2;
		centerGrid.add(lblContact, gbc_lblContact);

		comboBoxContact = new JComboBox<ContactForComboBox>();
		comboBoxContact.setEditable(false);
		comboBoxContact.setEnabled(false);
		GridBagConstraints gbc_comboBoxContact = new GridBagConstraints();
		gbc_comboBoxContact.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxContact.gridx = 1;
		gbc_comboBoxContact.gridy = 2;
		centerGrid.add(comboBoxContact, gbc_comboBoxContact);

		contactLblError = new JLabel("New label");
		contactLblError.setForeground(Color.RED);
		contactLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_contactLblError = new GridBagConstraints();
		gbc_contactLblError.anchor = GridBagConstraints.WEST;
		gbc_contactLblError.insets = new Insets(0, 0, 5, 0);
		gbc_contactLblError.gridx = 1;
		gbc_contactLblError.gridy = 3;
		centerGrid.add(contactLblError, gbc_contactLblError);
		
		JLabel lblOpportunity = new JLabel("Opportunity");
		GridBagConstraints gbc_lblOpportunity = new GridBagConstraints();
		gbc_lblOpportunity.anchor = GridBagConstraints.EAST;
		gbc_lblOpportunity.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpportunity.gridx = 0;
		gbc_lblOpportunity.gridy = 4;
		centerGrid.add(lblOpportunity, gbc_lblOpportunity);

		comboBoxOpportunity = new JComboBox<OpportunityForComboBox>();
		comboBoxOpportunity.setEditable(false);
		comboBoxOpportunity.setEnabled(false);
		GridBagConstraints gbc_comboBoxOpportunity = new GridBagConstraints();
		gbc_comboBoxOpportunity.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxOpportunity.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxOpportunity.gridx = 1;
		gbc_comboBoxOpportunity.gridy = 4;
		centerGrid.add(comboBoxOpportunity, gbc_comboBoxOpportunity);

		opportunityLblError = new JLabel("New label");
		opportunityLblError.setForeground(Color.RED);
		opportunityLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_opportunityLblError = new GridBagConstraints();
		gbc_opportunityLblError.anchor = GridBagConstraints.WEST;
		gbc_opportunityLblError.insets = new Insets(0, 0, 5, 0);
		gbc_opportunityLblError.gridx = 1;
		gbc_opportunityLblError.gridy = 5;
		centerGrid.add(opportunityLblError, gbc_opportunityLblError);

		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 6;
		centerGrid.add(lblCompany, gbc_lblCompany);
		
		textCompany = new JTextField();
		textCompany.setEditable(false);
		textCompany.setToolTipText("Art inc~'!&");
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 6;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);
		
		companyLblError = new JLabel("New label");
		companyLblError.setForeground(Color.RED);
		companyLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_CompanyLblbError = new GridBagConstraints();
		gbc_CompanyLblbError.anchor = GridBagConstraints.WEST;
		gbc_CompanyLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_CompanyLblbError.gridx = 1;
		gbc_CompanyLblbError.gridy = 7;
		centerGrid.add(companyLblError, gbc_CompanyLblbError);
		
		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 8;
		centerGrid.add(lblTelephone, gbc_lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		textTelephone.setToolTipText("(xxx) xxx-xxxx");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 8;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);
		
		telephoneLblError = new JLabel("New label");
		telephoneLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		telephoneLblError.setForeground(Color.RED);
		GridBagConstraints gbc_telephoneLblError = new GridBagConstraints();
		gbc_telephoneLblError.anchor = GridBagConstraints.WEST;
		gbc_telephoneLblError.insets = new Insets(0, 0, 5, 0);
		gbc_telephoneLblError.gridx = 1;
		gbc_telephoneLblError.gridy = 9;
		centerGrid.add(telephoneLblError, gbc_telephoneLblError);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 10;
		centerGrid.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 10;
		centerGrid.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		emailLblError = new JLabel("New label");
		emailLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		emailLblError.setForeground(Color.RED);
		GridBagConstraints gbc_emailLblError = new GridBagConstraints();
		gbc_emailLblError.anchor = GridBagConstraints.WEST;
		gbc_emailLblError.insets = new Insets(0, 0, 5, 0);
		gbc_emailLblError.gridx = 1;
		gbc_emailLblError.gridy = 11;
		centerGrid.add(emailLblError, gbc_emailLblError);
		
		JLabel lblWebsite = new JLabel("Website");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 0;
		gbc_lblWebsite.gridy = 12;
		centerGrid.add(lblWebsite, gbc_lblWebsite);
		
		textWebsite = new JTextField();
		textWebsite.setEditable(false);
		textWebsite.setToolTipText("http://www.xxxxxxxx.com");
		GridBagConstraints gbc_textWebsite = new GridBagConstraints();
		gbc_textWebsite.insets = new Insets(0, 0, 5, 0);
		gbc_textWebsite.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWebsite.gridx = 1;
		gbc_textWebsite.gridy = 12;
		centerGrid.add(textWebsite, gbc_textWebsite);
		textWebsite.setColumns(10);

		websiteLblError = new JLabel("New label");
		websiteLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		websiteLblError.setForeground(Color.RED);
		GridBagConstraints gbc_websiteLblError = new GridBagConstraints();
		gbc_websiteLblError.anchor = GridBagConstraints.WEST;
		gbc_websiteLblError.insets = new Insets(0, 0, 5, 0);
		gbc_websiteLblError.gridx = 1;
		gbc_websiteLblError.gridy = 13;
		centerGrid.add(websiteLblError, gbc_websiteLblError);
		
		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 14;
		centerGrid.add(lblFacebook, gbc_lblFacebook);
		
		textFacebook = new JTextField();
		textFacebook.setEditable(false);
		textFacebook.setToolTipText("Manuel75.");
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.insets = new Insets(0, 0, 5, 0);
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 14;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);
		
		facebookLblError = new JLabel("New label");
		facebookLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		facebookLblError.setForeground(Color.RED);
		GridBagConstraints gbc_facebookLblError = new GridBagConstraints();
		gbc_facebookLblError.anchor = GridBagConstraints.WEST;
		gbc_facebookLblError.insets = new Insets(0, 0, 5, 0);
		gbc_facebookLblError.gridx = 1;
		gbc_facebookLblError.gridy = 15;
		centerGrid.add(facebookLblError, gbc_facebookLblError);
		
		this.setMessagesText("No Clients in the CRM");
	}

	@Override
	public int getSelectedContactIndex() {
		return comboBoxContact.getSelectedIndex();
	}

	@Override
	public void setSelectedContactIndex(int index) {
		if (index >= 0 && index <= comboBoxContact.getItemCount()) {
			boolean previous = comboBoxContact.isEnabled();
			comboBoxContact.setEnabled(false); // Avoid firing event listeners
			comboBoxContact.setSelectedIndex(index);
			comboBoxContact.setEnabled(true);
			comboBoxContact.setEnabled(previous);
		}
	}

	@Override
	public void setSelectContactItems(ArrayList<CRMBean> list) {
		comboBoxContact.removeAllItems();
		for (CRMBean item : list) {
			if(item.getClient() ==  Long.parseLong(getTextId())) {
				comboBoxContact.addItem(new ContactForComboBox(item.getId(), item.getDescription()));
			}
		}
	}

	@Override
	public void setSelectContactListener(ActionListener listener) {
		comboBoxContact.addActionListener(listener);
	}
	
	@Override
	public int getSelectedOpportunityIndex() {
		return comboBoxOpportunity.getSelectedIndex();
	}

	@Override
	public void setSelectedOpportunityIndex(int index) {
		if (index >= 0 && index <= comboBoxOpportunity.getItemCount()) {
			boolean previous = comboBoxOpportunity.isEnabled();
			comboBoxOpportunity.setEnabled(false); // Avoid firing event listeners
			comboBoxOpportunity.setSelectedIndex(index);
			comboBoxOpportunity.setEnabled(true);
			comboBoxOpportunity.setEnabled(previous);
		}
	}

	@Override
	public void setSelectOpportunityItems(ArrayList<CRMBean> list) {
		comboBoxOpportunity.removeAllItems();
		for (CRMBean item : list) {
			if(item.getClient() ==  Long.parseLong(getTextId())) {
				comboBoxOpportunity.addItem(new OpportunityForComboBox(item.getId(), item.getDescription()));
			}
		}
	}

	@Override
	public void setSelectOpportunityListener(ActionListener listener) {
		comboBoxOpportunity.addActionListener(listener);
	}
	
	@Override
	public void beanToForm(CRMBean bean) {
		super.beanToForm(bean);
		NewClientBean cb = (NewClientBean) bean;
		for (int i=0; i < comboBoxContact.getItemCount(); i++) {
			ContactForComboBox item = comboBoxContact.getItemAt(i);
			if (item.getId() == cb.getId()) {
				this.setSelectedContactIndex(i);
			}
		}
		for (int i=0; i < comboBoxOpportunity.getItemCount(); i++) {
			OpportunityForComboBox item = comboBoxOpportunity.getItemAt(i);
			if (item.getId() == cb.getId()) {
				this.setSelectedOpportunityIndex(i);
			}
		}
	}
	
	@Override
	public void enableEditMode() { 
		super.enableEditMode();
		comboBoxContact.setEnabled(true);
		comboBoxOpportunity.setEnabled(true);
	}
	
	@Override
	public void disableEditMode() {
		super.disableEditMode();
		comboBoxContact.setEnabled(false);
		comboBoxOpportunity.setEnabled(false);
	}

	@Override
	public void clearForm() {
		super.clearForm();
		if (comboBoxContact.getItemCount() > 0) { comboBoxContact.setSelectedIndex(0); }
		if (comboBoxOpportunity.getItemCount() > 0) { comboBoxOpportunity.setSelectedIndex(0); }
		clearFieldErrors();
	}

	@Override
	public void clearFieldErrors() {
		super.clearFieldErrors();
		contactLblError.setText("");
		opportunityLblError.setText("");
	}
	
}