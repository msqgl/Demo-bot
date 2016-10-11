package com.sqgl.bot;

import com.sqgl.bot.command.HelloCommand;
import com.sqgl.bot.conf.DemoBotConfig;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DemoBot extends TelegramLongPollingCommandBot {

  public DemoBot() {
    register(new HelloCommand());
  }

  public void processNonCommandUpdate(Update update) {
    if (update.hasMessage()) {
      Message message = update.getMessage();

      if (message.hasText()) {
        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId(message.getChatId().toString()); //who should get from the
        sendMessageRequest.setText("you said: " + message.getText());
        try {
          sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
        } catch (TelegramApiException e) {
//          TODO (Squeglia): print exeption
        }
      }
    }
  }

  public String getBotUsername() {
    return DemoBotConfig.BOT_USERNAME;
  }

  public String getBotToken() {
    return DemoBotConfig.BOT_TOKEN;
  }



}
