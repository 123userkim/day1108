package com.sist.book;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class SearchBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		String sql="select * from book where publisher =? order by price desc";
		
		String driver= "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.10.68:1521:XE";
		String userName = "c##madang";
	    String passWord = "madang";
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String keyword="";
		System.out.println("검색할 출판사 명을 입력");
		keyword= sc.next();
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1,keyword);
			
			rs= pstmt.executeQuery();
			int bookid=0;
			String bookname = "";
			String publisher="";
			int price =0;
			System.out.println("도서번호\t도서명\t출판사\t가격");
						
			while(rs.next()) {
			 bookid =rs.getInt(1);
			 price =rs.getInt(4);
			 publisher = rs.getString(3);
			 bookname =rs.getString(2);
			System.out.printf(bookid+"\t"+bookname +"\t"+publisher+"\t"+price);	
			}
			
		}catch(Exception e ) {
			
		}finally{			
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
					if(rs !=null) {
						rs.close();
					}
			}catch(Exception e) {
				
			}	
	}
}
}
