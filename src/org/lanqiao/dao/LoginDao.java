package org.lanqiao.dao;


import java.sql.*;

import org.lanqiao.entity.Login;

	public class LoginDao {
//		public int login(String name,String pwd)//1:��¼�ɹ�   0����¼ʧ�ܣ��û�������������  -1��ϵͳ�쳣
		public int login(Login login)//1:��¼�ɹ�   0����¼ʧ�ܣ��û�������������  -1��ϵͳ�쳣
		{
			
			Connection connection = null;
			Statement stmt = null;
			ResultSet rs = null ; 
			try {
				// a.�������������ؾ����������
				Class.forName("com.mysql.jdbc.Driver");// ���ؾ����������
				// b.�����ݿ⽨������
				connection = DriverManager.getConnection("jdbc:mysql:"
						+ "//localhost:3306/mydatabase", "root", "123");
				System.out.println("���ݿ����ӳɹ�");
				// c.����sql��ִ��(���顿)
				stmt = connection.createStatement();
				
			//	String name = request.getParameter("uname") ;
			//	String pwd = request.getParameter("upwd") ;
				
				String sql = "select count(*) from login where uname='"+login.getName()+"' and upwd ='"+login.getPwd()+"' " ;
				rs = stmt.executeQuery(sql); // ����ֵ��ʾ ��ɾ�� ��������
				// d.������
				int count = -1;
				if(rs.next()) {
					count = rs.getInt(1) ;
				}
//				if(count>0) {
//					out.println("��½�ɹ���");
//				}else {
//					out.println("��½ʧ�ܣ�");
//				}
				return count ;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return -1 ;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1 ;
			} catch(Exception e) {
				e.printStackTrace();
				return -1 ;
			}
			finally {
				try {
					if(rs!=null) rs.close(); 
					 if(stmt!=null) stmt.close();// ����.����
					 if(connection!=null)connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


