package strategy;

import bot.MainBot;
import model.Player;
import action.WalkCommand;

public class RoamingStrategy implements Strategy {
    private Area roamingArea;

    public RoamingStrategy(Area roamingArea) {
        this.roamingArea = roamingArea;
    }

    @Override
    public void executeStrategy(MainBot bot) {
        Player player = bot.getPlayer();
        if (!player.isInArea(roamingArea)) {
            bot.addCommand(new WalkCommand(roamingArea));
        }
    }
}

