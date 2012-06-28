/**
 * 
 */
package org.reverttoconsole.tworks.rover

/**
 * @author Jeff Hemminger
 *
 */
class Rover {
	
	List<String> instructionList
	String heading
	Point currentPosition
	SurfaceGrid grid
	Compass compass = new Compass()	
	public Rover(Point currentPosition) {
		this.currentPosition = currentPosition
	}
	
	public Rover(List heading, List instructions, SurfaceGrid grid) {
		super();
		parseHeading(heading)
		this.instructionList = instructions
		this.grid = grid
		if(this.grid.canOccupy(this.currentPosition)) {
			this.grid.occupy this
		} else {
			throw new RuntimeException("Cannot deploy rover at: " + this.currentPosition)
		}
	}
	
	private void parseHeading(List heading) {
		this.currentPosition = new Point(heading[0], heading[1])
		this.heading = heading[2]
	}
	
	public void executeCommands() {
		for (String instruction : instructionList) {
			switch(instruction) {
				case "L":
					this.heading = this.compass.leftTurn(this.heading)
					break
				case "R":
					this.heading = this.compass.rightTurn(this.heading)
					break
				case "M":
					move()
					break
				default:
					throw new RuntimeException("Unknown instruction: " + instruction)
			}
		}
	}
	
	public void move() {
		def proposedX = this.currentPosition.xAxis
		def proposedY = this.currentPosition.yAxis
		switch(this.heading) {
			case "N":
				proposedY++
				break
			case "S":
				proposedY--
				break
			case "E":
				proposedX++
				break
			case "W":
				proposedX--
				break
		}
		if(this.grid.canOccupy(new Point(proposedX, proposedY))) {
			this.grid.leave this
			this.currentPosition = new Point(proposedX, proposedY)
			this.grid.occupy this
		} else {
			print "Unable to occupy!"
		}
	}	
	@Override
	public String toString() {
		return this.currentPosition.toString() + " " + heading
	}
}
