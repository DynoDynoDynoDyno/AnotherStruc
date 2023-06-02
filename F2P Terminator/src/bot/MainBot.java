package bot;
import org.dreambot.api.methods.map.Area;
import action.Command;
import action.WalkCommand;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.methods.interactive.Players;
import strategy.CombatStrategy;
import strategy.RoamingStrategy;
import strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

@ScriptManifest(name = "F2P Terminator", description = "The third version", author = "Dyno",
        version = 0.1, category = Category.COMBAT, image = "")

public class MainBot {
    private Player player;
    private List<Command> commandQueue;
    private Strategy currentStrategy;

    private Area pkArea1 = new Area(3087, 3730, 3074, 3722);
    private Area bank = new Area(3000, 3750, 3050, 3700);

    public MainBot() {
        this.player = new getLocal();
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
