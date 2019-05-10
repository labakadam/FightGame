package Entity.Enemies

import Entity.Entity
import Entity.Player
import Weapons.Abstract.Weapon
import Weapons.Main.Sword

class Warior (

    health:Int = 30,
    damage: Int = 10,
    weapon: Weapon = Sword()

):Entity(health,weapon,damage) {
    override fun firstPlayer(ammount: Int) {
        Player.health -= ammount
    }

    override fun enemyPlayer(ammount: Int, entitet: Entity) {
        health -= ammount
    }
}