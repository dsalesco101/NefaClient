package com.client.utilities.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.client.Client;
import com.client.sign.Signlink;

public class SettingsManager {

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
        		client.setUserSettings(new Settings(false, false, false, false, false, 0xFFFFFF, false, false, false, 0xFF00FF, 0xFF00FF, false, false));
        		return;
        	}
        	
        	Settings settings = null;
        	ObjectInputStream input = new ObjectInputStream(new FileInputStream(Signlink.getCacheDirectory() + "settings.ser"));
    		settings = (Settings) input.readObject();
    		input.close();
    		
    		if (settings != null) {
    			client.setUserSettings(new Settings(false, false, false, false, false, 0xFFFFFF, false, false, false, 0xFF00FF, 0xFF00FF, false, false));
    		}
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } 
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + 
                                " is caught");
            ex.printStackTrace();
        }
	}
}
