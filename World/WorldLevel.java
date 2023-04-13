package World;

import java.lang.reflect.Array;

import Entity.Entity;

public class WorldLevel {
	private WorldTile[][] level;
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	
	public WorldLevel() {
		level = new WorldTile[WIDTH][HEIGHT];
	}
	public WorldTile getWorldTile(int x,int y) {
		return level[x][y];
	}

}
