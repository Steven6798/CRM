package beans;

public abstract class CRMBean {
	
	private long id;  // Unique ID among all beans of a given type
	
	public CRMBean(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	protected void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return A descriptive String that could be used for instance in a drop-down menu
	 */
	public abstract String getDescription();
	
	/**
	 * @return The Id of the client used to classify the contact and opportunities by client.
	 */
	public abstract long getClient();

}