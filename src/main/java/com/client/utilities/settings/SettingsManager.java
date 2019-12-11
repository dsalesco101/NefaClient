package com.client.utilities.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import com.client.Client;
import com.client.sign.Signlink;

/**
 * 
 * @author Grant_ | www.rune-server.ee/members/grant_ | 12/10/19
 *
 */
public class SettingsManager {
	
	public static final int DEFAULT_FOG_COLOR = 0xDCDBDF;
	public static final int DEFAULT_START_MENU_COLOR = 0xFF00FF;
	public static final int DEFAULT_CHAT_COLOR_OPTION = 0;

	public static void saveSettings(Client client) throws IOException {
		// Serialization
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(Signlink.getCacheDirectory() + "settings.ser")));
		try {
			output.writeObject(client.getUserSettings());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			output.flush();
			output.close();
		}
	}
	
	public static void loadSettings(Client client) {
        // Deserialization 
        try { 
  
        	File discover = new File(Signlink.getCacheDirectory() + "settings.ser");
        	if (!discover.exists()) {
        		//TODO: @Noah eventually you'll want to come here to set the default settings on a players first login
        		client.setUserSettings(new Settings(false, false, false, false, false, DEFAULT_FOG_COLOR, false, false, false, DEFAULT_START_MENU_COLOR, DEFAULT_CHAT_COLOR_OPTION, false, false));
        		return;
        	}
        	
        	Settings settings = null;
        	ObjectInputStream input = new ObjectInputStream(new FileInputStream(Signlink.getCacheDirectory() + "settings.ser"));
        	
        	settings = (Settings) input.readObject();
    		
    		input.close();
    		
    		if (settings != null) {
    			client.setUserSettings(settings);
    		}
        } 
        
        catch (InvalidClassException ice) {
    		client.setUserSettings(new Settings(false, false, false, false, false, DEFAULT_FOG_COLOR, false, false, false, DEFAULT_START_MENU_COLOR, DEFAULT_CHAT_COLOR_OPTION, false, false));
    	}
        
        catch (StreamCorruptedException se) {
        	client.setUserSettings(new Settings(false, false, false, false, false, DEFAULT_FOG_COLOR, false, false, false, DEFAULT_START_MENU_COLOR, DEFAULT_CHAT_COLOR_OPTION, false, false));
        }
  
        catch (IOException ex) { 
        	client.setUserSettings(new Settings(false, false, false, false, false, DEFAULT_FOG_COLOR, false, false, false, DEFAULT_START_MENU_COLOR, DEFAULT_CHAT_COLOR_OPTION, false, false));
            ex.printStackTrace();
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + 
                                " is caught");
            ex.printStackTrace();
        }
	}
}
