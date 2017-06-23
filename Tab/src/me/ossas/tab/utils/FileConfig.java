package me.ossas.tab.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.ossas.tab.Main;

import java.io.File;
import java.io.IOException;

public class FileConfig {
    
    public String fileName;
    public File configFile;
    private FileConfiguration config;
    
    public FileConfig(String fileName) {
        this.fileName = fileName;
        this.configFile = new File(Main.getInstance().getDataFolder(), fileName);
        
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();

            if (Main.getInstance().getResource(fileName) == null) {
                try {
                    this.configFile.createNewFile();
                }
                catch (IOException e) {
                    Main.getInstance().getLogger().severe("Failed to create new file " + fileName);
                }
            }
            else {
                Main.getInstance().saveResource(fileName, false);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }
    
    public FileConfig(File file, String fileName) {
        this.configFile = new File(file, fileName);

        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();

            if (Main.getInstance().getResource(fileName) == null) {
                try {
                    this.configFile.createNewFile();
                }
                catch (IOException e) {
                    Main.getInstance().getLogger().severe("Failed to create new file " + fileName);
                }
            }
            else {
                Main.getInstance().saveResource(fileName, false);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }
    
    public FileConfiguration getConfig() {
        return this.config;
    }
    
    public void save() {
        try {
            this.getConfig().save(this.configFile);
        }
        catch (IOException e) {
            Bukkit.getLogger().severe("Could not save config file " + this.configFile.toString());
            e.printStackTrace();
        }
    }
}
