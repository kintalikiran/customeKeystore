package com.mssql.sqlserver.keystore;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionCertificateStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLServerColumnEncryptionKeyStoreProvider storeProvider = new SQLServerColumnEncryptionCertificateStoreProvider();
		
		Class obj = storeProvider.getClass();
		
		// get name of the class
	      String name = obj.getName();
	      System.out.println("Name: " + name);

	      // get the access modifier of the class
	      int modifier = obj.getModifiers();

	      // convert the access modifier to string
	      String mod = Modifier.toString(modifier);
	      System.out.println("Modifier: " + mod);

	      // get the superclass of Dog
	      Class superClass = obj.getSuperclass();
	      System.out.println("Superclass: " + superClass.getName());
	      
	      // Getting methods of the class through the object 
	        // of the class by using getMethods 
	        Method[] methods = obj.getMethods();
	        
	     // Printing method names 
	        for (Method method:methods) 
	            System.out.println(method.getName()); 

	}

}
