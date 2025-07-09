/*
NyuggerSMP Discord Leaderboard Plugin
- Sends 3 configurable embeds with PlaceholderAPI integration
- Uses PlayTimes, Plan, and Spark placeholders
*/

// Plugin Main Class
package com.nyuggersmp.discordleaderboard;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public final class DiscordLeaderboard extends JavaPlugin {

    private static DiscordLeaderboard instance;
    private DiscordBot bot;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        if (getConfig().getBoolean("bot.enabled")) {
            bot = new DiscordBot();
            bot.startBot();
        }
    }

    @Override
    public void onDisable() {
        if (bot != null) bot.shutdown();
    }

    public static DiscordLeaderboard getInstance() {
        return instance;
    }
}
