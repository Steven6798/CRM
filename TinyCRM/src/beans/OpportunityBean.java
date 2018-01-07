package beans;

public class OpportunityBean extends CRMBean {
	
	private long client;
	private String description;
	private String value;
	private String date;
	private String status;

	public OpportunityBean(long id) {
		super(id);
		client = -1;
		description = "";
		value = "";
		date = "";
		status = "";
	}
	
	public long getClient() {
		return client;
	}
	
	public void setClient(long id) {
		this.client = id;
	}
	
	public String getSaleDescription() {
		return description;
	}
	
	public void setSaleDescription(String description) {
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return this.getId() + ": " + this.getSaleDescription();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof OpportunityBean) {
			OpportunityBean c = (OpportunityBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}

}