
public class Library_book_copies {
		private int bookId;
		private int branchId;
		private int noOfCopies;
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
		public int getNoOfCopies() {
			return noOfCopies;
		}
		public void setNoOfCopies(int noOfCopies) {
			this.noOfCopies = noOfCopies;
		}
		public Library_book_copies(int bookId, int branchId, int noOfCopies) {
			super();
			this.bookId = bookId;
			this.branchId = branchId;
			this.noOfCopies = noOfCopies;
		}
		
		
}
