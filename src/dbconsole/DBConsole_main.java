package dbconsole;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbconsole.FrameSystemController;
import dbconsole.FrameSystemView;


public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total,grade;
		ResultSet rs;
		
		MySQL mysql = new MySQL();

		rs = mysql.selectAll();
		
		try {
			while(rs.next()){
				grade = rs.getInt("grade");
				total = rs.getInt("total");
				
	            } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
					} 
		FrameSystemController controller = new FrameSystemController();
		FrameSystemView frame = new FrameSystemView(controller);
		frame.setBounds(5,5,655,455);
		frame.setVisible(true);



	}

}
