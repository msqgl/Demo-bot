package com.sqgl.bot.command;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand extends BotCommand {

  public DateCommand() {
    super("date", "Il bot risponde con la data odierna.");
  }

  public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
    final Date date = new Date();
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    final Long chatId = chat.getId();

    final SendMessage sendMessage = new SendMessage();
    sendMessage.setText(simpleDateFormat.format(date));
    sendMessage.setChatId(chatId.toString());

    try {
      absSender.sendMessage(sendMessage);
    } catch (TelegramApiException e) {
//      TODO (Squeglia): print exeption
    }
  }
}
