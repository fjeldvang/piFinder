package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PiFinder extends JFrame {
	
	//TODO: menubar

	private double pi;
	private int a;
	private double x;
	private double y;
	private double distance;
	private int numPointsInCircle;
	private int numPointsTotal;
	
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
		 int intx = (int)Math.round(this.x*getWidth());
		 int inty = (int)Math.round(this.y*getHeight());
		 int radius = getWidth()/2;
		 
		 //draw outline
		 gr.setColor(Color.BLACK);
		 gr.drawOval(-getWidth(), -getHeight(), radius*4, radius*4);
		 
		 //decide if x^2 + y^2 coordinates within circle
		 if(Math.pow(intx, 2)+Math.pow(inty, 2)<=Math.pow(getWidth(), 2)) {
			 gr.setColor(Color.BLUE);
		 } 
		 else {
			 gr.setColor(Color.RED);
		 }
		 //draw coordinate
		 gr.fillOval(intx, inty, radius/128, radius/128);
	}

	private void getNumber() {
		System.out.println("Enter amount of times a coordinate will be added to estimate pi");
		
		//get from inputdialog
		getInteger();		
		
		//make coordinate calculations
		calculateCoordinates(this.a);
		
		//calculate pi
		this.pi = 4.0 * this.numPointsInCircle/this.numPointsTotal;
		System.out.println("Approximation of pi by trying " + this.a + " times equals " + this.pi);

		JFrame compl = new JFrame();
	    JOptionPane.showMessageDialog(compl, "Complete!\n" + "Approximation of pi by trying " + this.a + " times equals " + this.pi);
	}

	private void getInteger() {
		JFrame in = new JFrame();
		String s;
		
		try {
			//get from input dialog
			s = (String) JOptionPane.showInputDialog(
				in,
                "Enter amount of times a coordinate will be added to estimate pi",
                "PiFinder", 
                JOptionPane.PLAIN_MESSAGE,
                null,
                null, 
                null);
			if(s == null) {
				System.exit(0);
			} else {
			this.a = Integer.parseInt(s);
			}
		}
		catch(NumberFormatException e) {
			//try again
			System.out.println("Input is not an integer, please try again.");
			JFrame fn = new JFrame();
		    JOptionPane.showMessageDialog(fn, "Input is not an integer, please try again.");
			System.exit(0);
		}
		in.dispose();
	}

	private void calculateCoordinates(int a) {
		double z = 2.0;
		Random r = new Random();
		
		for(int i=0;i<a;i++) {
			
			//get random coordinates
			this.x = r.nextDouble();
			this.y = r.nextDouble();
			
			System.out.println("x = "+this.x);
			System.out.println("y = "+this.y);
			
			this.distance = Math.pow(Math.pow(this.x, z) + Math.pow(this.y, z),z);
			System.out.println("Distance = "+this.distance);
			
			//find if inside circle or not
			if(this.distance<=1) {
				this.numPointsInCircle++;
				System.out.println("Number inside");
				System.out.println("");
			} 
			else {
				System.out.println("Number outside");
				System.out.println("");
			}
			this.numPointsTotal++;
			this.repaint();
		}

	}
	
}
