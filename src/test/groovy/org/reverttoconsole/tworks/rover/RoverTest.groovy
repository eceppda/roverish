/**
 * 
 */
package org.reverttoconsole.tworks.rover;

import org.reverttoconsole.tworks.rover.Rover;

import groovy.util.GroovyTestCase;

/**
 * @author Jeff Hemminger
 *
 */
class RoverTest extends GroovyTestCase {
	Rover rover = new Rover(new Point(0,0))
	
	public void testExecuteBadCommand() {
		
		def inList = ['I']
		rover.setInstructionList(inList) 
		try {
			rover.executeCommands()
			fail()
		} catch(Exception e) {
		}
	}
	
	public void testExecuteTurnCommand() {
		def inList = ['L', 'L']
		rover.setInstructionList(inList)
		rover.setHeading('N')
		rover.executeCommands()
		def outputList = rover.toString().toList()
		assertEquals 'S',outputList[outputList.size() -1]
	}
}
