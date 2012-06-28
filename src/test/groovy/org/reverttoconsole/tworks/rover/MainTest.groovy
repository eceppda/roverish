package org.reverttoconsole.tworks.rover;

import groovy.util.GroovyTestCase;

/**
 * @author Jeff Hemminger
 *
 */
class MainTest extends GroovyTestCase {
	
	public void testParseInput() {
		Main main = new Main()
		def list = main.parseInput("5 5")
		assertEquals(["5","5"], list)		
		
		list = main.parseInput("MMRMMRMRRM")
		assertEquals(["M", "M", "R", "M", "M", "R", "M", "R", "R", "M"], list)
		
		list = main.parseInput("1 2 N")
		assertEquals(["1", "2", "N"], list)
	}
	
}
