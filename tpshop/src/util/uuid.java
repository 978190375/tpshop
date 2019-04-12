package util;

import java.util.UUID;

public class uuid {
		public  static void main(String[] args) {
			System.out.println(randomUUID());
		}
	 public static String randomUUID() {  
	        return UUID.randomUUID().toString();  
	    }  
}
