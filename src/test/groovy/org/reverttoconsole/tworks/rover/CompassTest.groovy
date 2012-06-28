/**
 * 
 */
package org.reverttoconsole.tworks.rover;

import org.reverttoconsole.tworks.rover.Compass;

import groovy.util.GroovyTestCase;

/**
 * @author Jeff Hemminger
 *
 */
class CompassTest extends GroovyTestCase {
	
	private Compass compass = new Compass()
	
	
	public void testLeftTurn() {
		String newHeading = compass.leftTurn("N")
		assertEquals "W", newHeading
	}
	
	public void testRightTurn() {
		String newHeading = compass.rightTurn("N")
		assertEquals "E", newHeading		
	}
	
	public void testLeftTurnBad() {
		try {
			String newHeading = compass.leftTurn("I")
			fail()
		} catch(Exception e) {
			
		}
	}
	
	public void testRightTurnBad() {
		try {
			String newHeading = compass.rightTurn("I")
			fail()
		} catch(Exception e) {
			
		}
	}	
	
}