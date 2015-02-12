package dbconsole;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconsole.MySQL;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FrameSystemView extends Frame implements ActionListener,WindowListener{


	private Button button1 = new Button("push");
	CardLayout cardlayout;
	Panel panel;
	Panel btnpanel;
	

	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		panel =new Panel();
		btnpanel = new Panel();
		addWindowListener(this);
		setTitle("Graph");
		cardlayout= new CardLayout();
		setLayout(cardlayout);
		btnpanel.add(button1,BorderLayout.CENTER);
		add(btnpanel); 
		add(panel); 
		button1.addActionListener(this); 

		

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1){
			int  total,grade;
			
			ResultSet rs;
			MySQL mysql = new MySQL();
			rs = mysql.selectAll();
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			try {
				
				while(rs.next()){
				grade = rs.getInt("grade");
			    total = rs.getInt("total");
			    data.addValue(total,"total",""+grade); 
	 			panel.add(new Label("grade:"+grade+"total:"+total)); 
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			    JFreeChart chart = 
			      ChartFactory.createLineChart("PartTimeJobStudents",
			                                   "grade",
			                                   "number",
			                                   data,
			                                   PlotOrientation.VERTICAL,
			                                   true,
			                                   false,
			                                   false);

			    ChartPanel cpanel = new ChartPanel(chart);
			    panel.add(cpanel);
			    cardlayout.next(this);

		}
	}

}

