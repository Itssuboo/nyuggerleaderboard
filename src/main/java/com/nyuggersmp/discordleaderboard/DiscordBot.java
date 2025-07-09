package com.nyuggersmp.discordleaderboard;

import com.nyuggersmp.discordleaderboard.embeds.EmbedInfo;
import com.nyuggersmp.discordleaderboard.embeds.EmbedTopPlaytime;
import com.nyuggersmp.discordleaderboard.embeds.EmbedMiscStats;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;

public class DiscordBot {

    private JDA jda;

    public void startBot() {
        String token = DiscordLeaderboard.getInstance().getConfig().getString("bot.token");
        try {
            jda = JDABuilder.createDefault(token).build();
            jda.awaitReady();

            // Send the 3 embeds
            new EmbedInfo().send(jda);
            new EmbedTopPlaytime().send(jda);
            new EmbedMiscStats().send(jda);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        if (jda != null) jda.shutdownNow();
    }
}
