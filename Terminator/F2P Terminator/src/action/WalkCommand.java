package action;

import model.Area;
import model.Player;

public class WalkCommand implements Command {
    private Area destination;

    public WalkCommand(Area destination) {
        this.destination = destination;
    }

    @Override
    public void execute(Player player) {
        player.moveTo(destination);
    }
}

