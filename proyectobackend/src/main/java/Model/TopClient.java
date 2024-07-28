package Model;

public class TopClient {
	private String clientName;
	private Long count;
	private int clientId;
	
	
	public TopClient(String clientName, Long count, int clientId) {
		super();
		this.clientName = clientName;
		this.count = count;
		this.clientId = clientId;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	
}