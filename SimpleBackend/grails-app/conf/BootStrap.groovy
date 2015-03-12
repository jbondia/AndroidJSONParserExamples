import simplebackend.Armor
import simplebackend.Character

class BootStrap {

    def init = { servletContext ->
        def ch = new Character(gold: 823759375435L, level: 100, name: "Arakina", type: "Death Knigth", race: "Gobblin")
        ch.save()

        def armor1 = new Armor(level: 676, name: "Molten Edge Eviscerator")
        def armor2 = new Armor(level: 456, name: "Thunder maze")
        def armor3 = new Armor(level: 668, name: "The Black Hand")
        def armor4 = new Armor(level: 778, name: "Gar\'an\'s Brutal Spearlauncher")
        def armor5 = new Armor(level: 566, name: "Oregorger\'s Acid-Etched Gutripper")

        ch.addToArmors(armor1)
        ch.addToArmors(armor2)
        ch.addToArmors(armor3)
        ch.addToArmors(armor4)
        ch.addToArmors(armor5)
    }
    def destroy = {
    }
}
