public class GameMain {
    public static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0, mageCount = 0, archerCount = 0;

        for (GameCharacter c : characters) {
            c.performAttack();
            if (c instanceof Warrior) warriorCount++;
            else if (c instanceof Mage) mageCount++;
            else if (c instanceof Archer) archerCount++;
        }

        System.out.println("\nBattle Summary:");
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Conan"),
            new Mage("Gandalf"),
            new Archer("Legolas"),
            new Warrior("Aragorn"),
            new Mage("Merlin"),
            new Archer("Hawkeye")
        };

        startBattle(characters);
    }
}
