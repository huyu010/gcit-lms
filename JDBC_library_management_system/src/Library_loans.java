
public class Library_loans {
private	int bookId;
private	int branchId;
private	int cardNo;
private	String dateOut;
private	String dueDate;
private	String dateIn;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public int getCardNo() {
	return cardNo;
}
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
public String getDateOut() {
	return dateOut;
}
public void setDateOut(String dateOut) {
	this.dateOut = dateOut;
}
public String getDueDate() {
	return dueDate;
}
public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}
public String getDateIn() {
	return dateIn;
}
public void setDateIn(String dateIn) {
	this.dateIn = dateIn;
}
public Library_loans(int bookId, int branchId, int cardNo, String dateOut,
		String dueDate, String dateIn) {
	super();
	this.bookId = bookId;
	this.branchId = branchId;
	this.cardNo = cardNo;
	this.dateOut = dateOut;
	this.dueDate = dueDate;
	this.dateIn = dateIn;
}
	
}
