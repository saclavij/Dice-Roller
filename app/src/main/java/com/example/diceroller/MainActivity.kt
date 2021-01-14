package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/* This activity allows the user to roll a dice and view the result
* on the screen
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create a Button variable based on the ButtonView
        val rollButton: Button = findViewById(R.id.button)
        // listening for click
        rollButton.setOnClickListener { rollDice() }
        //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        //toast.show()}
        //roll the dice once
        diceImage = findViewById(R.id.imageView)
        diceImage2 = findViewById(R.id.imageView2)
        rollDice()
    }
    /* Roll the dice and update the screen with the result.
    *
     */
    private fun rollDice() {
        // create a Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        //find the imageView on the layout for dice
        //val diceImage: ImageView = findViewById(R.id.imageView)

        //find the imageView on the layout for dice2
        //val diceImage2: ImageView = findViewById(R.id.imageView2)

        //determine which drawable resource ID to use based on the dice roll
        val drawableResource =  when (diceRoll){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //determine which drawable resource ID to use based on the dice roll
        val drawableResource2 =  when (diceRoll2){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //update the imageView with the correct drawable resource ID for dice
        diceImage.setImageResource(drawableResource)
        //update the imageView with the correct drawable resource ID for dice2
        diceImage2.setImageResource(drawableResource2)
        //update the content description for dice and dice2
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

    }
}
// Dice class to roll the dice
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}