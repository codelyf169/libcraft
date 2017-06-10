//12-08-2016
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
public class JavaDB {
	List<String> Magazine=new ArrayList<String>();
	List<String> BEProjects=new ArrayList<String>();
	 static List<String> Books=new ArrayList<String>();
	static List<String> Issuer=new ArrayList<String>();
	List<String> student=new ArrayList<String>();
	List<String> YellowCard=new ArrayList<String>();
	List<String> NBAReport=new ArrayList<String>();
	private int bookcount=0;
	private static int outputcount=0;
	String path="C:/Library/";
	
   public static Connection prepareConnection(String un ,String pwd,String ip) throws SQLException, ClassNotFoundException{
	    String url="jdbc:mysql://"+ip+":3306/";
	    String drivername="com.mysql.jdbc.Driver";
	    Class.forName(drivername);
	    Connection con=DriverManager.getConnection(url,un,pwd);
	    return con;
   }
   
   public static Connection prepareConnection(String un ,String pwd,String DBName,String ip) throws SQLException, ClassNotFoundException{
	    String url="jdbc:mysql://"+ip+":3306/"+ DBName;
	    String drivername="com.mysql.jdbc.Driver";
	    Class.forName(drivername);
	    Connection con=DriverManager.getConnection(url,un,pwd);
	    return con;
  }
   
   public boolean executeUpdate(Connection con, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(command); 
	        return true;
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    } 
	}
   public boolean executeQuery(Connection con, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeQuery(command); 
	        return true;
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    } 
	}
   public void changepassword(Connection con, String password, String ip) throws SQLException
   {
	   String psswdupdate ="SET PASSWORD FOR root@"+ ip +"=PASSWORD('"+password+"')";
	   this.executeQuery(con, psswdupdate);
   }
   public void CreateNewDatabase(String DBName,Connection con) throws ClassNotFoundException
   {
	   try {
		    String createDB ="CREATE DATABASE " + DBName;
			this.executeUpdate(con, createDB);
			String useDB ="USE " + DBName;
			this.executeUpdate(con, useDB);
			this.CreateNewTableClass(con);
			this.InsertValuesInClass(con);
			this.CreateNewTableSubject(con);
			this.InsertValuesInSubject(con);
			this.CreateNewTableBooks(con);
			this.CreateNewTableStudent(con);
			this.CreateNewTableMagazine(con);
			this.CreateNewTableBEProjects(con);
			this.CreateNewTableDonated(con);
			this.CreateNewTableIssuer(con);
			this.CreateNewTableYellowCard(con);
	    } catch (SQLException | ParseException e) {
		}
	   
   }
   
   public void CreateNewUser(String un,String pwd,String ip, Connection con,String db) throws ClassNotFoundException
   {
	   try {
		    String createUser ="CREATE USER '"+ un +"'@'"+ ip +"' IDENTIFIED BY '" + pwd +"'";
			this.executeUpdate(con, createUser);
			this.GrantPrivilegesToUser(un, pwd, db, ip, con);
			
			
	    } catch (SQLException e) {
		}
	   
   }
   
  public void GrantPrivilegesToUser(String un,String pwd,String db,String ip,Connection con) throws ClassNotFoundException
   {
	   
	   try {
		    String createUser ="GRANT ALL PRIVILEGES ON "+db+".* TO '"+ un +"'@'"+ ip +"' IDENTIFIED BY '" + pwd +"' WITH GRANT OPTION";
			this.executeUpdate(con, createUser);
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not grant privileges");
			e.printStackTrace();
			return;
		}
	   
   }
   
  public void CreateNewTableBooks(Connection con) throws ClassNotFoundException
  {
	   try {
		   	int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		   		String createTblBooks ="CREATE TABLE BOOKS (A_no VARCHAR(10) NOT NULL,C_no VARCHAR(20) NOT NULL,Title VARCHAR(200) NOT NULL,Author TEXT NOT NULL,Publisher VARCHAR(200) NOT NULL,ISBN VARCHAR(20) NOT NULL,Subject_ID VARCHAR(15) NOT NULL,Reg_date DATE NOT NULL,ReturnStatus VARCHAR(15) NOT NULL, PRIMARY KEY(A_no,C_no),FOREIGN KEY (Subject_ID) REFERENCES SUBJECT(Subject_ID) ON DELETE CASCADE ON UPDATE CASCADE)";
				this.executeUpdate(con, createTblBooks);
		   	}
	    } catch (SQLException e) {
		}
	   
  }
   
   public void CreateNewTableClass(Connection con) throws ClassNotFoundException
   {
	   try {
		   	int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		   		String createTblBooks ="CREATE TABLE CLASS (Class_ID VARCHAR(15) NOT NULL,Year VARCHAR(2) NOT NULL,Sem VARCHAR(4) NOT NULL,Type VARCHAR(5) NOT NULL,PRIMARY KEY(Class_ID))";
				this.executeUpdate(con, createTblBooks);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   public void CreateNewTableSubject(Connection con) throws ClassNotFoundException
   {
	   try {
		   	int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		   		String createTblBooks ="CREATE TABLE SUBJECT (Subject_ID VARCHAR(15) NOT NULL,Name VARCHAR(100) NOT NULL,Class_ID VARCHAR(15) NOT NULL,PRIMARY KEY(Subject_ID),FOREIGN KEY (Class_ID) REFERENCES CLASS(Class_ID) ON DELETE CASCADE ON UPDATE CASCADE)";
				this.executeUpdate(con, createTblBooks);
		   	}
	    } catch (SQLException e) {
	    	e.printStackTrace();
		}
	   
   }
   
   public void CreateNewTableIssuer(Connection con) throws ClassNotFoundException
   {
	   try {
		   int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		    String createTblIssuer ="CREATE TABLE ISSUER (A_no VARCHAR(10) NOT NULL,C_no VARCHAR(20) NOT NULL,Student_ID VARCHAR(11) NOT NULL,Issue_date DATE NOT NULL,Return_date DATE NOT NULL,PRIMARY KEY(A_no,C_no),FOREIGN KEY (Student_ID) REFERENCES STUDENT(Student_ID) ON DELETE CASCADE ON UPDATE CASCADE)";
			this.executeUpdate(con, createTblIssuer);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   
   public void CreateNewTableStudent(Connection con) throws ClassNotFoundException
   {
	   try {
		   int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		    String createTblStudent ="CREATE TABLE STUDENT(Student_ID VARCHAR(11) NOT NULL,Student_name VARCHAR(100) NOT NULL,Division VARCHAR(4) NOT NULL,Phone_No BIGINT(10) NOT NULL,Email_ID VARCHAR(50) NOT NULL,Count INT(2) NOT NULL,PRIMARY KEY(Student_id))";
			this.executeUpdate(con, createTblStudent);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   public void CreateNewTableMagazine(Connection con) throws ClassNotFoundException
   {
	   try {
		   int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		    String createTblStudent ="CREATE TABLE MAGAZINE(Name VARCHAR(100) NOT NULL,Society VARCHAR(100) NOT NULL,Edition VARCHAR(50) NOT NULL,Count INT(2) NOT NULL,PRIMARY KEY(Name))";
			this.executeUpdate(con, createTblStudent);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   
   public void CreateNewTableBEProjects(Connection con) throws ClassNotFoundException
   {
	   try {
		   int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		    String createTblStudent ="CREATE TABLE BEPROJECTS(Name VARCHAR(100) NOT NULL,Domain VARCHAR(100) NOT NULL,Members TEXT NOT NULL,PRIMARY KEY(Name))";
			this.executeUpdate(con, createTblStudent);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   public void CreateNewTableDonated(Connection con) throws ClassNotFoundException
   {
	   try {
		   int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		    String createTblStudent ="CREATE TABLE DONATED(Name VARCHAR(100) NOT NULL,Subject VARCHAR(100) NOT NULL,Count INT(2) NOT NULL,PRIMARY KEY(Name))";
			this.executeUpdate(con, createTblStudent);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   public void CreateNewTableYellowCard(Connection con) throws ClassNotFoundException
   {
	   try {
		   	int count=0;
		   	DatabaseMetaData md = con.getMetaData();
		   	ResultSet rs = md.getTables(null, null, "%", null);
		   	while (rs.next()) {
		   	  count++;
		   	}
		   	if(count<1)
		   	{
		   		String createTblBooks ="CREATE TABLE YELLOWCARD (A_no VARCHAR(10) NOT NULL,C_no VARCHAR(20) NOT NULL,Title VARCHAR(200) NOT NULL,Author TEXT NOT NULL,Student_ID VARCHAR(11) NOT NULL,Issue_date DATE NOT NULL,Return_date DATE NOT NULL)";
				this.executeUpdate(con, createTblBooks);
		   	}
	    } catch (SQLException e) {
		}
	   
   }
   
   public void InsertValuesInBooks(String a_no,String c_no,String title,String author,String pub,String isbn,String sub,String reg,String ret,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO BOOKS VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, a_no);
		    ps.setString(2, c_no);
		    ps.setString(3, title);
		    ps.setString(4, author);
		    ps.setString(5, pub);
		    ps.setString(6, isbn);
		    ps.setString(7, sub);
		    SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date d=sdf.parse(reg);
			java.sql.Date newdate =new java.sql.Date(d.getTime());
			ps.setDate(8, newdate);
			ps.setString(9,ret);
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   
   public void InsertValuesInIssuer(String a_no,String c_no,String sid,String issuedate,String returndate,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO ISSUER VALUES(?,?,?,?,?)";
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, a_no);
		    ps.setString(2, c_no);
		    ps.setString(3, sid);
		    SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date d=sdf.parse(issuedate);
			java.sql.Date newdate =new java.sql.Date(d.getTime());
			ps.setDate(4, newdate);
		     d=sdf.parse(returndate);
			java.sql.Date newdate1 =new java.sql.Date(d.getTime());
			ps.setDate(5, newdate1);
			
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   
   public void InsertValuesInStudent(String sid,String name,int roll,int div,long phone,String email,int count,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?)";   
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, sid);
		    ps.setString(2, name);
		    ps.setInt(3, roll);
		    ps.setInt(4, div);
		    ps.setLong(5, phone);
		    ps.setString(6, email);
		    ps.setInt(7, count);
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   
   public void InsertValuesInSubject(Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String insert ="LOAD DATA LOCAL INFILE '"+System.getProperty("user.dir").replace("\\", "/")+"/src/SUBJECT.txt' INTO TABLE SUBJECT";
			this.executeUpdate(con, insert);
	    } catch (SQLException e) {
			return;
		}
   }
   
   public void InsertValuesInClass(Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String insert ="LOAD DATA LOCAL INFILE '"+System.getProperty("user.dir").replace("\\", "/")+"/src/CLASS.txt' INTO TABLE CLASS";
			this.executeUpdate(con, insert);
	    } catch (SQLException e) {
			return;
		}
   }
   public void InsertValuesInMagazine(String name,String society,String edition,int count,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO MAGAZINE VALUES(?,?,?,?)";   
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, name);
		    ps.setString(2, society);
		    ps.setInt(4, count);
		    ps.setString(3, edition);
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   public void InsertValuesInYC(String a_no,String c_no,String sid,java.sql.Date issuedate,java.sql.Date returndate,Connection con) throws ClassNotFoundException, ParseException
   {
	   String title=Gettitle(con,a_no,c_no);
	   String author=Getauthor(con,a_no,c_no);
	   
	   try {
		    String InsertVal ="INSERT INTO YELLOWCARD VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, a_no);
		    ps.setString(2, c_no);
		    ps.setString(3, title);
		    ps.setString(4, author);
		    ps.setString(5, sid);
			ps.setDate(6, issuedate);
			ps.setDate(7, returndate);
			
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   public void InsertValuesInBEP(String name,String domain,String members,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO BEPROJECTS VALUES(?,?,?)";   
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, name);
		    ps.setString(2, domain);
		    ps.setString(3, members);
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   public void InsertValuesInDonated(String title,String author,int count,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String InsertVal ="INSERT INTO DONATED VALUES(?,?,?)";   
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertVal);
		    ps.setString(1, title);
		    ps.setString(2, author);
		    ps.setInt(3, count);
			ps.executeUpdate();
	    } catch (SQLException e) {
		}
	   
   }
   public void deletebook(String ano,String cno,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		   Statement stmt=con.createStatement();
		   String deleteb ="DELETE FROM BOOKS WHERE A_no='"+ano+"' AND C_no='"+cno+"'";
		   stmt.executeUpdate(deleteb);
	    } catch (SQLException e) {
			return;
		}
   }
   public void deleteMagazine(String name,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		   Statement stmt=con.createStatement();
		   String deletem ="DELETE FROM MAGAZINE WHERE Name='"+name+"'";
		   stmt.executeUpdate(deletem);
	    } catch (SQLException e) {
			return;
		}
   }
   public void deleteProjects(String name,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		   Statement stmt=con.createStatement();
		   String deletem ="DELETE FROM BEPROJECTS WHERE Name='"+name+"'";
		   stmt.executeUpdate(deletem);
	    } catch (SQLException e) {
			return;
		}
   }
   public void deleteDonated(String name,Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		   Statement stmt=con.createStatement();
		   String deletem ="DELETE FROM DONATED WHERE Name='"+name+"'";
		   stmt.executeUpdate(deletem);
	    } catch (SQLException e) {
			return;
		}
   }
   public void SearchByTitle(Connection con,String ti) throws ClassNotFoundException, ParseException
   {
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbytitle ="SELECT Title,Author,Publisher,count(Author) as stock FROM BOOKS where Title='"+ti+"' group by(Author)";
		   ResultSet rs=stmt.executeQuery(Selectbytitle);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt("-", i, 1);
			   Gui3.table_1.setValueAt("-", i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt("-", i, 6);
			   Gui3.table_1.setValueAt("-", i, 7);
			   Gui3.table_1.setValueAt("-", i, 8);
			   Gui3.table_1.setValueAt(rs.getString("stock"), i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
   }
   
   public void CreateIndexTitle(Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String createindex ="CREATE INDEX title ON BOOKS(Title)";
			this.executeUpdate(con, createindex);
			System.out.println("Created index");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create index");
			e.printStackTrace();
			return;
		}
   }
   
   public void SearchByAuthor(Connection con,String ti) throws ClassNotFoundException, ParseException
   {
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbyauthor ="SELECT Title,Author,Publisher,count(Title) as stock FROM BOOKS where Author='"+ti+"' group by(Title)";
		   ResultSet rs=stmt.executeQuery(Selectbyauthor);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt("-", i, 1);
			   Gui3.table_1.setValueAt("-", i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt("-", i, 6);
			   Gui3.table_1.setValueAt("-", i, 7);
			   Gui3.table_1.setValueAt("-", i, 8);
			   Gui3.table_1.setValueAt(rs.getString("stock"), i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
   }
   public void CreateIndexAuthor(Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String createindex ="CREATE INDEX author ON BOOKS(Author)";
			this.executeUpdate(con, createindex);
			System.out.println("Created index");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create index");
			e.printStackTrace();
			return;
		}
   }
  
   public void SearchByDate(Connection con,String s_date,String e_date) throws ClassNotFoundException, ParseException
   {
	   try {
		   int i;
		   SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		   java.util.Date d=sdf.parse(s_date);
		   java.sql.Date newdate =new java.sql.Date(d.getTime());
		   java.util.Date d1=sdf.parse(e_date);
		   java.sql.Date newdate1 =new java.sql.Date(d1.getTime());
		   
		   Statement stmt=con.createStatement();
		   String Selectbytitle ="SELECT i.Issue_date,b.Title,b.A_no,b.C_no,b.Author,b.Publisher,b.ReturnStatus,i.Student_ID FROM BOOKS b natural join ISSUER i WHERE Issue_date BETWEEN '"+newdate+"' AND '"+newdate1+"' ORDER BY Issue_date";
		   ResultSet rs=stmt.executeQuery(Selectbytitle);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table_1.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt(rs.getString("ReturnStatus"), i, 6);
			   Gui3.table_1.setValueAt(rs.getString("Issue_date"), i, 7);
			   Gui3.table_1.setValueAt(rs.getString("Student_ID"), i, 8);
			   Gui3.table_1.setValueAt("-", i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
   }
   
   public void CreateIndexIssuedate(Connection con) throws ClassNotFoundException, ParseException
   {
	   try {
		    String createindex ="CREATE INDEX issuedate ON ISSUER(Issue_date)";
			this.executeUpdate(con, createindex);
			System.out.println("Created index");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create index");
			e.printStackTrace();
			return;
		}
   }
   
   
   public void SearchByStudId(Connection con,String ti) throws ClassNotFoundException, ParseException
   {
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbytitle ="SELECT b.A_no,b.C_no,b.Title,b.Author,b.Publisher,i.Issue_date,b.ReturnStatus from ISSUER i natural join BOOKS b where Student_id='"+ti+"'";
		   ResultSet rs=stmt.executeQuery(Selectbytitle);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table_1.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt(rs.getString("ReturnStatus"), i, 6);
			   Gui3.table_1.setValueAt(rs.getString("Issue_date"), i, 7);
			   Gui3.table_1.setValueAt(rs.getString("-"), i, 8);
			   Gui3.table_1.setValueAt("-", i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
		}
   }
   
   public void SearchByA_no(Connection con,String ti) throws ClassNotFoundException, ParseException
   {
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbytitle =" select b.A_no,b.C_no,b.Title,b.Author,b.Publisher,i.Student_id,i.Issue_date,b.ReturnStatus from BOOKS b natural join ISSUER i where A_no='"+ ti +"'";
		   ResultSet rs=stmt.executeQuery(Selectbytitle);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table_1.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt(rs.getString("ReturnStatus"), i, 6);
			   Gui3.table_1.setValueAt(rs.getString("Issue_date"), i, 7);
			   Gui3.table_1.setValueAt(rs.getString("Student_ID"), i, 8);
			   Gui3.table_1.setValueAt("-", i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
		}
   }
   
 public String SearchSubject_id(Connection con,String sub_name,String ty) throws ClassNotFoundException, ParseException
   {
	 String a=null;
	   try {
		   Statement stmt=con.createStatement();
	   String Selectbytitle ="SELECT s.Subject_id FROM SUBJECT s NATURAL JOIN CLASS c where c.Type LIKE '%"+ty+"' AND s.Name='"+sub_name+"' ";
	   ResultSet rs=stmt.executeQuery(Selectbytitle);
	   while(rs.next())
	   {
		 a=rs.getString("Subject_id");
	   }
    } catch (SQLException e) {
    	e.printStackTrace();
	}
	return a;
	  
   }

public void SearchByC_no(Connection con,String ti) throws ClassNotFoundException, ParseException
{
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbycno ="select b.C_no,b.A_no,b.Title,b.Author,b.Publisher,i.Student_id,i.Issue_date,b.ReturnStatus from BOOKS b natural join ISSUER i where C_no='"+ ti +"'";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table_1.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt(rs.getString("ReturnStatus"), i, 6);
			   Gui3.table_1.setValueAt(rs.getString("Issue_date"), i, 7);
			   Gui3.table_1.setValueAt(rs.getString("Student_ID"), i, 8);
			   Gui3.table_1.setValueAt("-", i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}

public void SearchByReturnStatus(Connection con) throws ClassNotFoundException, ParseException
{
	   try {
		   int i;
		   Statement stmt=con.createStatement();
		   String Selectbycno ="select b.C_no,b.A_no,b.Title,b.Author,b.Publisher,i.Student_id,i.Issue_date,b.ReturnStatus from BOOKS b natural join ISSUER i where b.ReturnStatus='ISSUED'";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   for(i=0;rs.next();i++)
		   {
			   Gui3.table_1.setValueAt(i+1, i, 0);
			   Gui3.table_1.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table_1.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.table_1.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table_1.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table_1.setValueAt(rs.getString("Publisher"), i, 5);
			   Gui3.table_1.setValueAt(rs.getString("ReturnStatus"), i, 6);
			   Gui3.table_1.setValueAt(rs.getString("Issue_date"), i, 7);
			   Gui3.table_1.setValueAt(rs.getString("Student_ID"), i, 8);
			   Gui3.table_1.setValueAt("-", i, 9);
		   }
		   for(;i<Gui3.table_1.getRowCount();i++)
		   {
			   Gui3.table_1.setValueAt("", i, 0);
			   Gui3.table_1.setValueAt("", i, 1);
			   Gui3.table_1.setValueAt("", i, 2);
			   Gui3.table_1.setValueAt("", i, 3);
			   Gui3.table_1.setValueAt("", i, 4);
			   Gui3.table_1.setValueAt("", i, 5);
			   Gui3.table_1.setValueAt("", i, 6);
			   Gui3.table_1.setValueAt("", i, 7);
			   Gui3.table_1.setValueAt("", i, 8);
			   Gui3.table_1.setValueAt("", i, 9);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public void SearchByMagazine(Connection con) throws ClassNotFoundException, ParseException
{
	   try {
		   int i=0;
		   Statement stmt=con.createStatement();
		   String Selectbycno ="Select 'Name','Society','Edition','Count' UNION ALL select * from MAGAZINE";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   Magazine.removeAll(Magazine);
		   while(rs.next()){
			   Magazine.add(Integer.toString(i));
			   Magazine.add(rs.getString("Name"));
			   Magazine.add(rs.getString("Society"));
			   Magazine.add(rs.getString("Edition"));
			   Magazine.add(rs.getString("Count"));
			   i++;
		   }
		   PDFgen.createpdf(Magazine, 5, path, "Magazine.pdf","Magazine Collection");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"Magazine.pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public void SearchByBEProject(Connection con) throws ClassNotFoundException, ParseException
{
	   try {
		   int i=0;
		   Statement stmt=con.createStatement();
		   String Selectbycno ="Select 'Name','Domain','Members' UNION ALL select * from BEPROJECTS";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   BEProjects.removeAll(BEProjects);
		   while(rs.next()){
			   BEProjects.add(Integer.toString(i));
			   BEProjects.add(rs.getString("Name"));
			   BEProjects.add(rs.getString("Domain"));
			   BEProjects.add(rs.getString("Members"));
			   i++;
		   }
		   PDFgen.createpdf(BEProjects,4, path, "BEProjects.pdf","BEprojects Collection");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"BEProjects.pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public void genYC(Connection con,String cno) throws ClassNotFoundException, ParseException
{
	   try {
		   int i=0;
		   Statement stmt=con.createStatement();
		   String ano="";
		   String cno1="";
		   String title="";
		   String author="";
		   String Selectbycno ="SELECT 'A_no','C_no','Title','Author','Student_ID','Issue_date','Return_date' UNION ALL select * from YELLOWCARD where C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   YellowCard.removeAll(YellowCard);
		   while(rs.next()){
			   YellowCard.add(Integer.toString(i));
			   ano=rs.getString("A_no");
			   cno1=rs.getString("C_no");
			   title=rs.getString("Title");
			   author=rs.getString("Author");
			   YellowCard.add(rs.getString("Student_ID"));
			   YellowCard.add(rs.getString("Issue_date"));
			   YellowCard.add(rs.getString("Return_date"));
			   i++;
		   }
		   PDFgen.createyellowcard(ano,cno1,title,author,YellowCard,4, path, "YC-"+cno+".pdf","YC-"+cno);
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"YC-"+cno+".pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public void printtable(Connection con,String item) throws ClassNotFoundException, ParseException
{
	   try {
		   int i=0;
		   if(item.equals("books"))
		   {
		   Statement stmt=con.createStatement();
		   String Selectbycno ="SELECT 'A_no','C_no','Title','Author','Publisher','ISBN','Subject_ID','Reg_date','ReturnStatus' UNION ALL select * from BOOKS";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   Books.removeAll(Books);
		   while(rs.next()){
			   Books.add(Integer.toString(i));
			   Books.add(rs.getString("A_no"));
			   Books.add(rs.getString("C_no"));
			   Books.add(rs.getString("Title"));
			   Books.add(rs.getString("Author"));
			   Books.add(rs.getString("Publisher"));
			   Books.add(rs.getString("ISBN"));
			   Books.add(rs.getString("Subject_ID"));
			   Books.add(rs.getString("Reg_date"));
			   Books.add(rs.getString("ReturnStatus"));
			   i++;
		   }
		   PDFgen.createpdf(Books,10, path, "Books"+".pdf","Books");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"Books"+".pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
		   }
		   else if(item.equals("issuer"))
		   {
		   Statement stmt=con.createStatement();
		   String Selectbycno ="SELECT 'A_no','C_no','Student_ID','Issue_date','Return_date' UNION ALL select * from ISSUER";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   Issuer.removeAll(Issuer);
		   while(rs.next()){
			   Issuer.add(Integer.toString(i));
			   Issuer.add(rs.getString("A_no"));
			   Issuer.add(rs.getString("C_no"));
			   Issuer.add(rs.getString("Student_ID"));
			   Issuer.add(rs.getString("Issue_date"));
			   Issuer.add(rs.getString("Return_date"));
			   i++;
		   }
		   if(i>1)
		   {
		   PDFgen.createpdf(Issuer,6, path, "Issuer"+".pdf","Issuer");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"Issuer"+".pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
		   }
		   else{
			   String a="The table is empty :(";
			   JOptionPane.showMessageDialog(new JFrame(), a, "Dialog",JOptionPane.INFORMATION_MESSAGE);
		   }
		   }
		   else if(item.equals("student"))
		   {
		   Statement stmt=con.createStatement();
		   String Selectbycno ="SELECT 'Student_ID','Student_name','Division','Phone_No','Email_ID','Count' UNION ALL select * from STUDENT";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   student.removeAll(student);
		   while(rs.next()){
			   student.add(Integer.toString(i));
			   student.add(rs.getString("Student_ID"));
			   student.add(rs.getString("Student_name"));
			   student.add(rs.getString("Division"));
			   student.add(rs.getString("Phone_No"));
			   student.add(rs.getString("Email_ID"));
			   student.add(rs.getString("Count"));
			   i++;
		   }
		   if(i>1)
		   {
		   PDFgen.createpdf(student,6, path, "student"+".pdf","Student");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"student"+".pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
		   }
		   else{
			   String a="The table is empty :(";
			   JOptionPane.showMessageDialog(new JFrame(), a, "Dialog",JOptionPane.INFORMATION_MESSAGE);
		   }
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public void genNBA(Connection con) throws ClassNotFoundException, ParseException
{
	   try {
		   int i=0;
		   int[] columns=new int[3];
		   Statement stmt=con.createStatement();
		   String Selectbycno ="select 'Name','Stock' UNION ALL select distinct(s.Name),count(s.Name) as Stock from SUBJECT s,BOOKS b where s.Subject_ID=b.Subject_ID and s.Class_ID like('BE%') group by s.Name;";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   NBAReport.removeAll(NBAReport);
		   while(rs.next()){
			   NBAReport.add(Integer.toString(i));
			   NBAReport.add(rs.getString("Name"));
			   NBAReport.add(rs.getString("Stock"));
			   i++;
		   }
		   columns[0]=i*3;
		   i=0;
		   Selectbycno ="select distinct(s.Name),count(s.Name) as Stock from SUBJECT s,BOOKS b where s.Subject_ID=b.Subject_ID and s.Class_ID like('TE%') group by s.Name;";
		   rs=stmt.executeQuery(Selectbycno);
		   while(rs.next()){
			   NBAReport.add(Integer.toString(i+1));
			   NBAReport.add(rs.getString("Name"));
			   NBAReport.add(rs.getString("Stock"));
			   i++;
		   }
		   columns[1]=i*3+columns[0];
		   i=0;
		   Selectbycno ="select distinct(s.Name),count(s.Name) as Stock from SUBJECT s,BOOKS b where s.Subject_ID=b.Subject_ID and s.Class_ID like('SE%') group by s.Name;";
		   rs=stmt.executeQuery(Selectbycno);
		   while(rs.next()){
			   NBAReport.add(Integer.toString(i+1));
			   NBAReport.add(rs.getString("Name"));
			   NBAReport.add(rs.getString("Stock"));
			   i++;
		   }
		   columns[2]=i*3+columns[1];
		   PDFgen.createNBAReport(NBAReport,columns, path, "NBAReport.pdf","NBA-Report");
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path+"NBAReport.pdf");
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
}
public String GetReturnStatus(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{String a=null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT ReturnStatus FROM BOOKS WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getString("ReturnStatus"); 
	   }
	   else
	   {
		   a="nobook";
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public String GetStudentid(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{String a=null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT Student_ID FROM ISSUER WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getString("Student_ID"); 
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public String Gettitle(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{String a=null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT Title FROM BOOKS WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getString("Title"); 
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public String Getauthor(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{String a=null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT Author FROM BOOKS WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getString("Author"); 
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public java.sql.Date Getissuedate(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{java.sql.Date a=null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT Issue_date FROM ISSUER WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getDate("Issue_date"); 
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public java.sql.Date Getreturndate(Connection con,String ano,String cno) throws ClassNotFoundException, ParseException
{java.sql.Date a = null;
	   try {
		   Statement stmt=con.createStatement();
		   String DisBookInfo ="SELECT Return_date FROM ISSUER WHERE A_no='"+ano+"' OR C_no='"+cno+"'";
		   ResultSet rs=stmt.executeQuery(DisBookInfo);
	   if(rs.next())
	   {
		 a=rs.getDate("Return_date");
	   }
 } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return a;
	  
}
public int GetBooksCount(Connection con,String sid) throws ClassNotFoundException, ParseException
{
	   int b=-1;
  try {
 	     Statement stmt=con.createStatement();
		     String GetCount ="SELECT Student_ID,Count FROM STUDENT WHERE Student_ID='"+sid+"'";
		     ResultSet rs1=stmt.executeQuery(GetCount);
	       if(rs1.next())
	        {
		        b=rs1.getInt("Count");
		        
		    }
	       else if(!rs1.next())
	       {
	    	   b=0;
	       }
      } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
	return b;
	  
}

public void IssueBook(Connection con,String sid,String ano,String cno,String idate,String rdate,String sname,String divi,String phone,String email) throws ClassNotFoundException, ParseException
{
	   int b1=GetBooksCount(con, sid);
	   String tmp=GetReturnStatus(con, ano,cno);
	   bookcount=0;
	   String condition="";
	   try { 
	  	 Statement stmt=con.createStatement();
	  	 ResultSet rs=stmt.executeQuery("SELECT ReturnStatus FROM BOOKS WHERE A_No='"+ano+"'");
	  	 while(rs.next())
	  	 {
	  		 condition=rs.getString("ReturnStatus");
	  	 } 
	  	 if(condition.equals("ISSUED")==false)
	  	 {
 	    if(tmp.equals("InStock") && ((3-b1) > 0 && (3-b1) < 3))
 	    {
 	     String InsertIntoIssuer ="INSERT INTO ISSUER VALUES(?,?,?,?,?)"; 
	         PreparedStatement ps= (PreparedStatement) con.prepareStatement(InsertIntoIssuer);
		     ps.setString(1, ano);
		     ps.setString(2, cno);
		     ps.setString(3, sid);
		     SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		     java.util.Date d=sdf.parse(idate);
			 java.sql.Date newdate =new java.sql.Date(d.getTime());
		     ps.setDate(4, newdate);
		     java.util.Date d1=sdf.parse(rdate);
			 java.sql.Date newdate1 =new java.sql.Date(d1.getTime());
		     ps.setDate(5, newdate1);
			 ps.executeUpdate();
			 ++b1;
			 String IncreaseCount ="UPDATE STUDENT SET Count="+b1+" WHERE Student_ID='"+sid+"'";
		     stmt.executeUpdate(IncreaseCount);
		     String ChangeReturnStatus="UPDATE BOOKS SET ReturnStatus='ISSUED' WHERE A_no='"+ano+"'";
		     stmt.executeUpdate(ChangeReturnStatus);
	       }
 	    else if(tmp.equals("InStock") && b1==0)
 	    {
 	    	String InsertIntoIssuer ="INSERT INTO STUDENT VALUES('"+sid+"','"+sname+"','"+divi+"','"+phone+"','"+email+"','1')";
 	    	stmt.executeUpdate(InsertIntoIssuer);
 	    	String InsertIntoIssuer1 ="INSERT INTO ISSUER VALUES(?,?,?,?,?)"; 
	         PreparedStatement ps1= (PreparedStatement) con.prepareStatement(InsertIntoIssuer1);
		     ps1.setString(1, ano);
		     ps1.setString(2, cno);
		     ps1.setString(3, sid);
		     SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		     java.util.Date d=sdf.parse(idate);
			 java.sql.Date newdate =new java.sql.Date(d.getTime());
		     ps1.setDate(4, newdate);
		     java.util.Date d1=sdf.parse(rdate);
			 java.sql.Date newdate1 =new java.sql.Date(d1.getTime());
		     ps1.setDate(5, newdate1);
			 ps1.executeUpdate();
			String ChangeReturnStatus1="UPDATE BOOKS SET ReturnStatus='ISSUED' WHERE A_no='"+ano+"'";
		     stmt.executeUpdate(ChangeReturnStatus1);
 	    }
	  	 }
 	   else
 	 	 {
 	 		String message = "Book is already issued!";
 			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
 	 	 }
      } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
}
public void getbook(String Ano, Connection con)
{
	try {
		   int i=bookcount;
		   Statement stmt=con.createStatement();
		   String Selectbycno ="select C_no,A_no,Title,Author,ISBN from BOOKS WHERE A_no='"+Ano+"'";
		   ResultSet rs=stmt.executeQuery(Selectbycno);
		   for(;rs.next();i++)
		   {
			   Gui3.table.setValueAt(i+1, i, 0);
			   Gui3.table.setValueAt(rs.getString("A_no"), i, 1);
			   Gui3.table.setValueAt(rs.getString("C_no"), i, 2);
			   Gui3.cno1.setText(rs.getString("C_no"));
			   Gui3.table.setValueAt(rs.getString("Title"), i, 3);
			   Gui3.table.setValueAt(rs.getString("Author"), i, 4);
			   Gui3.table.setValueAt(rs.getString("ISBN"), i, 5);
		   }
		   bookcount=i;
		   for(;i<Gui3.table.getRowCount();i++)
		   {
			   Gui3.table.setValueAt("", i, 0);
			   Gui3.table.setValueAt("", i, 1);
			   Gui3.table.setValueAt("", i, 2);
			   Gui3.table.setValueAt("", i, 3);
			   Gui3.table.setValueAt("", i, 4);
			   Gui3.table.setValueAt("", i, 5);
		   }
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not display contents :( ");
			e.printStackTrace();
			return;
		}
	
}
public void ReIssueBook(Connection con,String ano,String cno,String idate,String rdate) throws ClassNotFoundException, ParseException
{
	   String sid=GetStudentid(con, ano,cno);
	   java.sql.Date idate1=Getissuedate(con,ano,cno);
	   String condition="";
  try { 
 	 Statement stmt=con.createStatement();
 	 ResultSet rs=stmt.executeQuery("SELECT ReturnStatus FROM BOOKS WHERE A_No='"+ano+"'");
 	 while(rs.next())
 	 {
 		 condition=rs.getString("ReturnStatus");
 	 } 
 	 if(condition.equals("ISSUED"))
 	 {
		     SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		     java.util.Date d=sdf.parse(idate);
			 java.sql.Date newdate =new java.sql.Date(d.getTime());
		     java.util.Date d1=sdf.parse(rdate);
			 java.sql.Date newdate1 =new java.sql.Date(d1.getTime());
			 InsertValuesInYC(ano, cno, sid, idate1, newdate, con);
			String IncreaseCount ="UPDATE ISSUER SET Issue_date=?, Return_date=? WHERE Student_ID=?";
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(IncreaseCount);
		    ps.setString(3, sid);
			ps.setDate(1, newdate);
			ps.setDate(2, newdate1);
		    ps.executeUpdate();
 	 }
 	 else
 	 {
 		String message = "Book is not issued yet";
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
 	 }
      } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}

}
public int ReturnBook(Connection con,String ano,String cno,String rdate) throws ClassNotFoundException, ParseException
{
	   String sid=GetStudentid(con, ano,cno);
	   String condition="";
	   java.sql.Date idate=Getissuedate(con,ano,cno);
	   java.sql.Date rtdate=Getreturndate(con,ano,cno);
	   int b1=GetBooksCount(con, sid);
	   int fine=0;
  try { 
 	 Statement stmt=con.createStatement();
 	ResultSet rs=stmt.executeQuery("SELECT ReturnStatus FROM BOOKS WHERE A_No='"+ano+"'");
	 while(rs.next())
	 {
		 condition=rs.getString("ReturnStatus");
	 } 
	 if(condition.equals("ISSUED"))
	 {
		     String ChangeReturnStatus="UPDATE BOOKS SET ReturnStatus='InStock' WHERE A_no='"+ano+"'";
		     stmt.executeUpdate(ChangeReturnStatus);
		     SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		     java.util.Date d=sdf.parse(rdate);
			 java.sql.Date newdate =new java.sql.Date(d.getTime());
			 int diff=(int) (((newdate.getTime()-rtdate.getTime()))/(24*3600*1000));
			 if(diff>0)
			 {
				 fine=diff*5;
			 }
			 else
			 {
				 fine=0;
			 }
		     InsertValuesInYC(ano, cno, sid, idate, newdate, con);
		     --b1;
		     if(b1<=0)
		     {
		    	 String Deleteissuer="DELETE FROM STUDENT WHERE Student_ID='"+sid+"'";
			     stmt.executeUpdate(Deleteissuer); 
		     }
		     else
		     {
		    	 String updatecount="UPDATE STUDENT SET Count='"+b1+"' WHERE Student_ID='"+sid+"'";
			     stmt.executeUpdate(updatecount); 
			     String Deleteissuer="DELETE FROM ISSUER WHERE A_no='"+ano+"'";
			     stmt.executeUpdate(Deleteissuer);
		     }
	 }
 	 else
 	 {
 		String message = "Book is not issued yet";
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
 	 }
      } catch (SQLException e) {
		System.out.println("ERROR: Could not display contents :( ");
		e.printStackTrace();
	}
  return fine;
}
public static ArrayList<String> gettables(Connection con)
{
	ArrayList<String> list=new ArrayList<String>();
	try {
		DatabaseMetaData md = con.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while(rs.next())
		{
			String item=rs.getString(3);
			if(item.equals("books") | item.equals("issuer") | item.equals("student"))
			{
			list.add(item);
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public static void restoreDB(String source) 
{  
	Statement stmt;
		try {
			stmt = Login.getcon().createStatement();
			String sql = "LOAD DATA LOCAL INFILE '"+source.replace("\\", "/")+"' INTO TABLE BOOKS FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'";
			stmt.execute(sql);
			setcount2();
			String message="You have a retored the books table just now..";
			JOptionPane.showMessageDialog(new JFrame(), message, "Done", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}  
public static void backupDB(String source) 
{  
	Statement stmt;
	try {
		stmt = Login.getcon().createStatement();
		String sql = "select * from BOOKS into outfile'"+source.replace("\\", "/")+"/books"+getcount1()+".txt' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'";
				stmt.executeQuery(sql);
				setcount2();
				String message="You have a backup of Books now...";
				JOptionPane.showMessageDialog(new JFrame(), message, "Done", JOptionPane.INFORMATION_MESSAGE);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}  
public int getcount()
{
	return bookcount;
}
public void setcount()
{
	bookcount=0;
}
public void setcount1()
{
	bookcount--;
}
public void setpath(String a)
{
	path=a;
}
public static int getcount1()
{
	return outputcount;
}
public static void setcount2()
{
	outputcount++;
}
}

