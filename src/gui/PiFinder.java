package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PiFinder extends JFrame {
	
	//TODO: fix 

	private double pi;
	private int a;
	private double x;
	private double y;
	private double distance;
	private int numPointsInCircle;
	private int numPointsTotal;
	private int c;
	
	public PiFinder(){
		System.out.println("***PiFinder***");
		System.out.println("");
		
		//setup frame
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//get number from input dialog
		getNumber();
	}
	
	public void paint(Graphics gr) { 
		 //super.paint(gr);
	 	 gr.setPaintMode();
	 	 
	 	 //convert double coordinate to closest pixel
		 int intx = (int)Math.round(x*getWidth());
		 int inty = (int)Math.round(y*getHeight());
		 int radius = getWidth()/2;
		 
		 //draw outline
		 gr.setColor(Color.BLACK);
		 gr.drawOval(-getWidth(), -getHeight(), radius*4, radius*4);
		 
		 //decide if x^2 + y^2 coordinates within circle
		 if(Math.pow(intx, 2)+Math.pow(inty, 2)<=Math.pow(getWidth(), 2)) {
			 gr.setColor(Color.green);
		 } 
		 else {
			 gr.setColor(Color.red);
		 }
		 //draw coordinate
		 gr.fillOval(intx, inty, radius/128, radius/128);
	}

	private void getNumber() {
		System.out.println("Enter amount of times a coordinate will be added to estimate pi");
		
		//get from inputdialog
		getInteger();		
		
		//make coordinate calculations
		calculateCoordinates(a);
		
		//calculate pi
		pi = 4.0 * numPointsInCircle/numPointsTotal;
		System.out.println("Approximation of pi by trying " + a + " times equals " + pi);
	}

	private void getInteger() {
		JFrame in = new JFrame();
		try {
		c = Integer.parseInt((String) JOptionPane.showInputDialog(
				in,
                "Enter amount of times a coordinate will be added to estimate pi",
                "PiFinder", 
                JOptionPane.PLAIN_MESSAGE,
                null,
                null, 
                null));
		}
		catch(NumberFormatException e) {
			System.out.println("Input is not an integer, please try again");
			JFrame fn = new JFrame();
		    JOptionPane.showMessageDialog(fn, "Input is not an integer, please try again");
			getInteger();
		}
		setInt(c);
		in.dispose();
	}

	private void setInt(int c) {
		this.a = c;
	}

	private void calculateCoordinates(int a) {
		double z = 2.0;
		Random r = new Random();
		
		for(int i=0;i<a;i++) {
			
			//get random coordinates
			x = r.nextDouble();
			y = r.nextDouble();
			
			System.out.println("x = "+x);
			System.out.println("y = "+y);
			
			distance = Math.pow(Math.pow(x, z) + Math.pow(y, z),z);
			System.out.println("Distance = "+distance);
			
			//find if inside circle or not
			if(distance<=1) {
				numPointsInCircle++;
				System.out.println("Number inside");
				System.out.println("");
			} 
			else {
				System.out.println("Number outside");
				System.out.println("");
			}
			numPointsTotal++;
			this.repaint();
		}
	}
	
}
