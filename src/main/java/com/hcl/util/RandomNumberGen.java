package com.hcl.util;

import java.util.Random;

public class RandomNumberGen {
	

public static Long getUserIdNumber(){
	Random rand = new Random();
    String id = String.format("%06d", rand.nextInt(10000));
    long num = Long.parseLong(id);
    return num;
}
public static Long getAccountNumber(){
	Random rand = new Random();
    String id = String.format("%01d", rand.nextInt(100000000));
    long num = Long.parseLong(id);
    return num;
}
public static String getPassWord(String name){
	Random rand = new Random();
    String id = String.format("%06d", rand.nextInt(10000));    
    String password = name.substring(0, 2) + id;
    return password;
}

}
