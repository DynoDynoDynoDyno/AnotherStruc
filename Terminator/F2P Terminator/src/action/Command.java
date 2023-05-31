package action;

import model.Player;

public interface Command {
    void execute(Player player);
}

