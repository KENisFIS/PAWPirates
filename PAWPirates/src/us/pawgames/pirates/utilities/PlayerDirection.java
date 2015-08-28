package us.pawgames.pirates.utilities;

import org.bukkit.entity.Player;

public class PlayerDirection {
	public String getPlayerDirection(Player player) {
		double facingX = (player.getLocation().getYaw() - 180.0F) % 360.0F;
		if(facingX < 0.0D) {
			facingX += 360.0D;
		}
		if(((0.0D <= facingX) && (facingX < 45.0D)) || ((315.0D <= facingX) && (facingX < 360.0D))) {return "NORTH";}
		else if((45.0D <= facingX) && (facingX < 135.0D)) {return "EAST";}
		else if((135.0D <= facingX) && (facingX < 225.0D)) {return "SOUTH";}
		else if((225.0D <= facingX) && (facingX < 315.0D)) {return "WEST";}
		else {return "unknown";}
	}
}