package Game

import Entity.Entity


interface Interaction {
    fun firstPlayer(ammount:Int)
    fun enemyPlayer(ammount:Int, entitet:Entity )
}