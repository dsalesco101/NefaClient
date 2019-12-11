package com.client.graphics.interfaces.impl;

import java.io.IOException;

import com.client.Client;
import com.client.Configuration;
import com.client.graphics.interfaces.RSInterface;
import com.client.utilities.settings.SettingsManager;
//import sun.security.krb5.Config; // = not being able to right click hELppP

public enum Dropdown {

	XP_POSITION() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpPosition = selected;
		}
	},
	
	XP_SIZE() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpSize = selected;
		}
	},
	
	XP_SPEED() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpSpeed = selected;
		}
	},
	
	XP_DURATION() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpDuration = selected;
		}
	},
	
	XP_COLOUR() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpColour = selected;
		}
	},
	
	XP_GROUP() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.xpGroup = selected;
		}
	},

	KEYBIND_SELECTION() {
		@Override
		public void selectOption(int selected, RSInterface dropdown) {
			Keybinding.bind((dropdown.id - Keybinding.MIN_FRAME) / 3, selected);
		}
	},

	PLAYER_ATTACK_OPTION_PRIORITY() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.playerAttackOptionPriority = selected;
		}
	},

	OLD_GAMEFRAME() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setOldGameframe(selected == 0 ? true : false);
			Client.instance.loadTabArea();
			Client.instance.drawTabArea();
		}
	},

	GAME_TIMERS() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setGameTimers(selected == 0 ? true : false);
		}
	},

	ANTI_ALIASING() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setEnableAntiAliasing(selected == 0 ? true : false);
		}
	},

	GROUND_ITEM_NAMES() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setGroundItemsOn(selected == 0 ? true : false);
		}
	},

	FOG() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			if (selected == 0) {
				Client.instance.getUserSettings().setEnableFogRendering(false);
			} else {
				Client.instance.getUserSettings().setEnableFogRendering(true);
			}
			switch(selected){
				case 1://grey
                    Client.instance.getUserSettings().setFogColor(0xDCDBDF);
					return;
                case 2: //Sisle
                    Client.instance.getUserSettings().setFogColor(0xC8C0A8);
                    return;
                case 3: //dark
                    Client.instance.getUserSettings().setFogColor(0x0e0d0b);
                    return;
                case 4://marroon
                    Client.instance.getUserSettings().setFogColor(0x800000);
                    return;
                case 5://rainbow
                	Client.instance.getUserSettings().setFogColor(0xEEEEEE);
                    Client.instance.pushMessage("Please do ::fogdelay to add a timer to the fog!", 0,"");
					Client.instance.pushMessage("@red@ Warning this could give you seizures! Use at an extreme caution! Ascend not responsible! LoL", 0,"");
                return;
			}
		}
	},

	SMOOTH_SHADING() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setEnableSmoothShading(selected == 0 ? true : false);
		}
	},

	TILE_BLENDING() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setEnableTileBlending(selected == 0 ? true : false);
		}
	},

	INVENTORY_CONTEXT_MENU() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			if (selected == 0) {
				Client.instance.getUserSettings().setInventoryContextMenu(false);
			} else {
				Client.instance.getUserSettings().setInventoryContextMenu(true);
			}
			switch(selected){
				case 0: //off
					Client.instance.getUserSettings().setStartMenuColor(0xFFFFFF);
					return;
				case 1: //magenta
					Client.instance.getUserSettings().setStartMenuColor(0xFF00FF);
					return;
				case 2://lime
					Client.instance.getUserSettings().setStartMenuColor(0x00FF00);
					return;
				case 3://cyan
					Client.instance.getUserSettings().setStartMenuColor(0x00FFFF);
					return;
				case 4://red
					Client.instance.getUserSettings().setStartMenuColor(0xFF0000);
					return;
			}
		}
	},
	CHAT_EFFECT() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setChatColor(selected);
		}
	},
	BOUNTY_HUNTER() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setBountyHunter(selected == 0 ? true : false);
		}
	},
	TARGET_INTERFACE() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Client.instance.getUserSettings().setShowEntityTarget(selected == 0 ? true : false);
		}
	},

	NPC_ATTACK_OPTION_PRIORITY() {
		@Override
		public void selectOption(int selected, RSInterface r) {
			Configuration.npcAttackOptionPriority = selected;
		}
	}
	;

	private Dropdown() { }

	public abstract void selectOption(int selected, RSInterface r);
}

