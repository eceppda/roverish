/**
 * 
 */
package org.reverttoconsole.tworks.rover

import java.util.HashMap;

/**
 * @author Jeff Hemminger
 *
 */
class Compass {
	
	private HashMap<String, String> leftHeadingMap;
	private HashMap<String, String> rightHeadingMap;
	
	public Compass() {
		this.leftHeadingMap = new HashMap<String, String>()
		this.rightHeadingMap = new HashMap<String, String>()
		this.leftHeadingMap.put "N", "W"
		this.leftHeadingMap.put "W", "S"
		this.leftHeadingMap.put "S", "E"
		this.leftHeadingMap.put "E", "N"
		this.rightHeadingMap.put "N", "E"
		this.rightHeadingMap.put "E", "S"
		this.rightHeadingMap.put "S", "W"
		this.rightHeadingMap.put "W", "N"
	}
	
	public String leftTurn(String currentHeading) {
		if(this.leftHeadingMap.containsKey(currentHeading)) {
			return this.leftHeadingMap.get(currentHeading)
		} else {
			throw new RuntimeException("Unknown heading: " + currentHeading)
		}
	}
	
	public String rightTurn(String currentHeading) {
		if(this.rightHeadingMap.containsKey(currentHeading)) {
			return this.rightHeadingMap.get(currentHeading)
		} else {
			throw new RuntimeException("Unknown heading: " + currentHeading)
		}		
	}
}
