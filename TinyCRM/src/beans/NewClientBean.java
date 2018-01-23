package beans;

public class NewClientBean extends ClientBean {
	
	private long contact;
	private long opportunity;

	public NewClientBean(long id) {
		super(id);
		contact = -1;
		opportunity = -1;
	}
	
	public long getContact() {
		return contact;
	}
	
	public void setContact(long id) {
		this.contact = id;
	}
	
	public long getOpportunity() {
		return opportunity;
	}
	
	public void setOpportunity(long id) {
		this.opportunity = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof NewClientBean) {
			NewClientBean c = (NewClientBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}

}