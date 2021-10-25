package com.kvvssut.interviews.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//	import java.util.List;

public class ObjectInputStreams {

	public static void main(String[] args) {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(new File("../JavaMainTesting/src/FileOS.txt")));

			CustomerData cdata1 = (CustomerData) objectInputStream.readObject();
			System.out.println(cdata1.toString());
			
			CustomerData cdata2 = (CustomerData) objectInputStream.readObject();
			System.out.println(cdata2.toString());
			
			
			//			List<CustomerData> customers = (List<CustomerData>) objectInputStream.readObject();
			//			for (CustomerData customerData : customers) {
			//				System.out.println(customerData.toString());
			//			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
