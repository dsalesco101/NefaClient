package com.client.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;

import com.client.Class36;
import com.client.Client;
import com.client.Configuration;
import com.client.MRUNodes;
import com.client.Model;
import com.client.Stream;
import com.client.StreamLoader;

public final class NpcDefinition {

	public static NpcDefinition forID(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].interfaceType == i)
				return cache[j];

		anInt56 = (anInt56 + 1) % 20;
		NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
		stream.currentOffset = streamIndices[i];
		entityDef.interfaceType = i;
		entityDef.readValues(stream);

		if (i == 7913) {
			entityDef.combatLevel = 0;
			entityDef.name = "Iron man shop keeper";
			entityDef.description = "A shop specifically for iron men.";
		}
		if (i == 8906) {
			entityDef.combatLevel = 0;
			entityDef.name = "Santa's little elf";
			entityDef.description = "A helper sent from santa himself.";
			entityDef.actions = new String[] { "Talk-To", null, "Christmas Shop", "Return-Items", null };
		}
		if (i == 954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Crystal Seed Trader";
			entityDef.description = "Use a seed on me to get a Crystal Bow.";
					
		}
		if (i == 6970) {
			entityDef.combatLevel = 0;
			entityDef.name = "Theif";
			entityDef.actions = new String[] { null, null, "Pickpocket",  null,  null };
		}
		if (i == 8761) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 7954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Achievement Master";
			entityDef.actions = new String[] { "Trade", null, "Open Achievements", null, null, };

		}
		if (i == 5870) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 1013) {
			entityDef.combatLevel = 0;
			entityDef.name = "Gambler Shop";
			entityDef.description = "A shop specifically for gamblers.";
		}
		if (i == 315) {
			entityDef.combatLevel = 0;
			entityDef.name = "PKP Manager";
		}
		if (i == 13) {
			entityDef.combatLevel = 0;
			entityDef.name = "Referral Tutor";
			entityDef.description = "He Manages all the sovark referrals.";
		}
		if (i == 5293) {
			entityDef.combatLevel = 0;
			entityDef.name = "Elven Keeper";
		}
		if(i==3218 || i ==3217){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==2897){
			entityDef.combatLevel = 0;
			entityDef.name = "Trading Post Manager";
			entityDef.actions = new String[] { "Open", null, "Collect", null, null };
		}
		if(i==1306){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Make-over", null, null, null, null };
		}
		if(i==3257){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1011){
			entityDef.combatLevel = 0;
			entityDef.name = "Item Gambler";
			entityDef.actions = new String[] { "Info", null, "Gamble", null, null };
		}
		if(i==3248){
			entityDef.combatLevel = 0;
			entityDef.name = "Sovarks Wizard";
			entityDef.actions = new String[] { "Teleport", null, "Previous Location", null, null };
		}
		if(i==1520){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Small Net", null, "Harpoon", null, null };
		}
		if(i==8920){
			
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==8921){
			entityDef.name = "Crystal Whirlwind";
		}
		if(i==9120){
			entityDef.combatLevel = 0;
			entityDef.name = "Donator Shop";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i == 2662){
			entityDef.combatLevel = 0;
			entityDef.name = "Tournament Manager";
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if(i==603){
			entityDef.combatLevel = 0;
			entityDef.name = "Captain Kraken";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==7041){
			entityDef.combatLevel = 0;
			entityDef.name = "Ticket Exchange";
			entityDef.actions = new String[] { "Exchange", null, null, null, null };
		}
		if(i==3894){
			entityDef.combatLevel = 0;
			entityDef.name = "Sigmund The Merchant";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		
		if (i==7413) {
		    entityDef.name = "Max Dummy";
		    entityDef.actions[0] = null;
		}
		if(i==9011){
			entityDef.combatLevel = 0;
			entityDef.name = "Vote Shop";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1933){
			entityDef.combatLevel = 0;
			entityDef.name = "Mills";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8819){
			entityDef.combatLevel = 0;
			entityDef.name = "PVM Point Shop";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8635){
			entityDef.combatLevel = 0;
			entityDef.name = "Melee Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8636){
			entityDef.combatLevel = 0;
			entityDef.name = "Range Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8637){
			entityDef.combatLevel = 0;
			entityDef.name = "Mage Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8688){
			entityDef.combatLevel = 0;
			entityDef.name = "Fat Tony";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==7769){
			entityDef.combatLevel = 0;
			entityDef.name = "Shop Keeper";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1501){
			entityDef.combatLevel = 0;
			entityDef.name = "Hunter Store";
			entityDef.actions = new String[] { null, null, null, null, "Trade" };
		}
		if(i==2913){
			entityDef.combatLevel = 0;
			entityDef.name = "Fishing Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==5809){
			entityDef.combatLevel = 0;
			entityDef.name = "Crafting and Tanner";
			entityDef.actions = new String[] { "Tan", null, "Trade", null, null };
		}
		if(i==555){
			entityDef.combatLevel = 0;
			entityDef.name = "Sell Me Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==9168){
			entityDef.combatLevel = 0;
			entityDef.name = "Flex";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==4921){
			entityDef.combatLevel = 0;
			entityDef.name = "Supplies";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 5314) {
			entityDef.combatLevel = 0;
			entityDef.name = "Mystical Wizard";
			entityDef.actions = new String[] { "Teleport", "Previous Location", null, null, null };
			entityDef.description = "This wizard has the power to teleport you to many locations.";
		}
		if (i == 8781) {
			entityDef.name = "@red@Queen Latsyrc";
			entityDef.combatLevel = 982;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 8026) {
			entityDef.name = "Vorkath";
			// entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnim = 7946;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Poke", null, null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8203 && i == 6637 && i == 6638) {

			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, null, "Pick-Up", "Metamorphosis" };
		}
		if (i == 8492 || i == 8493 || i == 8494 || i == 8495) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8737 || i == 8738) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 326 || i == 327) {
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 85;
			entityDef.anInt91 = 85;
			entityDef.name = "Vote Pet";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i >= 7354 && i <=7367) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 5559 || i == 5560) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 6473) { //terror dog
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 50; //WIDTH
			entityDef.anInt91 = 50; // HEIGH
		}
		if (i == 7025) { //guard dog
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
		}
		if (i == 7216 || i == 6473) { //guard dog
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 8027) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnim = 7950;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, null, null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8028) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnim = 7948;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if(i==7144){
	entityDef.anInt75 = 0;
		}
		if(i==963){
			entityDef.anInt75 = 6;
		}
		if(i==7145){
	entityDef.anInt75 = 1;
		}
		if(i==7146){
	entityDef.anInt75 = 2;
		}
		return entityDef;
	}

	public static int totalAmount;

	public static void dump() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./npc_defs.txt"))) {
			for (int i = 0; i < 70_000; i++) {
				try {
					NpcDefinition def = NpcDefinition.forID(i);
					if (def != null) {
						writer.write("Npc=" + i);
						writer.newLine();
						writer.write("Stand animation=" + def.standAnim);
						writer.newLine();
						writer.write("Walk animation=" + def.walkAnim);
						writer.newLine();
						writer.newLine();
					}
				} catch (Exception e) {}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("npc.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("npc.idx"));
		totalAmount = stream.readUnsignedWord();
		streamIndices = new int[totalAmount];
		int i = 2;
		for (int j = 0; j < totalAmount; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}

		cache = new NpcDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NpcDefinition();
		for (int index = 0; index < totalAmount; index++) {
			NpcDefinition ed = forID(index);
			if (ed == null)
				continue;
			if (ed.name == null)
				continue;
		}
	}

	/*
	 * public void readValues(Stream stream) { do { int i =
	 * stream.readUnsignedByte(); if (i == 0) return; if (i == 1) { int j =
	 * stream.readUnsignedByte(); models = new int[j]; for (int j1 = 0; j1 < j;
	 * j1++) models[j1] = stream.readUnsignedWord();
	 * 
	 * } else if (i == 2) name = stream.readString(); else if (i == 3) description =
	 * stream.readString(); else if (i == 12) squareLength =
	 * stream.readSignedByte(); else if (i == 13) standAnim =
	 * stream.readUnsignedWord(); else if (i == 14) walkAnim =
	 * stream.readUnsignedWord(); else if (i == 17) { walkAnim =
	 * stream.readUnsignedWord(); anInt58 = stream.readUnsignedWord(); anInt83 =
	 * stream.readUnsignedWord(); anInt55 = stream.readUnsignedWord(); if (anInt58
	 * == 65535) { anInt58 = -1; } if (anInt83 == 65535) { anInt83 = -1; } if
	 * (anInt55 == 65535) { anInt55 = -1; } } else if (i >= 30 && i < 40) { if
	 * (actions == null) actions = new String[5]; actions[i - 30] =
	 * stream.readString(); if (actions[i - 30].equalsIgnoreCase("hidden"))
	 * actions[i - 30] = null; } else if (i == 40) { int k =
	 * stream.readUnsignedByte(); originalColors = new int[k]; newColors = new
	 * int[k]; for (int k1 = 0; k1 < k; k1++) { originalColors[k1] =
	 * stream.readUnsignedWord(); newColors[k1] = stream.readUnsignedWord(); }
	 * 
	 * } else if (i == 60) { int l = stream.readUnsignedByte(); dialogueModels = new
	 * int[l]; for (int l1 = 0; l1 < l; l1++) dialogueModels[l1] =
	 * stream.readUnsignedWord();
	 * 
	 * } else if (i == 90) stream.readUnsignedWord(); else if (i == 91)
	 * stream.readUnsignedWord(); else if (i == 92) stream.readUnsignedWord(); else
	 * if (i == 93) minimapDot = false; else if (i == 95) combatLevel =
	 * stream.readUnsignedWord(); else if (i == 97) anInt91 =
	 * stream.readUnsignedWord(); else if (i == 98) anInt86 =
	 * stream.readUnsignedWord(); else if (i == 99) aBoolean93 = true; else if (i ==
	 * 100) anInt85 = stream.readSignedByte(); else if (i == 101) anInt92 =
	 * stream.readSignedByte() * 5; else if (i == 102) anInt75 =
	 * stream.readUnsignedByte(); else if (i == 103) getDegreesToTurn =
	 * stream.readUnsignedByte(); else if (i == 106) { anInt57 =
	 * stream.readUnsignedWord(); if (anInt57 == 65535) anInt57 = -1; anInt59 =
	 * stream.readUnsignedWord(); if (anInt59 == 65535) anInt59 = -1; int i1 =
	 * stream.readUnsignedByte(); childrenIDs = new int[i1 + 1]; for (int i2 = 0; i2
	 * <= i1; i2++) { childrenIDs[i2] = stream.readUnsignedWord(); if
	 * (childrenIDs[i2] == 65535) childrenIDs[i2] = -1; }
	 * 
	 * } else if (i == 107) aBoolean84 = false; } while (true); }
	 */
	private void readValues(Stream stream) {
		while (true) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0)
				return;
			if (opcode == 1) {
				int j = stream.readUnsignedByte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = stream.readUnsignedWord();

			} else if (opcode == 2)
				name = stream.readString();
			else if (opcode == 3)
				description = stream.readString();
			else if (opcode == 12)
				boundDim = stream.readSignedByte();
			else if (opcode == 13)
				standAnim = stream.readUnsignedWord();
			else if (opcode == 14)
				walkAnim = stream.readUnsignedWord();
			else if (opcode == 17) {
				walkAnim = stream.readUnsignedWord();
				anInt58 = stream.readUnsignedWord();
				anInt83 = stream.readUnsignedWord();
				anInt55 = stream.readUnsignedWord();
				if (anInt58 == 65535) {
					anInt58 = -1;
				}
				if (anInt83 == 65535) {
					anInt83 = -1;
				}
				if (anInt55 == 65535) {
					anInt55 = -1;
				}
			} else if (opcode >= 30 && opcode < 40) {
				if (actions == null)
					actions = new String[10];
				actions[opcode - 30] = stream.readString();
				if (actions[opcode - 30].equalsIgnoreCase("hidden"))
					actions[opcode - 30] = null;
			} else if (opcode == 40) {
				int k = stream.readUnsignedByte();
				originalColors = new int[k];
				newColors = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalColors[k1] = stream.readUnsignedWord();
					newColors[k1] = stream.readUnsignedWord();
				}
			} else if (opcode == 1) {
				int k = stream.readUnsignedByte();
				originalTextures = new int[k];
				newTextures = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalTextures[k1] = stream.readUnsignedWord();
					newTextures[k1] = stream.readUnsignedWord();
				}

			} else if (opcode == 60) {
				int l = stream.readUnsignedByte();
				dialogueModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					dialogueModels[l1] = stream.readUnsignedWord();

			} else if (opcode == 93)
				onMinimap = false;
			else if (opcode == 95)
				combatLevel = stream.readUnsignedWord();
			else if (opcode == 97)
				anInt91 = stream.readUnsignedWord();
			else if (opcode == 98)
				anInt86 = stream.readUnsignedWord();
			else if (opcode == 99)
				aBoolean93 = true;
			else if (opcode == 100)
				anInt85 = stream.readSignedByte();
			else if (opcode == 101)
				anInt92 = stream.readSignedByte();
			else if (opcode == 102)
				anInt75 = stream.readUnsignedWord();
			else if (opcode == 103)
				getDegreesToTurn = stream.readUnsignedWord();
			else if (opcode == 106 || opcode == 118) {
				anInt57 = stream.readUnsignedWord();
				if (anInt57 == 65535)
					anInt57 = -1;
				anInt59 = stream.readUnsignedWord();
				if (anInt59 == 65535)
					anInt59 = -1;
				int var3 = -1;
				if(opcode == 118)
					var3 = stream.readUnsignedWord();
				int i1 = stream.readUnsignedByte();
				childrenIDs = new int[i1 + 2];
				for (int i2 = 0; i2 <= i1; i2++) {
					childrenIDs[i2] = stream.readUnsignedWord();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}
				childrenIDs[i1 + 1] = var3;
			} else if (opcode == 107)
				aBoolean84 = false;
		}
	}

	public Model method160() {
		if (childrenIDs != null) {
			NpcDefinition entityDef = method161();
			if (entityDef == null)
				return null;
			else
				return entityDef.method160();
		}
		if (dialogueModels == null) {
			return null;
		}
		boolean flag1 = false;
		for (int i = 0; i < dialogueModels.length; i++)
			if (!Model.method463(dialogueModels[i]))
				flag1 = true;

		if (flag1)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[dialogueModels.length];
		for (int j = 0; j < dialogueModels.length; j++)
			aclass30_sub2_sub4_sub6s[j] = Model.method462(dialogueModels[j]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

		if (originalColors != null)
			for (int k = 0; k < originalColors.length; k++)
				model.replaceColor(originalColors[k], newColors[k]);


		if (originalTextures != null)
			for (int k = 0; k < originalTextures.length; k++)
				model.replaceTexture(originalTextures[k], newTextures[k]);

		return model;
	}

	public NpcDefinition method161() {
		int j = -1;
		if (anInt57 != -1 && anInt57 <= 2113) {
			VarBit varBit = VarBit.cache[anInt57];
			int k = varBit.anInt648;
			int l = varBit.anInt649;
			int i1 = varBit.anInt650;
			int j1 = Client.anIntArray1232[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		} else if (anInt59 != -1)
			j = clientInstance.variousSettings[anInt59];
		int var3;
		if (j >= 0 && j < childrenIDs.length)
			var3 = childrenIDs[j];
		else
			var3 = childrenIDs[childrenIDs.length - 1];
		return var3 == -1 ? null : forID(var3);
	}

	public Model method164(int j, int k, int ai[]) {
		if (childrenIDs != null) {
			NpcDefinition entityDef = method161();
			if (entityDef == null)
				return null;
			else
				return entityDef.method164(j, k, ai);
		}
		Model model = (Model) mruNodes.insertFromCache(interfaceType);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < models.length; i1++)
				if (!Model.method463(models[i1]))
					flag = true;

			if (flag)
				return null;
			Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				aclass30_sub2_sub4_sub6s[j1] = Model.method462(models[j1]);

			if (aclass30_sub2_sub4_sub6s.length == 1)
				model = aclass30_sub2_sub4_sub6s[0];
			else
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			if (originalColors != null) {
				for (int k1 = 0; k1 < originalColors.length; k1++)
					model.replaceColor(originalColors[k1], newColors[k1]);

			}
			model.method469();
			model.method479(64 + anInt85, 850 + anInt92, -30, -50, -30, true);
			// model.method479(84 + anInt85, 1000 + anInt92, -90, -580, -90, true);
			mruNodes.removeFromCache(model, interfaceType);
		}
		Model model_1 = Model.EMPTY_MODEL;
		model_1.method464(model, Class36.method532(k) & Class36.method532(j));
		if (k != -1 && j != -1)
			model_1.method471(ai, j, k);
		else if (k != -1)
			model_1.method470(k);
		if (anInt91 != 128 || anInt86 != 128)
			model_1.method478(anInt91, anInt91, anInt86);
		model_1.method466();
		model_1.faceGroups = null;
		model_1.vertexGroups = null;
		if (boundDim == 1)
			model_1.aBoolean1659 = true;
		return model_1;
	}

	private NpcDefinition() {
		anInt55 = -1;
		anInt57 = walkAnim;
		anInt58 = walkAnim;
		anInt59 = walkAnim;
		combatLevel = -1;
		anInt64 = 1834;
		walkAnim = -1;
		boundDim = 1;
		anInt75 = -1;
		standAnim = -1;
		interfaceType = -1L;
		getDegreesToTurn = 32;
		anInt83 = -1;
		aBoolean84 = true;
		anInt86 = 128;
		onMinimap = true;
		anInt91 = 128;
		aBoolean93 = false;
	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void dumpList() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcList " + Configuration.dumpID + ".txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
								+ definition.standAnim + "\t" + definition.walkAnim + "\t");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dumpSizes() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write(i + "	" + definition.boundDim);
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int anInt55;
	public static int anInt56;
	public int anInt57;
	public int anInt58;
	public int anInt59;
	public static Stream stream;
	public int combatLevel;
	public final int anInt64;
	public String name;
	public String actions[];
	public int walkAnim;
	public byte boundDim;
	public int[] newColors;
	public static int[] streamIndices;
	public int[] dialogueModels;
	public int anInt75;
	public int[] originalColors;
	public int[] originalTextures, newTextures;
	public int standAnim;
	public long interfaceType;
	public int getDegreesToTurn;
	public static NpcDefinition[] cache;
	public static Client clientInstance;
	public int anInt83;
	public boolean aBoolean84;
	public int anInt85;
	public int anInt86;
	public boolean onMinimap;
	public int childrenIDs[];
	public String description;
	public int anInt91;
	public int anInt92;
	public boolean aBoolean93;
	public int[] models;
	public static MRUNodes mruNodes = new MRUNodes(70);

}