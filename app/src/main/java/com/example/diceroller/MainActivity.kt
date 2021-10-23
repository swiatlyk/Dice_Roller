package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add action to click the button with id = button
        val rollButton: Button = findViewById(R.id.button)

        //action to listen when user tap/click the button, display toast message and use rollDice method
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            rollDice()
        }
        // Do a dice roll when the app starts
        rollDice()

    }

    /**
     * Method for creating an object from class Dice
     * Using roll() method
     * Displaying it in textView with id testView
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.diceView)
        //diceImage.setImageResource(R.drawable.dice_2)
//        when (diceRoll) {
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //appropriate content description on the ImageView for screen readers
        diceImage.contentDescription = diceRoll.toString()
    }

    /**
     * Class for dice with method roll which take random number from 1 to numSides of dice
     */
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}