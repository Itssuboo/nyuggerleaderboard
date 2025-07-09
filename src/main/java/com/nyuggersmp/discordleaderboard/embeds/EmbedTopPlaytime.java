package com.nyuggersmp.discordleaderboard.embeds;

import com.nyuggersmp.discordleaderboard.DiscordLeaderboard;
import me.clip.placeholderapi.PlaceholderAPI;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;

public class EmbedTopPlaytime {

    public void send(JDA jda) {
        StringBuilder names = new StringBuilder();
        StringBuilder times = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            names.append(papi("%PlayTimes_topname" + i + "%")).append("\n");
            times.append(papi("%PlayTimes_toptime" + i + "%")).append("\n");
        }


        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("NyuggerSMP")
                .setTitle("Top Playtime")
                .addField("Nevek", names.toString(), true)
                .addField("Idő", times.toString(), true)
                .setColor(0x00b0f4);

        jda.getTextChannelById(
                DiscordLeaderboard.getInstance().getConfig().getString("bot.channels.topplaytime")
        ).sendMessageEmbeds(embed.build()).queue();
    }

    private String papi(String placeholder) {
        return PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("dummy"), placeholder);
    }
}
