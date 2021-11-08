package com.sist.book;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.sist.dept.DeptDAO;
 
public class SearchBookGUI extends JFrame{

 JTextField jtf_publisher;
 static JFrame f;
BookDAO dao;
 Vector colNames;
 Vector<Vector> rowData;
JTable table;
	
	public SearchBookGUI() {
				
				
		table= new JTable(rowData, colNames);
		
		f = this;
		dao = new BookDAO();
		
		jtf_publisher = new JTextField(20);
		 
		
		colNames = new Vector();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("출판사");
		colNames.add("가격");
		
		rowData = new Vector<Vector>();
		
		table= new JTable(rowData, colNames);		
		
		JPanel p_input = new JPanel();
		 p_input.add(jtf_publisher);
		
		add(p_input); 
		
		JButton btn_search = new JButton("검색");
		 
		add(btn_search);
		 
		JPanel p_center = new JPanel();
		
		p_center.setLayout(new BorderLayout());
		p_center.add(p_input, BorderLayout.CENTER);
		p_center.add(btn_search, BorderLayout.SOUTH);
		
		JScrollPane jsp = new JScrollPane(table);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
 
				
			}});
		
			}
	
	 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		new SearchBookGUI();

}
}
