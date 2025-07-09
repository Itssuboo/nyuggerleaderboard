package com.nyuggersmp.discordleaderboard.embeds;

import com.nyuggersmp.discordleaderboard.DiscordLeaderboard;
import me.clip.placeholderapi.PlaceholderAPI;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;

public class EmbedInfo {

    public void send(JDA jda) {
        String content = "**Információk**\n" +
                "Játékosok: " + papi("{online jatekosok}") + "\n" +
                "Top playtime: " + papi("{topt}") + "\n" +
                "Átlag játékosok: " + papi("{regular_players}") + "\n" +
                "Szerver Uptime: " + papi("{szerveruptime}") + "\n" +
                "Cpu usage: " + papi("%spark_cpu_process_1m%") + "\n" +
                "World szabad tárhely: " + papi("%plan_server_average_free_disk_day%") + "\n" +
                "Átlagos játékosok: " + papi("%plan_regular_players%");

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("NyuggerSMP - Információk")
                .setDescription(content)
                .setColor(0x00b0f4);

        jda.getTextChannelById(
                DiscordLeaderboard.getInstance().getConfig().getString("bot.channels.info")
        ).sendMessageEmbeds(embed.build()).queue();
    }

    private String papi(String placeholder) {
        return PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("dummy"), placeholder);
    }
}
