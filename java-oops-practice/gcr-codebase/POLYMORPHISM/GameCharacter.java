class GameCharacter {
    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    void performAttack() {
        System.out.println(characterName + " attacks!");
    }
}

class Warrior extends GameCharacter {
    Warrior(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " swings a mighty sword!");
    }
}

class Mage extends GameCharacter {
    Mage(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " casts a fireball!");
    }
}

class Archer extends GameCharacter {
    Archer(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " shoots an arrow!");
    }
}
