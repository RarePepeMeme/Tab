package me.ossas.tab.utils;

import me.osas.tab.api.Kraken;
import lombok.Getter;

public class Config {

    public static Boolean USE_TAB = true;

    @Getter private FileConfig rootConfig;

    public Config() {
        this.rootConfig = new FileConfig("config.yml");

        try {
            USE_TAB = this.rootConfig.getConfig().getBoolean("tab.enabled");

            if (USE_TAB) {
                new Kraken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
 

}