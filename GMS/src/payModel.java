import java.io.Serializable;

@SuppressWarnings("serial")
public class payModel implements Serializable {
	
	private String datetime;
	private String ID;
	private String amt;
	
	
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}


}
