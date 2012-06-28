/**
 * 
 */
package org.reverttoconsole.tworks.rover;

import org.reverttoconsole.tworks.rover.Plateau;
import org.reverttoconsole.tworks.rover.Rover;

import groovy.util.GroovyTestCase;

/**
 * @author Jeff Hemminger
 *
 */
class PlateauTest extends GroovyTestCase {
	
	Plateau plateau
	
	/**
	 * Test method for {@link org.reverttoconsole.thoughtworks.rover.Plateau#canOccupy(java.lang.Object, java.lang.Object)}.
	 */
	public void testCanOccupy() {
		plateau = new Plateau(new Point(5,5))
		assertTrue(plateau.canOccupy(new Point(1, 2)))
		assertTrue(plateau.canOccupy(new Point(0, 0)))
		assertTrue(plateau.canOccupy(new Point(5, 5)))
		try {
			plateau.canOccupy(new Point(5, 6))
			fail()
		} catch(Exception e) {
			
		}
		
	}
	
	/**
	 * Test method for {@link org.reverttoconsole.thoughtworks.rover.Plateau#occupy(java.lang.Object, java.lang.Object, org.reverttoconsole.thoughtworks.rover.Rover)}.
	 */
	public void testOccupy() {
		plateau = new Plateau(new Point(1,2))
		assertTrue(plateau.occupy(new Rover(new Point(1,0))))
		try {
			plateau.occupy(new Rover(new Point(1,0)))
			fail()
		} catch(Exception e) {
			
		}
		assertTrue(plateau.occupy(new Rover(new Point(0,0))))
	}
	
}
