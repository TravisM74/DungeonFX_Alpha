package World;

import java.lang.reflect.Array;

import Entity.Entity;

public class WorldLevel {
	private WorldTile[][] level;
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	
	public WorldLevel() {
		level = new WorldTile[WIDTH][HEIGHT];
		createEmptyTiles();
	}
	
	private void createEmptyTiles() {
		
		for (int i = 0; i < WIDTH; i++) {
			for(int j = 0 ; j < HEIGHT; j++) {
				
				level[i][j] = (new WorldTile());
			
			}
		}	
	}
	
	public WorldTile getWorldTile(int x,int y) {
		return level[x][y];
	}
	public void moveEntity(Entity entity, int newX , int newY) {
		level[entity.getX()][entity.getY()].removeEntity(entity);
		level[newX][newY].addEntity(entity);
		entity.setX(newX);
		entity.setY(newY);
	}

}
