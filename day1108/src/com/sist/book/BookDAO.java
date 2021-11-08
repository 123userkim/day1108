package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

 

public class BookDAO {

	
	//출판사의 이름을 매개변수로 전달받아, 출판사의 모든 도서목록를 검색하여 --로 반환하는 메소드를 만드시오 (ArrayList)
	
	
	public ArrayList<BookVO> searchBook(String publisher){
		Scanner sc= new Scanner(System.in);
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where publisher =? order by price desc";
 
		String driver= "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.10.68:1521:XE";
		String userName = "c##madang";
	    String passWord = "madang";
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
 
		
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(0, publisher);
			
			rs= pstmt.executeQuery();
			int bookid=0;
			String bookname = "";
			 publisher="";
			int price =0;
		 
						
			while(rs.next()) {
			 bookid =rs.getInt(1);
			 price =rs.getInt(4);
			 publisher = rs.getString(3);
			 bookname =rs.getString(2);
			 
			BookVO b = new BookVO(bookid, bookname, publisher, price);
				list.add(b); 
			 
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
		return list;
	 
}
}