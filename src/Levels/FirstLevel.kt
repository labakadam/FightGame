package Levels

import Entity.Enemies.Warior
import Entity.Player
import Game.dice
import Weapons.Main.Bow
import Weapons.Main.Sword


var dValue:Int = 0

fun first(){

    Player.heal()
    println("Game start")
    println("-----------------")
    Wait()
    println("You are in the forest")
    Wait()
    println("You walk through the forest, in front of your old city..but also you hear some voices..")
    Wait()

    println("A:Going into the old city..")
    println("B:Going where you hear voices..")
    println("Pick something.. (pick 'A' or 'B')")
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()){
        "A"-> { Forest()}
        "B" -> { Whispering()
        }
        else->{
            println("Pick again, you did not pick A or B")
            Wait()
            first()
        }

    }
    Wait()
    println("")





}

fun Forest() {

    println("Coming to the door")
    Wait()
    println("here is your enemy....")
    Wait()
    println("A: take the sword and attack him")
    println("B: run..")
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()){
        "A" -> {
            val Enemies : Array<Warior> = Array(3){ Warior() }

            Player.weapon = Sword()
            Player.health
            Player.PlayerHealth()
            println("Enemy is ready to fight")
            Wait()
            println("start fighting")
            Wait()
            dValue = dice()
            when{
                dValue<4 -> {
                    println("first attack")
                    Enemies[0].firstPlayer(Enemies[0].damage)
                    Wait()
                    println("fail")
                    Enemies[1].firstPlayer((Enemies[1].damage))
                    Wait()
                    println("finish him")
                    Enemies[2].firstPlayer(Enemies[2].damage)
                    Wait()
                    Player.PlayerHealth()
                }

            }
            println("first miss")
            Wait()
            Player.ultyAttack = true
            println("you have ekstra power")
            Wait()
            for(enemy in Enemies) Player.enemyPlayer(Player.weapon.damage,enemy)
            println("he is finished")
            Wait()
            Player.PlayerHealth()
            Secound()
        }
        "B" -> {
            Runn()}

        else->{
            println("it's not good, try again")
            Wait()
            DarkForest()
            println("")
        }
    }


}

fun Whispering() {

    println("You come to group of people")
    Wait()
    println("They noticed you..")
    println("In your hands you have arrow and sword")
    Wait()
    println("What are you going to take..")
    println("A: ..a sword")
    println("B: ..or shoot him with the arrow")
    Wait()
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()) {
        "A" -> {
            Player.weapon = Sword()
        }
        "B" -> {
            Player.weapon = Bow()
        }
        else -> {
            Runn()
        }
    }
    println("you take ${Player.weapon.type}")
    Wait()
    println("you take ${Player.weapon.type} and attack")
    println("fight start")
    println("enemy hits you")
    Wait()
    Player.Injury()
    Player.PlayerHealth()
    Wait()
    println("you take down one and try to run")
    Wait()
    println("A: kill others?")
    println("B: runn")
    println("Pick")
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()){

        "A" -> Suicide()
        "B" -> Forest()
        else ->
        {
            println("run from everything")
            Runn()
            Wait()
        }

    }




}
fun DarkForest() {


    println("you take a rest")
    Player.Rest()
    Wait()
    Player.PlayerHealth()
    println("here is a big hause")
    Wait()
    println("somebody is inside")
    Wait()
    println("here is you enemy")
    Wait()
    println("A: attack")
    println("B: runn..")
    Player.decision.add(readLine() ?: "empty")
    when(Player.decision.last()){
        "A" -> {
            val Enemies : Array<Warior> = Array(3){ Warior() }

            Player.weapon = Sword()
            Player.health
            Player.PlayerHealth()
            println("battle begin")
            Wait()
            println("start fight")
            Wait()
            dValue = dice()
            when{
                dValue<4 -> {
                    println("first attack")
                    Enemies[0].firstPlayer(Enemies[0].damage)
                    Wait()
                    println("you missed")
                    Enemies[1].firstPlayer((Enemies[1].damage))
                    Wait()
                    println("he is finished")
                    Enemies[2].firstPlayer(Enemies[2].damage)
                    Wait()
                    Player.PlayerHealth()
                }

            }
            println("miss")
            Wait()
            Player.ultyAttack = true
            println("you got a extra power")
            Wait()
            for(enemy in Enemies) Player.enemyPlayer(Player.weapon.damage,enemy)
            println("he is dead")
            Wait()
            Player.PlayerHealth()
            Secound()
        }
        "B" -> {
            Runn()}

        else->{
            println("pick again")
            Wait()
            Forest()
            println("")
        }
    }

}
fun Suicide() {

    Player.PlayerHealth()
    println("You still have couple of enemies alive")
    println("One is killed you..")
    Wait()
    Player.Injury()
    Player.PlayerHealth()
    println("Game over!")
    println("You have lost your life")
    Wait()
    println()
    first()

}

fun Runn() {
    println("You have lost your life")
    println("You must try again..")
    Wait()
    first()
}

fun Wait(time: Long = 4000){
    Thread.sleep(time)
}