package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.UserModel;
import models.Users;

public class DataXL {
	public static List<UserModel> getUsersObj() {
		InputStream in = null;
		XSSFWorkbook wb = null;
		Users users = new Users();
		List<UserModel> usersList = new ArrayList();
		try {
			in = new FileInputStream("src/main/java/testdata/users.xlsx");
			wb = new XSSFWorkbook(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				Cell cell2 = cells.next();
				usersList.add(new UserModel(cell.getStringCellValue(), cell2.getStringCellValue()));
			}
			users.setUsers(usersList);
		}
		return users.getUsers();

	}
}
