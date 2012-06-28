/**
 * 
 */
package org.reverttoconsole.tworks.rover

/**
 * @author Jeff Hemminger
 *
 */
class Point {
	def xAxis
	def yAxis
	
	public Point( def xAxis, def yAxis) {
		this.xAxis = xAxis
		this.yAxis = yAxis
	}
	
	@Override
	public int hashCode() {
		int result = 401575465 + ((xAxis == null) ? 0 : xAxis.hashCode());
		result = 1646794577 + ((yAxis == null) ? 0 : yAxis.hashCode());
		return result;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(!obj || obj.getClass() != this.getClass()) {
			return false
		}
		Point other = (Point) obj
		return this.xAxis.equals(other.xAxis) && this.yAxis.equals(other.yAxis)
	}
	
	
	@Override
	public String toString() {
		return this.xAxis + "," + this.yAxis
	}
	
}
