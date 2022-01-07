package vision;

import java.util.Scanner;

import model.Rover;

public class Plateau {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Please enter the upper right coordinates of the plateau: ");
		String maxGrid = sc.nextLine().trim();
		
		int maxGridX = Character.getNumericValue(maxGrid.charAt(0));
		int maxGridY = Character.getNumericValue(maxGrid.charAt(2));
		
		System.out.println("Please enter the initial coordinate of the first rover: ");
		String roverPos = sc.nextLine().trim();
		
		Rover rover1 = new Rover(0, 0, 'N');
		Rover rover2 = new Rover(0, 0, 'N');
		
		rover1.initialPosition(roverPos);
		
		System.out.println("Please enter the path of the first rover: ");
		String roverPath = sc.nextLine();
		rover1.explore(roverPath, maxGridX, maxGridY);
		System.out.println(rover1.toString());
		
		if (rover1.isFinalized()) {
			System.out.println("\nPlease enter the initial coordinate of the second rover: ");
			roverPos = sc.nextLine().trim();
			rover2.initialPosition(roverPos);
			System.out.println("Please enter the path of the second rover: ");
			roverPath = sc.nextLine();
			rover2.explore(roverPath, maxGridX, maxGridY);
			System.out.println(rover2.toString());
		}
		
		sc.close();

	}

}
