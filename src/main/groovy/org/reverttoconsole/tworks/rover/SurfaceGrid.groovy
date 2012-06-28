package org.reverttoconsole.tworks.rover;

public interface SurfaceGrid {
	
	public boolean canOccupy(Point point)
	
	public boolean occupy(Rover rover)
	
	public boolean leave(Rover rover)
	
}
