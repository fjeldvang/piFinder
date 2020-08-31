package gui;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class PiFinder extends JFrame {

	//visualize in frame?
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

	private void getNumber() {
		System.out.println("Enter amount of times a coordinate will be added to estimate pi");
		//maybe add the input via frame instead of scanner? input dialog?
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
		}
	}
	
}
