package com.kedb.util;

import java.text.SimpleDateFormat;

public class Util
{

	public String getQuerydate(String date)
	{
		String temp=date;
		
		temp="#"+temp+"#";
		date =temp;
		return date;
		
	}
	
	public java.sql.Date toSQlDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    java.util.Date parsed = null;
	    try {
	        parsed = sdf.parse(date);
	    } catch (Exception e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	    java.sql.Date data = new java.sql.Date(parsed.getTime());
		return data;
	 

	}
	
	public static void main(String args[])
	{
		Util u=new Util();
		System.out.println(u.toSQlDate("01/02/2014"));
		
		
		
	}
	
}
