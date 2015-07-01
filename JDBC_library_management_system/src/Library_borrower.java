
public class Library_borrower {
	private int cardId;
	private String name;
	private String Address;
	private int phoneNo;



	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Library_borrower(int cardId, String name, String address, int phoneNo) {
		super();
		this.cardId = cardId;
		this.name = name;
		Address = address;
		this.phoneNo = phoneNo;
	}

	
}
