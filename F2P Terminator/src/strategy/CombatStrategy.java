package strategy;

import bot.MainBot;
import action.AttackCommand;

public class CombatStrategy implements Strategy {
    public CombatStrategy() {
    }

    @Override
    public void executeStrategy(MainBot bot) {
        bot.addCommand(new AttackCommand());
    }
}

