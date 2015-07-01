import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainEntry {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		mainMenu();
		
		

	}
		public static void mainMenu(){
			System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you");
			System.out.println("\n");
			System.out.println("1) Librarian");
			System.out.println("2) Administrator");
			System.out.println("3) Borrower");
			System.out.println("\n");
			System.out.println("Take input");
//			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
//			System.out.println(n);
			switch (n) {
			case 1: {
				Lib1();
				break;
			}
			case 2: {
				admin();
				break;
			}
			case 3: {
				borrower();
				break;
			}
			}
//			return n;
		}
		public static void admin(){
			System.out.println("*******************************");
			System.out.println("1)  Over-ride Due Date for a Book Loan");
			System.out.println("\n");
			System.out.println("Take input");
			int i = scan.nextInt();
			switch(i){
			case 1: {
				adminOverRide();
				break;
			}
			}
		}
		public static void Lib1(){
			System.out.println("*******************************");
			System.out.println("1)  Enter Branch you manage");
			System.out.println("2)  Quite to previous");
			System.out.println("\n");
			System.out.println("Take input");
//			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
//			System.out.println(n);
			switch (n){
			case 1:{
				Lib2();
				break;
			}
			case 2:{
				mainMenu();
				break;
			}
			}
//			return n;
		}
		public static void Lib2(){
			List <String> branchList = new ArrayList <String>();
			int order=1;
			System.out.println("*******************************");
	
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				String selectQuery = "SELECT * FROM library.tbl_library_branch;";
				ResultSet rs = stmt.executeQuery(selectQuery);

				while(rs.next()){
					String branchName = rs.getString("branchName");
					String BranchAddress = rs.getString("branchAddress");
					branchList.add(branchName);
					System.out.println(order+")  "+branchName+", "+BranchAddress);
					order++;
				}
			
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("\n");
			System.out.println("Take input");
			int n = scan.nextInt();
			switch (n){
			case 1: {
				Lib3(n);
				break;
			}
			case 2: {
				Lib3(n);
				break;
			}
			case 3: {
				Lib3(n);
				break;
			}
			case 4: {
				Lib3(n);
				break;
			}
			case 5: {
				Lib1();
				break;
			}
			}
		}
		public static void Lib3( int n){
			System.out.println("*******************************");
			System.out.println("1)  Update the details of the Library ");
			System.out.println("2)  Add copies of Book to the Branch");
			System.out.println("3)  Quit to previous");
			System.out.println("\n");
			System.out.println("Take input");
			int k = scan.nextInt();
//			System.out.println(k);
			switch (k){
			case 1: {
				getLibraryDetails(n);
				break;
			}
			case 2: {
				Lib4(n);
			}
			case 3: {
				Lib2();
				break;
			}
			}
			
		}
		
		public static void Lib4(int n){
			int bookId=0;
			String title=null;
			
			System.out.println("*******************************");
			System.out.println("Pick the Book you want to add copies of, to your branch:");

			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				String selectQuery = "SELECT * FROM library.tbl_book;";
				ResultSet rs = stmt.executeQuery(selectQuery);

				while(rs.next()){
					bookId = rs.getInt("bookId");
					title = rs.getString("title");
					System.out.println(bookId+")  "+ title);
				}
			
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			System.out.println("\n");
			System.out.println("Take input");

			
			
			int k = scan.nextInt();

			addBookstoBranch(n,k);

		}
		public static void borrower(){
			System.out.println("Enter your card number:");
			System.out.println("\n");
			System.out.println("Take input");
			int n = scan.nextInt();
			System.out.println(n);
			int cardNo=checkBorrower(n);
			borr1(cardNo);
			
			
		}
		
		public static void borr1(int cardNo){
			System.out.println("*******************************");
			System.out.println("1)  Check out a book.");
			System.out.println("2)  Return a book.");
			System.out.println("3)  Quit to previous.");
			System.out.println("\n");
			System.out.println("Take input");
			int n = scan.nextInt();
			switch (n) {
			case 1: {
				checkOutBranch(cardNo);
				break;
			}
			case 2: {
				returnBookBranch(cardNo);
				break;
			}
			case 3: {
				mainMenu();
				break;
			}
			}
		}
		public static void checkOutBranch(int cardNo){
			int branchId= 0;
			System.out.println("*******************************");
			System.out.println("Pick the Branch you want to check out from:");

			List <String> branchList = new ArrayList <String>();
	
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				String selectQuery = "SELECT * FROM library.tbl_library_branch;";
				ResultSet rs = stmt.executeQuery(selectQuery);

				while(rs.next()){
					branchId = rs.getInt("branchId");
					String branchName = rs.getString("branchName");
					String BranchAddress = rs.getString("branchAddress");
					branchList.add(branchName);
					System.out.println(branchId+")  "+branchName+", "+BranchAddress);
				}
			
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			System.out.println("5)  Quit to previous");
			System.out.println("\n");
			System.out.println("Take input");
			int n = scan.nextInt();
			switch (n) {
			case 1:{
				borrowBook(n,cardNo);
				break;
			}
			case 2:{
				borrowBook(n, cardNo);
				break;
			}
			case 3:{
				borrowBook(n, cardNo);
				break;
			}
			case 4:{
				borrowBook(n, cardNo);
				break;
			}
			case 5:{
				borr1(cardNo);
				break;
			}
			default:
				break;
			}
		}
		
		

		public static void getLibraryDetails(int k ){
			int BranchId;
			String BranchName = null;
			String BranchAddress = null;
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				String selectQuery = "select * from tbl_library_branch where branchId=" + k;
				ResultSet rs = stmt.executeQuery(selectQuery);

				
				
				while(rs.next()){
					BranchId = rs.getInt("branchId");
					BranchName = rs.getString("branchName");
					BranchAddress = rs.getString("branchAddress");
					System.out.println("You have chosen to update the Branch with Branch Id:" + BranchId + "and Branch Name: " + BranchName + ". Enter ‘quit’ at any prompt to cancel operation.");

					
				}
				
				
				System.out.println("\n");
				System.out.println("Please enter new branch name or enter N/A for no change:");
				System.out.println("<take input>");
				@SuppressWarnings("resource")
				Scanner scan1 = new Scanner (System.in);
				String inPut = scan1.nextLine();
				System.out.println(inPut);
				if(inPut.equals("quit")){
					mainMenu();
				}
				else if (inPut.equals("N/A")){

					inPut = BranchName;
					System.out.println("without change");
				}

				System.out.println("\n");
				System.out.println("Please enter new branch address or enter N/A for no change:");
				System.out.println("<take input>");
				
				String inPut1 = scan1.nextLine();
				System.out.println(inPut1);
				if(inPut.equals("quit")){
					mainMenu();
				}
				else if (inPut1.equals("N/A")){

					inPut1 = BranchAddress;
					System.out.println("without change");
				}
	

				String createQuery = "UPDATE `tbl_library_branch` SET `branchName`='"+inPut+"', `branchAddress`='"+inPut1+"' WHERE `branchId`='"+k+"'";
				
				stmt.executeUpdate(createQuery);
				
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("update success!");
			Lib3(k);
		}
		public static void addBookstoBranch(int branchId,int bookId){
			int noOfCopies=0;
			String addToTable;
			System.out.println(branchId);
			System.out.println(bookId);

			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				String selectQuery = "select noOfCopies from tbl_book_copies, tbl_book, tbl_library_branch where tbl_book_copies.bookId="+bookId+" and tbl_book_copies.branchId ="+branchId+"  and tbl_book_copies.branchId = tbl_library_branch.branchId and tbl_book_copies.bookId = tbl_book.bookId;";
				ResultSet rs = stmt.executeQuery(selectQuery);				
				while(rs.next()){

					 noOfCopies = rs.getInt("noOfCopies");
					
					 System.out.println("The Existing number of copies: "+ noOfCopies);
				}
				
				System.out.println("enter number of books you want to add:");
				System.out.println("Take Input");
				
				int addBooks = scan.nextInt();
				int bookUpDate = noOfCopies+addBooks;
				if(noOfCopies==0){
				addToTable = "INSERT INTO `library`.`tbl_book_copies` (`bookId`, `branchId`, `noOfCopies`) VALUES ('"+bookId+"', '"+branchId+"', '"+addBooks+"');";
				}
				else 
				{
				addToTable = "UPDATE `library`.`tbl_book_copies` SET `noOfCopies`='"+bookUpDate+"' WHERE `bookId`='"+bookId+"' and`branchId`='"+branchId+"';";
				}
				stmt.executeUpdate(addToTable);
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Lib3(branchId);
		}

		public static int checkBorrower(int n){
			Library_borrower LB = null;
			int cardNo=0;
			String name = null;
			String address = null;
			int phone = 0;
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
				System.out.println(n);
				String selectQuery = "SELECT * FROM library.tbl_borrower where cardNo ="+ n+";" ;
//				System.out.println(selectQuery);
				ResultSet rs = stmt.executeQuery(selectQuery);

				
				while(rs.next()){

					cardNo = rs.getInt("cardNo");
					name = rs.getString("name");
					address = rs.getString("address");
					phone = rs.getInt("phone");
//					System.out.println(cardNo);
				
					LB= new Library_borrower(cardNo, name, address, phone);
					
				}
//				System.out.println(LB.getCardId());
				
				if(LB!=null){
//					borrower();
					
					System.out.println("check success!");
//					return LB;
				}
				else{
//				System.out.println("check success!");
				borrower();
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cardNo;
		}
		
		public static void borrowBook(int branchId,int cardNo){
			String title=null;
			List<Integer>  copyNoList = new ArrayList<Integer> ();
			int noOfCopies;
//			int i= 1;
			int number= 0;
//			int branchId = 1;
//			int cardNo= 1;
			int bookId=0;
//			int bookSelect=0;
			
			
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();

				String selectQuery = "select tbl_book.bookId,title, noOfCopies from tbl_book, tbl_book_copies, tbl_library_branch where tbl_book_copies.branchId = tbl_library_branch.branchId and tbl_book_copies.bookId = tbl_book.bookId and tbl_library_branch.branchId ="+branchId+" and noOfCopies>0;" ;
				ResultSet rs = stmt.executeQuery(selectQuery);
				System.out.println("The library have these books:");
				while(rs.next()){
					bookId= rs.getInt("bookId");
					title = rs.getString("title");
					noOfCopies = rs.getInt("noOfCopies");
					System.out.println(bookId+")  "+title+" "+noOfCopies+" copies left");
					copyNoList.add(noOfCopies);
					
				}
				System.out.println("Choose one book to check out");
				System.out.println("Take input");
				number = scan.nextInt();
//				bookSelect = bookNumber(bookList.get(number-1));
				String checkBook = "INSERT INTO `library`.`tbl_book_loans` (`bookId`, `branchId`, `cardNo`, `dateOut`, `dueDate`) VALUES ('"+number+"', '"+branchId+"', '"+cardNo+"', curdate(), DATE_ADD(curdate(), INTERVAL 7 DAY));";
				stmt.executeUpdate(checkBook);
				int bookNoChange = ((int) copyNoList.get(number-1)-1);
				System.out.println(bookNoChange);
				String updateCopies = "UPDATE `library`.`tbl_book_copies` SET `noOfCopies`='"+bookNoChange+"' WHERE `bookId`='"+bookId+"' and`branchId`='"+branchId+"';";
				stmt.executeUpdate(updateCopies);
				
				conn.close();
				System.out.println("Borrow successed!");
				borr1(cardNo);
//				INSERT INTO `library`.`tbl_book_loans` (`bookId`, `branchId`, `cardNo`, `dateOut`, `dueDate`) VALUES ('1', '1', '1', curdate(), DATE_ADD(curdate(), INTERVAL 7 DAY));				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void returnBookBranch(int cardNo){
			String title=null;
			String branchName=null;
			String userName=null;
			Date dateIn=null;
			Date dueDate=null;
			List<String>bookName = new ArrayList<String>();
			List<String>branchIndex = new ArrayList<String>();
 
			Scanner scan1 = new Scanner(System.in);

			
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
			
				String selectQuery = "select b.title,c.branchName, d.name,a.dateOut,a.dueDate from tbl_book_loans a, tbl_book b,tbl_library_branch c, tbl_borrower d where a.bookId=b.bookId and a.branchId = c.branchId and a.cardNo= d.cardNo and a.cardNo="+cardNo+";";
				ResultSet rs = stmt.executeQuery(selectQuery);

				System.out.println("These are books you borrowed.");
				System.out.println("Title                        BranchName          Borrower              Date borrowed               Due date");
				while(rs.next()){
					title=rs.getString("title");
					branchName=rs.getString("branchName");
					userName=rs.getString("name");
					dateIn=rs.getDate("dateOut");
					dueDate=rs.getDate("dueDate");
					
					System.out.println(title+" | "+branchName+" | "+userName+" | "+dateIn+" | "+dueDate);
					bookName.add(title);
					branchIndex.add(branchName);
					

				}
				System.out.println("\n");
				System.out.println("Select one book you want to return.");
				System.out.println("<Take Input>");
				int input = scan.nextInt();
				String bookname= bookName.get(input-1);
				String branchLibrary= branchIndex.get(input-1);
				String returnUpdate = "update library.tbl_book_loans set dateIn = CURDATE() where bookId=(select bookId from tbl_book where tbl_book.title='"+bookname+"');";
				stmt.executeUpdate(returnUpdate);
				String copies = "update library.tbl_book_copies set noOfCopies = noOfCopies+1 where bookId=(select bookId from tbl_book where tbl_book.title='"+bookname+"') and branchId= (select branchId from tbl_library_branch where branchName = '"+branchLibrary+"');";
				stmt.executeUpdate(copies);
			
				System.out.println("Do you want to delete your borrow history?");
				System.out.println("Yes or No");
				String answer = scan1.nextLine();
				if(answer.equals("Yes")){
					String delete = "DELETE FROM `library`.`tbl_book_loans` WHERE `bookId`=(select bookId from tbl_book where tbl_book.title='"+bookname+"' ) and`branchId`=(select branchId from tbl_library_branch where branchName = '"+branchLibrary+"') and`cardNo`='"+cardNo+"';";
					stmt.execute(delete);
				}
				
				

				
				conn.close();
				System.out.println("\n");
				System.out.println("Return finished!");
				borr1(cardNo);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void adminOverRide(){
			String title=null;
			String branchName=null;
			String userName=null;
			Date dateIn=null;
			Date dueDate=null;
			List<String>bookName = new ArrayList<String>();
			List<String>branchIndex = new ArrayList<String>();
			
			Scanner scan1 = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Type the name of borrower:");
			System.out.println("Take input");
			String borrowerName= scan1.nextLine();
			
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt = conn.createStatement();
			
				String selectQuery = "select b.title,c.branchName, d.name,a.dateOut,a.dueDate from tbl_book_loans a, tbl_book b,tbl_library_branch c, tbl_borrower d where a.bookId=b.bookId and a.branchId = c.branchId and a.cardNo= d.cardNo and d.name='"+borrowerName+"';";
				ResultSet rs = stmt.executeQuery(selectQuery);

				System.out.println("These are books you borrowed.");
				System.out.println("Title                        BranchName          Borrower              Date borrowed               Due date");
				while(rs.next()){
					title=rs.getString("title");
					branchName=rs.getString("branchName");
					userName=rs.getString("name");
					dateIn=rs.getDate("dateOut");
					dueDate=rs.getDate("dueDate");
					
					System.out.println(title+" | "+branchName+" | "+userName+" | "+dateIn+" | "+dueDate);
					bookName.add(title);
					branchIndex.add(branchName);
					

				}
				System.out.println("\n");
				System.out.println("select one you want to extend the duedate.");
				int select = scan2.nextInt();
				String bookname= bookName.get(select-1);
				String branchLibrary= branchIndex.get(select-1);
				System.out.println("enter the duedate (yyyy-mm-dd)");
				String newDate = scan1.nextLine();
				Date newDate1 = Date.valueOf(newDate);
				System.out.println(newDate1);
//				UPDATE `library`.`tbl_book_loans` SET `dueDate`='2015-07-31' WHERE `bookId`='1' and`branchId`='1' and`cardNo`='1';
				System.out.println(bookname);
				System.out.println(branchLibrary);
				System.out.println(borrowerName);
				String update ="UPDATE `library`.`tbl_book_loans` SET `dueDate`='"+newDate1+"' WHERE `bookId`=(select bookId from tbl_book where tbl_book.title='"+bookname+"' ) and`branchId`=(select branchId from tbl_library_branch where branchName = '"+branchLibrary+"') and`cardNo`=(select cardNo from tbl_borrower where tbl_borrower.name='"+borrowerName+"');";
				stmt.executeUpdate(update);
				System.out.println("update success");
				
				conn.close();

				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		
}
		