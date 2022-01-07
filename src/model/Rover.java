package model;

import exception.OutOfGridException;

public class Rover {

	private int x;
	private int y;
	private char cardinal;
	private boolean finalized = false;


	public Rover(int x, int y, char cardinal) {
		this.x = x;
		this.y = y;
		this.cardinal = cardinal;
	}

	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getCardinal() {
		return cardinal;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void initialPosition(String roverPos) {
		x = Character.getNumericValue(roverPos.charAt(0));
		y = Character.getNumericValue(roverPos.charAt(2));
		cardinal = roverPos.charAt(4);
	}
	
	public void rotateLeft() {
		switch (cardinal) {
		case 'N':
			cardinal = 'W';
			break;
		case 'W':
			cardinal = 'S';
			break;
		case 'S':
			cardinal = 'E';
			break;
		case 'E':
			cardinal = 'N';
			break;
		}
	}
	
	public void rotateRight() {
		switch (cardinal) {
		case 'N':
			cardinal = 'E';
			break;
		case 'E':
			cardinal = 'S';
			break;
		case 'S':
			cardinal = 'W';
			break;
		case 'W':
			cardinal = 'N';
			break;
		}
	}
	
	public void moveForward(int maxGridX, int maxGridY) {
		switch (cardinal) {
		case 'N':
			y += 1;
			break;
		case 'E':
			x += 1;
			break;
		case 'S':
			y -= 1;
			break;
		case 'W':
			x -= 1;
			break;
		}
		
		if (x > maxGridX || y > maxGridY) {
			throw new OutOfGridException();
		}
	}
	
	public void explore(String path, int maxGridX, int maxGridY) {
		int size = path.length();
		for (int i = 0; i < size; i++) {
			if (path.charAt(i) == 'L') {
				rotateLeft();
			} else if (path.charAt(i) == 'R') {
				rotateRight();
			} else if (path.charAt(i) == 'M') { 
				try {
					moveForward(maxGridX,maxGridY);					
				} catch (OutOfGridException outOfGrid) {
					System.out.println("The rover crossed the boundaries of the plateau. Turning back...");
					if (x > maxGridX) {
						x -= 1;
					} else if (y > maxGridY) {
						y -= 1;
					}
				}
			}	else {
				System.out.println("Incorrect input " + path.charAt(i) + ". Skipping command...");
			}
		}
		finalized = true;
	}

	@Override
	public String toString() {
		return "Rover's final coordinates and heading: " 
				+ x 
				+ " " 
				+ y 
				+ " " 
				+ cardinal;
	}	
	
	
	
	
	
	
	
}
