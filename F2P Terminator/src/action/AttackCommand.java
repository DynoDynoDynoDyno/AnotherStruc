package action;



public class AttackCommand implements Command {
    private Enemy enemy;

    public AttackCommand(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void execute(Player player) {
        player.attack(enemy);
    }
}
