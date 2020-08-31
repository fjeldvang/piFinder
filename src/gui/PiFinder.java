package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class PiFinder extends JFrame {

	double pi;
	private double x;
	private double y;
	private double distance;
	private int numPointsInCircle;
	private int numPointsTotal;
	
	PiFinder(){
		System.out.println("***PiFinder***");
		System.out.println("");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		getNumber();
	}
	
	public void paint(Graphics gr) { 
		 //super.paint(gr);
		
	 	 gr.setPaintMode();
		 int intx = (int)Math.round(x*600);
		 int inty = (int)Math.round(y*600);
		 int radius = getWidth()/2;
		 
		 //gr.setColor(Color.BLACK);
		 //int cntrX = getWidth()/2;
		 //int cntrY = getHeight()/2;
		 //gr.drawOval(cntrX-radius, cntrY-radius, radius*2, radius*2);
		 //gr.drawOval(-500, -500, radius*3, radius*3);
		 
		 //TODO: Figure out circle outline to reflect 1x1 coordinate system
		 
		 if(Math.pow(intx, 2)+Math.pow(inty, 2)<=Math.pow(getWidth(), 2)) {
			 gr.setColor(Color.green);
		 }else {
			 gr.setColor(Color.red);
		 }
		 gr.fillOval(intx, inty, radius/32, radius/32);
		 //System.out.println(intx);
		 //System.out.println(inty);
	}

	private void getNumber() {
		//TODO: input via dialog instead of scanner?
		System.out.println("Enter amount of times a coordinate will be added to estimate pi");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.close();
		calculatePi(a);
		pi = 4.0 * numPointsInCircle/numPointsTotal;
		System.out.println("Approximation of pi by trying " + a + " times equals " + pi);
	}

	private void calculatePi(int a) {
		double z = 2.0;
		Random r = new Random();
		
		for(int i=0;i<a;i++) {
			
			x = r.nextDouble();
			y = r.nextDouble();
			
			System.out.println("x = "+x);
			System.out.println("y = "+y);
			
			distance = Math.pow(x, z) + Math.pow(y, z);
			System.out.println("Distance = "+distance);
			
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
