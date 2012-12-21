package com.padavala.loom.others;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MySerializable mySerializable = new MySerializable(1, "Murali");
		try {
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos); 
		    oos.writeObject(mySerializable);
		    oos.flush(); 	
		    oos.close(); 
		    bos.close();
			byte[] byteArray = bos.toByteArray ();
		
		
			ByteArrayInputStream bis = new ByteArrayInputStream (byteArray);
			ObjectInputStream ois = new ObjectInputStream (bis);
			MySerializable  obj = (MySerializable)ois.readObject();
			System.out.println(obj.getId());
			System.out.println(obj.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
