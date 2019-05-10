package Levels

import Entity.Enemies.Hunter
import Entity.Player


fun Secound(){
    println()
    println("You killed your enemy..")
    Wait()
    println("There is a few people and offer you a help..")
    Wait()
    println("They were stuck in some old buildings")
    Player.PlayerHealth()
    Wait()
    println("They take weapons")
    Wait()
    println("Then they give you some food..")
    Player.Rest()
    println("'Somebody is out there'-they said, 'We are going to help them'")
    Wait()
    println("What are you going to do..")
    println("A: Save them..")
    println("B: or you going to run with them..")
    Wait()
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()){

        "A" -> {
            println("")
            Wait()
            Player.PlayerHealth()
            Wait()
            println("You are going to save them, and then you are find some new enemies..")
            Wait()
            println("Enemies are very dangerous an you must pick something, will you run or will you fight?")
            Wait()
            println("A: Attack them..")
            println("B: Run..")
            Wait()
            Player.decision.add(readLine() ?: "empty")
            when(Player.decision.last()){

                "A" -> {

                    println("")
                    println("You are pick an attack..")
                    Wait()
                    val Friends : Array<Hunter> = Array(4){ Hunter() }
                    Friends.forEach { it.firstPlayer(Friends[0].weapon.damage) }
                    Wait()
                    println("Friends just kill your enemies..")
                    Wait()
                    println("you are injured..")
                    Player.Rest()
                    Player.PlayerHealth()
                    Wait()
                    println("You are now going to kill all your enemies..")
                    Wait()
                    println("Friend hits enemy with arrow..")
                    Wait()
                    println("You are attacking him....")
                    Wait()
                    println("Finish him..")
                    Player.ultyAttack = true
                    println("Enemy is dead..")
                    Wait()
                    println("Friends were very helpful..")
                    for(friends in Friends) Player.enemyPlayer(Player.weapon.damage,friends)
                    Wait()
                    println("Your are good player..")
                    Player.PlayerHealth()
                    Wait()
                    println("Win is all yours..")

                }
                "B" -> {
                    GoOut()}

            }


        }
        "B"->{GoOut()}
        else -> {
            println("Pick again, you did not pick good..")
            Wait()
            Secound()
            println("")
        }



    }


}

fun GoOut() {

    println("You are going to the wild..")
    Wait()
    println("Game over..")

}
