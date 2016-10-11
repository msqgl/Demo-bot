package com.sqgl.bot;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main {

  public static void main(String... args) {
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

    try {
      telegramBotsApi.registerBot(new DemoBot());
    } catch (TelegramApiRequestException e) {
//          TODO (Squeglia): print exeption
    }
  }
}
