package com.hcl.util;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class DateUtil {

public static Date dateconvert(Date date)	{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    try {  
        Date dateformated = formatter.parse(date.toString());  
        System.out.println("Date is: "+dateformated);  
        return dateformated;
    } catch (ParseException e) {e.printStackTrace();}
	return null;  
}  
}

