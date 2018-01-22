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
import beans.OpportunityBean;
import views.OpportunityTCRMView;

public class OpportunitySwingView extends SwingView implements OpportunityTCRMView {
	
	private static final long serialVersionUID = 1L;

	protected class ClientForComboBox {
		private long id;
		private String description;

		protected long getId() {
			return id;
		}

		protected ClientForComboBox(long id, String description) {
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
		
		// toString() called by JComboBox to obtain display text for item
		public String toString() {
			return description;
		}
		
	}

	private JTextField textId;
	private JComboBox<ClientForComboBox> comboBoxClient;
	private JTextField textDescription;
	private JTextField textValue;
	private JTextField textDate;
	private JComboBox<String> comboBoxStatus;
	
	private String[] status = {
	         "Verbal Proposition",
	         "Written Proposition",
	         "Win",
	         "lose"
	};

	private JLabel idLblError;
	private JLabel clientLblError;
	private JLabel descriptionLblError;
	private JLabel valueLblError;
	private JLabel dateLblError;
	private JLabel statusLblError;

	/**
	 * Create the frame.
	 */
	public OpportunitySwingView() {
		super();
		setTitle("Opportunities");

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
		
		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 2;
		centerGrid.add(lblClient, gbc_lblClient);

		comboBoxClient = new JComboBox<ClientForComboBox>();
		comboBoxClient.setEditable(false);
		comboBoxClient.setEnabled(false);
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.gridx = 1;
		gbc_comboBoxClient.gridy = 2;
		centerGrid.add(comboBoxClient, gbc_comboBoxClient);

		clientLblError = new JLabel("New label");
		clientLblError.setForeground(Color.RED);
		clientLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_clientLblError = new GridBagConstraints();
		gbc_clientLblError.anchor = GridBagConstraints.WEST;
		gbc_clientLblError.insets = new Insets(0, 0, 5, 0);
		gbc_clientLblError.gridx = 1;
		gbc_clientLblError.gridy = 3;
		centerGrid.add(clientLblError, gbc_clientLblError);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 4;
		centerGrid.add(lblDescription, gbc_lblDescription);

		textDescription = new JTextField();
		textDescription.setEditable(false);
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescription.gridx = 1;
		gbc_txtDescription.gridy = 4;
		centerGrid.add(textDescription, gbc_txtDescription);
		textDescription.setColumns(10);

		descriptionLblError = new JLabel("New label");
		descriptionLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		descriptionLblError.setForeground(Color.RED);
		GridBagConstraints gbc_descriptionLblbError = new GridBagConstraints();
		gbc_descriptionLblbError.anchor = GridBagConstraints.WEST;
		gbc_descriptionLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionLblbError.gridx = 1;
		gbc_descriptionLblbError.gridy = 5;
		centerGrid.add(descriptionLblError, gbc_descriptionLblbError);

		JLabel lblValue = new JLabel("Value");
		lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.anchor = GridBagConstraints.EAST;
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 6;
		centerGrid.add(lblValue, gbc_lblValue);

		textValue = new JTextField();
		textValue.setEditable(false);
		textValue.setToolTipText("2000.00");
		GridBagConstraints gbc_textValue = new GridBagConstraints();
		gbc_textValue.insets = new Insets(0, 0, 5, 0);
		gbc_textValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_textValue.gridx = 1;
		gbc_textValue.gridy = 6;
		centerGrid.add(textValue, gbc_textValue);
		textValue.setColumns(10);

		valueLblError = new JLabel("New label");
		valueLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		valueLblError.setForeground(Color.RED);
		GridBagConstraints gbc_valueLblError = new GridBagConstraints();
		gbc_valueLblError.anchor = GridBagConstraints.WEST;
		gbc_valueLblError.insets = new Insets(0, 0, 5, 0);
		gbc_valueLblError.gridx = 1;
		gbc_valueLblError.gridy = 7;
		centerGrid.add(valueLblError, gbc_valueLblError);
		
		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 8;
		centerGrid.add(lblStatus, gbc_lblStatus);

		comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setEditable(false);
		comboBoxStatus.setEnabled(false);
		GridBagConstraints gbc_comboBoxStatus = new GridBagConstraints();
		gbc_comboBoxStatus.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxStatus.gridx = 1;
		gbc_comboBoxStatus.gridy = 8;
		centerGrid.add(comboBoxStatus, gbc_comboBoxStatus);

		statusLblError = new JLabel("New label");
		statusLblError.setForeground(Color.RED);
		statusLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_statusLblError = new GridBagConstraints();
		gbc_statusLblError.anchor = GridBagConstraints.WEST;
		gbc_statusLblError.insets = new Insets(0, 0, 5, 0);
		gbc_statusLblError.gridx = 1;
		gbc_statusLblError.gridy = 9;
		centerGrid.add(statusLblError, gbc_statusLblError);

		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 10;
		centerGrid.add(lblDate, gbc_lblDate);

		textDate = new JTextField();
		textDate.setEditable(false);
		textDate.setToolTipText("dd/mm/yyyy");
		GridBagConstraints gbc_textDate = new GridBagConstraints();
		gbc_textDate.insets = new Insets(0, 0, 5, 0);
		gbc_textDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDate.gridx = 1;
		gbc_textDate.gridy = 10;
		centerGrid.add(textDate, gbc_textDate);
		textDate.setColumns(10);

		dateLblError = new JLabel("New label");
		dateLblError.setForeground(Color.RED);
		dateLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_dateLblError = new GridBagConstraints();
		gbc_dateLblError.anchor = GridBagConstraints.WEST;
		gbc_dateLblError.insets = new Insets(0, 0, 5, 0);
		gbc_dateLblError.gridx = 1;
		gbc_dateLblError.gridy = 11;
		centerGrid.add(dateLblError, gbc_dateLblError);

		this.setMessagesText("No Opportunities in the CRM");
	}

	public String getTextId()        { return textId.getText(); }
	public String getTextDescription() { return textDescription.getText(); }
	public String getTextValue()  { return textValue.getText(); }
	public String getTextDate()   { return textDate.getText(); }

	public void setTextId(String textId)               { this.textId.setText(textId); }
	public void setTextDescription(String textDescription) { this.textDescription.setText(textDescription); }
	public void setTextValue(String textValue)   { this.textValue.setText(textValue); }
	public void setTextDate(String textDate)     { this.textDate.setText(textDate); }

	public int getSelectedClientIndex() {
		return comboBoxClient.getSelectedIndex();
	}

	public void setSelectedClientIndex(int index) {
		if (index >= 0 && index <= comboBoxClient.getItemCount()) {
			boolean previous = comboBoxClient.isEnabled();
			comboBoxClient.setEnabled(false); // Avoid firing event listeners
	  		comboBoxClient.setSelectedIndex(index);
	  		comboBoxClient.setEnabled(true);
	  		comboBoxClient.setEnabled(previous);
		}
	}

	public void setSelectClientItems(ArrayList<CRMBean> list) {
		comboBoxClient.removeAllItems();
		for (CRMBean item : list) {
			comboBoxClient.addItem(new ClientForComboBox(item.getId(), item.getDescription()));
		}
	}

	public void setSelectClientListener(ActionListener listener) {
		comboBoxClient.addActionListener(listener);
	}
	
	public int getSelectedStatusIndex() {
		return comboBoxStatus.getSelectedIndex();
	}
	
	public void setSelectedStatusIndex(int index) {
		if (index >= 0 && index <= comboBoxStatus.getItemCount()) {
			boolean previous = comboBoxStatus.isEnabled();
			comboBoxStatus.setEnabled(false); // Avoid firing event listeners
			comboBoxStatus.setSelectedIndex(index);
			comboBoxStatus.setEnabled(true);
			comboBoxStatus.setEnabled(previous);
		}
	}
	
	public void setSelectStatusItems() {
		comboBoxStatus.removeAllItems();
		for (int i = 0; i < 4; i++) {
			comboBoxStatus.addItem(status[i]);
		}
	}
	
	public void setSelectStatusListener(ActionListener listener) {
		comboBoxStatus.addActionListener(listener);
	}

	public String getErrorDescription() { return descriptionLblError.getText(); }
	public String getErrorValue() { return valueLblError.getText(); }
	public String getErrorDate()   { return dateLblError.getText(); }

	public void setErrorDescription(String errorDescription) { descriptionLblError.setText(errorDescription); }
	public void setErrorValue(String errorValue)   { valueLblError.setText(errorValue); }
	public void setErrorDate(String errorDate)     { dateLblError.setText(errorDate); }

	public void beanToForm(CRMBean bean) {
		OpportunityBean ob = (OpportunityBean) bean;
		this.setTextId(""+ob.getId());
		for (int i=0; i < comboBoxClient.getItemCount(); i++) {
			ClientForComboBox item = comboBoxClient.getItemAt(i);
			if (item.getId() == ob.getId()) {
				this.setSelectedClientIndex(i);
			}
		}
		this.setTextDescription(ob.getSaleDescription());
		this.setTextValue(ob.getValue());
		for (int i = 0; i < comboBoxStatus.getItemCount(); i++) {
			String item = comboBoxStatus.getItemAt(i);
			if (item.equals(ob.getStatus())) {
				this.setSelectedStatusIndex(i);
			}
		}
		this.setTextDate(ob.getDate());
	}

	public void formToBean(CRMBean bean) {
		OpportunityBean ob = (OpportunityBean) bean;
		ob.setClient(((ClientForComboBox) comboBoxClient.getSelectedItem()).getId());
		ob.setSaleDescription(textDescription.getText());
		ob.setValue(textValue.getText());
		ob.setStatus((String) comboBoxStatus.getSelectedItem());
		ob.setDate(textDate.getText());
	}

	public void enableEditMode() { 
		super.enableEditMode();
		comboBoxClient.setEnabled(true);
		textDescription.setEditable(true);
		textValue.setEditable(true);
		comboBoxStatus.setEnabled(true);
		textDate.setEditable(true);
	}
	public void disableEditMode() {
		super.disableEditMode();
		textId.setEditable(false);
		comboBoxClient.setEnabled(false);
		textDescription.setEditable(false);
		textValue.setEditable(false);
		comboBoxStatus.setEnabled(false);
		textDate.setEditable(false);
	}

	public void clearForm() {
		textId.setText("");
		if (comboBoxClient.getItemCount() > 0) { comboBoxClient.setSelectedIndex(0); }
		textDescription.setText("");
		textValue.setText("");
		if (comboBoxStatus.getItemCount() > 0) { comboBoxStatus.setSelectedIndex(0); }
		textDate.setText("");
		clearFieldErrors();
	}

	public void clearFieldErrors() {
		idLblError.setText("");
		clientLblError.setText("");
		descriptionLblError.setText("");
		valueLblError.setText("");
		statusLblError.setText("");
		dateLblError.setText("");
	}

}