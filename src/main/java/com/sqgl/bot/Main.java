package com.sqgl.bot;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main {

  public static void main(String... args) {
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

    try {
      System.out.println("Registrazione bot inizio.");

      telegramBotsApi.registerBot(new DemoBot());

      System.out.println("Registrazione bot fine.");
    } catch (TelegramApiRequestException e) {
//          TODO (Squeglia): print exeption
    }
  }
}
