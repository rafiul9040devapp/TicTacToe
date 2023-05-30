package com.rafiul.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.rafiul.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buttonClicked(view: View) {

        var cellID = 0
        val selectedButton = view as Button

        when (selectedButton.id) {

//            binding.button1Row1.toString().toInt() -> cellID = 1

            //why can't is use bindind
            R.id.button1Row1 -> cellID = 1
            R.id.button2Row1 -> cellID = 2
            R.id.button3Row1 -> cellID = 3
            R.id.button4Row2 -> cellID = 4
            R.id.button5Row2 -> cellID = 5
            R.id.button6Row2 -> cellID = 6
            R.id.button7Row3 -> cellID = 7
            R.id.button8Row3 -> cellID = 8
            R.id.button9Row3 -> cellID = 9

        }

        playGame(cellID, selectedButton)

//        Log.d("buttonClicked",selectedButton.id.toString())
//        Log.d("buttonClicked",cellID.toString())
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, selectedButton: Button) {

        if (activePlayer == 1) {
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.drawable.player1box)
            player1.add(cellId)
            activePlayer = 2
        } else {
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.drawable.player2box)
            player2.add(cellId)
            activePlayer = 1
        }

        selectedButton.isEnabled = false

        checkWinner()

    }

    fun checkWinner() {
        var winner = -1

        //row1 winner
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row2 winner
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row3 winner
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column1 winner
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column2 winner
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column3 winner
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal1 winner
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //diagonal2 winner
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }


        if (winner == 1) {
            Toast.makeText(this, "Player1 Wins....", Toast.LENGTH_LONG).show()
        } else if (winner == 2) {
            Toast.makeText(this, "Player2 Wins....", Toast.LENGTH_LONG).show()
        }

    }
}