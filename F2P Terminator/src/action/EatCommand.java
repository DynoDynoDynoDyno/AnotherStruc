package action;

import model.Player;

public class EatCommand implements Command {
    private Food food;

    public EatCommand(Food food) {
        this.food = food;
    }

    @Override
    public void execute(Player player) {
        player.eat(food);
    }
}

