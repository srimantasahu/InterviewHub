package com.kvvssut.interviews.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class ObjectOutputStreams {

	public static void main(String[] args) throws ParseException, IOException {

		List<CustomerData> customers = new LinkedList<CustomerData>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		CustomerData cdata1 = new CustomerData();
		cdata1.setCustomerName("Customer One");
		cdata1.setCustomerId(623805);
		cdata1.setDob(sdf.parse("06/09/1990"));
		customers.add(cdata1);

		CustomerData cdata2 = new CustomerData();
		cdata2.setCustomerName("Customer Two");
		cdata2.setCustomerId(623816);
		cdata2.setDob(sdf.parse("16/09/1990"));
		customers.add(cdata2);

		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("../JavaMainTesting/src/FileOS.txt"), true));

			for (CustomerData customerData : customers) {
				objectOutputStream.writeObject(customerData);			// If CustomerData doesn't implement Serializable interface, errors in java.io.NotSerializableException 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
		}
	}

}
