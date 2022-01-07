package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.OutOfGridException;

public class RoverTest {

	private Rover rover;
	
	@BeforeEach
	void initializeRover() {
		rover = new Rover(1, 1, 'N');
	}
	
	@Test
	void turnWestLeft() {
		rover.rotateLeft();
		assertTrue(rover.getCardinal() == 'W');
	}
	
	@Test
	void turnSouthLeft() {
		rover.rotateLeft();
		rover.rotateLeft();
		assertTrue(rover.getCardinal() == 'S');
	}
	
	@Test
	void turnEastLeft() {
		rover.rotateLeft();
		rover.rotateLeft();
		rover.rotateLeft();
		assertTrue(rover.getCardinal() == 'E');
	}
	
	
	@Test
	void turnEastRight() {
		rover.rotateRight();
		assertTrue(rover.getCardinal() == 'E');
	}
	
	@Test
	void turnSouthRight() {
		rover.rotateRight();
		rover.rotateRight();
		assertTrue(rover.getCardinal() == 'S');
	}
	
	@Test
	void turnWestRight() {
		rover.rotateRight();
		rover.rotateRight();
		rover.rotateRight();
		assertTrue(rover.getCardinal() == 'W');
	}
	
	@Test
	void initialPosition() {
		rover.initialPosition("2 3 N");
		assertTrue(rover.getX() == 2 && rover.getY() == 3 && rover.getCardinal() == 'N');
	}
	
	@Test
	void moveForwardNorth() {
		rover.initialPosition("2 2 N");
		rover.moveForward(5, 5);
		assertTrue(rover.getX() == 2 && rover.getY() == 3);
	}
	
	@Test
	void moveForwardWest() {
		rover.initialPosition("2 2 W");
		rover.moveForward(5, 5);
		assertTrue(rover.getX() == 1 && rover.getY() == 2);
	}
	
	@Test
	void moveForwardSouth() {
		rover.initialPosition("2 2 S");
		rover.moveForward(5, 5);
		assertTrue(rover.getX() == 2 && rover.getY() == 1);
	}
	
	@Test
	void moveForwardEast() {
		rover.initialPosition("2 2 E");
		rover.moveForward(5, 5);
		assertTrue(rover.getX() == 3 && rover.getY() == 2);
	}
	
	@Test
	void explore() {
		rover.initialPosition("1 2 N");
		rover.explore("LMLMLMLMM", 5, 5);
		assertTrue(rover.getX() == 1 && rover.getY() == 3 && rover.getCardinal() == 'N');
	}
	
	@Test
	void isFinalized() {
		assertFalse(rover.isFinalized());
		rover.initialPosition("1 2 N");
		rover.explore("LMLMLMLMM", 5, 5);
		assertTrue(rover.isFinalized());
	}
	
	
}
