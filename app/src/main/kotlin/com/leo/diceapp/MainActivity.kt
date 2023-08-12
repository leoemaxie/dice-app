package com.leo.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.util.Log
import com.leo.diceapp.databinding.ActivityMainBinding

/**
 * This activity allows users to roll dice and view their result
 */
public class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set content view to binding's root
        setContentView(binding.root)
        val button: Button = findViewById<Button>(R.id.btn)
        
        // adds an onClickListener to roll the dice and display the result to screen
	    button.setOnClickListener {
            rollDice()
			Toast.makeText(this, "You've rolled the dice!", Toast.LENGTH_SHORT).show()
		}
        // roll the dice oncreate
        rollDice()
    }    
    
    /**
     * Roll the dice and update the result to the screen
     */
	private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
	    val image: ImageView = findViewById<ImageView>(R.id.img)
        val drawableResource =  when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //update the image view with the resource id
        image.setImageResource(drawableResource)
        // update the content description
        image.contentDescription = diceRoll.toString()
	}
}

/**
 * Dice with a fixed number of sides
 */
class Dice(private val numSides: Int) {
    
    /**
     * Generate a random number from 1 to 6
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}