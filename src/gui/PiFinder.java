package gui;

import java.util.Scanner;

import javax.swing.JFrame;

public class PiFinder extends JFrame {

	//visualize in frame?
	
	PiFinder(){
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		getNumber();
	}

	private void getNumber() {
		System.out.println("Enter amount of times a coordinate will be added to estimate pi");
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.close();
		
	}
}
