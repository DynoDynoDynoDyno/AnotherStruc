package bot;

import action.Command;
import action.WalkCommand;
import model.Player;
import strategy.CombatStrategy;
import strategy.RoamingStrategy;
import strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class MainBot {
    private Player player;
    private List<Command> commandQueue;
    private Strategy currentStrategy;

    public MainBot() {
        this.player = new Player();
        this.commandQueue = new ArrayList<>();
        this.currentStrategy = new RoamingStrategy();
    }

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }

    public void setStrategy(Strategy strategy) {
        this.currentStrategy = strategy;
    }

    public void runStrategy() {
        currentStrategy.executeStrategy(this);
    }

    // Getter and setter for player...

    public static void main(String[] args) {
        MainBot bot = new MainBot();

        // For example, if the bot needs to walk to a specific area
        bot.addCommand(new WalkCommand(new Area()));
        bot.executeCommands();

        // If the bot needs to switch to a different strategy
        bot.setStrategy(new CombatStrategy());
        bot.runStrategy();
    }
}
