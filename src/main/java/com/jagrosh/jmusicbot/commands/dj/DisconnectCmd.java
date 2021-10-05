/*
 * jjjakey wrote this im sorry in advance
 */
package com.jagrosh.jmusicbot.commands.dj;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jmusicbot.Bot;
import com.jagrosh.jmusicbot.audio.AudioHandler;
import com.jagrosh.jmusicbot.commands.DJCommand;

/**
 *
 * @author jjjakey <mrjjjakey@gmail.com>
 */
public class DisconnectCmd extends DJCommand 
{
    public DisconnectCmd(Bot bot)
    {
        super(bot);
        this.name = "disconnect";
        this.help = "disconnects the bot from the voice channel";
        this.aliases = bot.getConfig().getAliases(this.name);
        this.bePlaying = false;
    }

    @Override
    public void doCommand(CommandEvent event) 
    {
        AudioHandler handler = (AudioHandler)event.getGuild().getAudioManager().getSendingHandler();
        handler.stopAndClear();
        event.getGuild().getAudioManager().closeAudioConnection();  
        event.reply(event.getClient().getSuccess()+" Disconnected from voice channel.");
    }
}
