package com.vp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import  java.sql.ResultSet;		
import java.sql.SQLException;

public class GetFromDB 
{
	WebDriver driver;
	
	public GetFromDB()
	{
		
	}
	
	//"databasename=VP_Web_Live_BookingPages;integratedSecurity=true";
//	String DBUrl = "jdbc:sqlserver://172.16.0.5:1433;databasename=VP_Web_Live_BookingPages";
//	String username = "sa";
//	String password = "ash@vp8";

	String DBUrl = "jdbc:sqlserver://46.37.176.33:1334;databasename=VP_Web_Live_B";
	String username = "ashtest";
	String password = "VdTmTg8W2";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String SQLquery = null;
		
	public ResultSet getdata(String SQLquery) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try
		{
			con = DriverManager.getConnection(DBUrl,username,password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);
			return rs;
		}
		catch(Exception e)
		{
			System.out.println("Error in connection :"+e.getMessage());
			
			return null;
		}
	}
	public void closeDBConn() throws SQLException
	{
		con.close();
	}
	public String getSelectableDest() throws SQLException, ClassNotFoundException
	{
		ArrayList<String> CentreLst = new ArrayList<String>();
		SQLquery = "Select CentreName from dbo.TblCentre";
		rs = getdata(SQLquery);
		while (rs.next())
		{			
			CentreLst.add(rs.getString("CentreName"));
		}
		closeDBConn();
		Random ran = new Random();
		int index = ran.nextInt(CentreLst.size());
		return CentreLst.get(index);
	}
	public String getCenterCode(String DesttoSelect) throws ClassNotFoundException, SQLException
	{
		String centerCode = null;
		SQLquery = "SELECT Centre  from  dbo.TblCentre where CentreName = '" + DesttoSelect + "'";
        rs = getdata(SQLquery);
		while (rs.next())
		{	
			centerCode = rs.getString("Centre");
		}
		return centerCode;	
	}
	public String getSelectableDate(String centerCode, String EndDate) throws ClassNotFoundException, SQLException
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		ArrayList<String> DateLst = new ArrayList<String>();
		SQLquery = "exec dbo.QAsp_GetAvailableDates @strCentre='" + centerCode + "', @StartDate='" + StartDate + "',@EndDate='" + EndDate + "'";
		rs = getdata(SQLquery);
		while (rs.next())
		{			
			DateLst.add(rs.getString("WeekStart"));
		}
		closeDBConn();
		Random ran = new Random();
		int index = ran.nextInt(DateLst.size());
		String DatetoSelect = DateLst.get(index-1);
		return DatetoSelect;
		
	}
	
}


