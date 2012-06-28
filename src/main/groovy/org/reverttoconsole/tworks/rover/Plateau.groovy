/**
 * 
 */
package org.reverttoconsole.tworks.rover

/**
 * @author Jeff Hemminger
 *
 */
class Plateau implements SurfaceGrid {
	
	private HashMap<Point, Rover> occupiedPoints
	private Point maxGridPoint	
	public Plateau(Point point) {
		super();
		this.maxGridPoint = point;
		this.occupiedPoints = new HashMap<String, Rover>()
	}
	
	public boolean canOccupy(Point point) {
		if((point.xAxis >= 0 && point.xAxis <= maxGridPoint.xAxis) && (point.yAxis >= 0 && point.yAxis <=maxGridPoint.yAxis)) {
			return !this.occupiedPoints.containsKey(point)
		} else {
			throw new RuntimeException("Proposed coordinate is not on plateau!")
		}
	}
	
	public boolean occupy(Rover rover) {
		if(canOccupy(rover.getCurrentPosition())) {
			this.occupiedPoints.put(rover.getCurrentPosition(), rover)
			return true
		} else {
			throw new RuntimeException("Space is occupied!")
		}
	}
	
	public boolean leave(Rover rover) {
		if(this.occupiedPoints.containsKey(rover.getCurrentPosition())) {
			this.occupiedPoints.removeEntryForKey rover.getCurrentPosition()
		} else {
			throw new RuntimeException("Plateau is out of sync with rover: " + rover)
		}
	}
	
}
