/**
 * 
 */
package org.reverttoconsole.tworks.rover


/**
 * @author Jeff Hemminger
 *
 */
class Main {
	
	static void main(args) {
		def cli = new CliBuilder(usage: 'groovy -i inputfile')
		cli.with {
			h longOpt: 'help', 'usage information'
			i longOpt: 'input', 'inputfile', args: 1
		}
		
		def opt = cli.parse(args)
		
		
		if(opt.h) {
			cli.usage()
		} else if( opt.i ) {	
			Main main = new Main()
			def testfile = new File(opt.i)
			def count = 1
			SurfaceGrid grid = null
			List coordinates = null
			List instructions = null
			testfile.eachLine{ line->
				if(count == 1) {
					grid = main.initGrid(main.parseInput(line.toString()))
					count++
				} else if((count % 2) == 0 ){
					count++
					coordinates = main.parseInput(line.toString())
				} else {
					count++
					instructions = main.parseInput(line.toString())
					if(grid && coordinates && instructions) {
						Rover rover = new Rover(coordinates, instructions, grid)
						rover.executeCommands()
						println rover
					}
				}
				
			}
		} else {
			cli.usage()
		}
		
		
	}
	
	public List parseInput(String input) {
		List<String> tokenized = input.tokenize()
		if(tokenized.size() > 1) {
			return tokenized
		} else {
			String single = tokenized[0]
			return single.toList()
		}
	}
	
	public SurfaceGrid initGrid(List coordinates) {
		
		if(coordinates.size() == 2) {
			return new Plateau(new Point(coordinates?.get(0), coordinates?.get(1)))
		} else {
			throw new RuntimeException("Plateau coordinates must contain two points, received: " + coordinates.size())
		}
	}
}
