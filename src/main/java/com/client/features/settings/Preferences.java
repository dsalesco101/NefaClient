package com.client.features.settings;


import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import com.client.Client;
import com.client.Rasterizer;
import com.client.features.gameframe.ScreenMode;
import com.client.graphics.interfaces.RSInterface;
import com.client.graphics.interfaces.impl.SettingsWidget;
import com.client.sign.Signlink;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;

@Log
public class Preferences {

    private static Preferences preferences = new Preferences();

    public static Preferences getPreferences() {
        return preferences;
    }

    public static void load() {
        try {
            File preferencesFile = new File(getFileLocation());
            if (preferencesFile.exists()) {
                ObjectMapper mapper = new ObjectMapper();
                preferences = mapper.readValue(preferencesFile, Preferences.class);
                log.info("Loaded preferences.");
            } else {
                log.info("No preferences saved, generated default.");
                save();
            }
        } catch (IOException e) {
            log.severe("Error while loading preferences.");
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(getFileLocation()), preferences);
            log.severe("Saved preferences.");
        } catch (IOException e) {
            log.severe("Error while saving preferences.");
            e.printStackTrace();
        }
    }

    public static String getFileLocation() {
        return Signlink.getCacheDirectory() + "preferences.json";
    }

    public double brightness = 0.75;
    public ScreenMode mode = ScreenMode.FIXED;
    public int screenWidth;
    public int screenHeight;
    public int dragTime = 5;

    public Preferences() { }

    public void updateClientConfiguration() {
        // Brightness
        Rasterizer.setBrightness(brightness);
        //SettingsWidget.brightnessSlider.setValue(brightness);

        log.info("Updated client configuration for preferences.");
    }

    public void updateScreenMode() {
        Client.instance.setGameMode(mode, new Dimension(screenWidth, screenHeight), false);
    }

}
