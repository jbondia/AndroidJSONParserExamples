package simplebackend

class Character {

    static hasMany = [armors : Armor]

    long gold;
    int level;
    String name;
    String type;
    String race;

    static constraints = {
    }
}
