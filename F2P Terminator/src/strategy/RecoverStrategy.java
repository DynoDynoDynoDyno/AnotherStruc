package strategy;

import bot.MainBot;
import action.RecoverCommand;

public class RecoverStrategy implements Strategy {
    public RecoverStrategy() {
    }

    @Override
    public void executeStrategy(MainBot bot) {
        bot.addCommand(new RecoverCommand());
    }
}
