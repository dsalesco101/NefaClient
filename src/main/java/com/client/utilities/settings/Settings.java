package com.client.utilities.settings;

import java.io.Serializable;

/**
 * 
 * @author Grant_ | www.rune-server.ee/members/grant_ | 12/10/19
 *
 */
public class Settings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4394926495169279946L;
	
	private boolean oldGameframe;
	private boolean gameTimers;
	private boolean enableAntiAliasing;
	private boolean groundItemsOn;
	private boolean enableFogRendering;
	private int fogColor;
	private boolean enableSmoothShading;
	private boolean enableTileBlending;
	private boolean inventoryContextMenu;
	private int startMenuColor;
	private int chatColor;
	private boolean bountyHunter;
	private boolean showEntityTarget;
	
	public Settings(boolean oldGameframe, boolean gameTimers, boolean enableAntiAliasing, boolean groundItemsOn, boolean enableFogRendering, int fogColor, boolean enableSmoothShading,
			boolean enableTileBlending, boolean inventoryContextMenu, int startMenuColor, int chatColor, boolean bountyHunter, boolean showEntityTarget) {
		this.setOldGameframe(oldGameframe);
		this.setGameTimers(gameTimers);
		this.setEnableAntiAliasing(enableAntiAliasing);
		this.setGroundItemsOn(groundItemsOn);
		this.setEnableFogRendering(enableFogRendering);
		this.setFogColor(fogColor);
		this.setEnableSmoothShading(enableSmoothShading);
		this.setEnableTileBlending(enableTileBlending);
		this.setInventoryContextMenu(inventoryContextMenu);
		this.setStartMenuColor(startMenuColor);
		this.setChatColor(chatColor);
		this.setBountyHunter(bountyHunter);
		this.setShowEntityTarget(showEntityTarget);
	}

	public boolean isOldGameframe() {
		return oldGameframe;
	}

	public void setOldGameframe(boolean oldGameframe) {
		this.oldGameframe = oldGameframe;
	}

	public boolean isEnableAntiAliasing() {
		return enableAntiAliasing;
	}

	public void setEnableAntiAliasing(boolean enableAntiAliasing) {
		this.enableAntiAliasing = enableAntiAliasing;
	}

	public boolean isEnableFogRendering() {
		return enableFogRendering;
	}

	public void setEnableFogRendering(boolean enableFogRendering) {
		this.enableFogRendering = enableFogRendering;
	}

	public int getFogColor() {
		return fogColor;
	}

	public void setFogColor(int fogColor) {
		this.fogColor = fogColor;
	}

	public boolean isEnableTileBlending() {
		return enableTileBlending;
	}

	public void setEnableTileBlending(boolean enableTileBlending) {
		this.enableTileBlending = enableTileBlending;
	}

	public boolean isEnableSmoothShading() {
		return enableSmoothShading;
	}

	public void setEnableSmoothShading(boolean enableSmoothShading) {
		this.enableSmoothShading = enableSmoothShading;
	}

	public boolean isInventoryContextMenu() {
		return inventoryContextMenu;
	}

	public void setInventoryContextMenu(boolean inventoryContextMenu) {
		this.inventoryContextMenu = inventoryContextMenu;
	}

	public int getChatColor() {
		return chatColor;
	}

	public void setChatColor(int chatColor) {
		this.chatColor = chatColor;
	}

	public boolean isBountyHunter() {
		return bountyHunter;
	}

	public void setBountyHunter(boolean bountyHunter) {
		this.bountyHunter = bountyHunter;
	}

	public boolean isShowEntityTarget() {
		return showEntityTarget;
	}

	public void setShowEntityTarget(boolean showEntityTarget) {
		this.showEntityTarget = showEntityTarget;
	}

	public boolean isGameTimers() {
		return gameTimers;
	}

	public void setGameTimers(boolean gameTimers) {
		this.gameTimers = gameTimers;
	}

	public boolean isGroundItemsOn() {
		return groundItemsOn;
	}

	public void setGroundItemsOn(boolean groundItemsOn) {
		this.groundItemsOn = groundItemsOn;
	}

	public int getStartMenuColor() {
		return startMenuColor;
	}

	public void setStartMenuColor(int startMenuColor) {
		this.startMenuColor = startMenuColor;
	}
}
