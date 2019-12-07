package org.mailer.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.mailer.object.Contact;
import org.mailer.persistance.ContactPersistance;

public class ContactService {
	
	private ContactPersistance contactPersistance;
	
	public ContactPersistance getContactPersistance() {
		return contactPersistance;
	}

	public void setContactPersistance(ContactPersistance contactPersistance) {
		this.contactPersistance = contactPersistance;
	}

	public List<Contact> getAllContacts(long uploadedBy) {
		return contactPersistance.getAllContacts(uploadedBy);
	}

	public boolean addContact(long uploadedBy, String emailAddress, String firstName,
			String lastName, String gender) throws NoSuchAlgorithmException {
		return contactPersistance.addContact(uploadedBy, emailAddress, firstName, lastName, gender);
	}

	public void deleteContact(List<String> idList, long uploadedBy) {
		contactPersistance.deleteContact(idList, uploadedBy);
	}

	public String uploadContacts(long uploadedBy, Workbook workbook) throws NoSuchAlgorithmException {
		String errorMsg = "";
		Sheet sheet = workbook.getSheet(0);
		int rowNum = sheet.getRows();
		int colNum = sheet.getColumns();
		if(colNum != 4) {
			errorMsg = "The excel you uploaded, contains invalid number of columns.\n" +
					"There should be four columns- Email , Firstname, Lastname and Gender (M or F).";
			return errorMsg;
		}
		Cell cell = null;
		String strArray[] = new String[4];
		for(int row = 1; row < rowNum; row++)	{
			for(int column = 0; column < 4; column++)	{
				cell = sheet.getCell(column,row);
				strArray[column] = cell.getContents();
			}
			if(!addContact(uploadedBy, strArray[0], strArray[1], strArray[2], strArray[3])) {
				errorMsg = errorMsg.concat("Invalid content at row: " + row + "\n");
			}
			strArray[0]="";strArray[1]="";strArray[2]="";strArray[3]="";
			cell = null;
		}
		return errorMsg;
	}

}
