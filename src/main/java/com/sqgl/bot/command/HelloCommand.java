package com.sqgl.bot.command;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class HelloCommand extends BotCommand {

  public HelloCommand() {
    super("hello", "Il bot ti saluta.");
  }

  @Override
  public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

    final String userName = user.getUserName();
    final Long chatId = chat.getId();

    final SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(chatId.toString());
    sendMessage.setText("Hello " + userName);

    try {
      absSender.sendMessage(sendMessage);
    } catch (TelegramApiException e) {
//          TODO (Squeglia): print exeption
    }
  }
}
