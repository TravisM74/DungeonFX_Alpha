package Control;

import Entity.Entity;
import Entity.EntityEnum;
import World.WorldLevel;
import World.WorldTile;

public class InteractionTest {
	private Entity player;
	private WorldLevel world;
	
	public InteractionTest(Entity player, WorldLevel world) {
		WorldTile tile = world.getWorldTile(player.getX(), player.getY());
		for(Entity entity:tile.getAllEntities()) {
			if (entity.getEntityType().equals(EntityEnum.ENEMY)) {
				System.out.println("Enemy found");
				
			}
		}
	}

}
