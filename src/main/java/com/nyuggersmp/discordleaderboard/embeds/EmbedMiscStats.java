package com.nyuggersmp.discordleaderboard.embeds;

import com.nyuggersmp.discordleaderboard.DiscordLeaderboard;
import me.clip.placeholderapi.PlaceholderAPI;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;

public class EmbedMiscStats {

    public void send(JDA jda) {
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("NyuggerSMP")
                .setTitle("Egyéb leaderboard")
                .addField("Játékos ölések(heti)", papi("%plan_sessions_players_kill_week%"), true)
                .addField("Afk time ma", papi("%plan_sessions_afk_time_day%"), true)
                .addField("Top playtime(ma)", papi("%plan_top_playtime_day_1%"), true)
                .addField("Átlag fent töltött idő", papi("%plan_sessions_average_session_length_day%"), true)
                .addField("Összes afk time", papi("%plan_sessions_afk_time_total%"), true)
                .addField("Legtöbb játékos dátuma", papi("%plan_sessions_peak_date%"), true)
                .setColor(0x00b0f4);

        jda.getTextChannelById(
                DiscordLeaderboard.getInstance().getConfig().getString("bot.channels.misc")
        ).sendMessageEmbeds(embed.build()).queue();
    }

    private String papi(String placeholder) {
        return PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("dummy"), placeholder);
    }
}
