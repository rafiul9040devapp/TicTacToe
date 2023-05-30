package com.rafiul.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.rafiul.tictactoe.databinding.ActivityGameBinding
import com.rafiul.tictactoe.databinding.WinnerDialogBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
//    private lateinit var binding2: WinnerDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
//        binding2 = WinnerDialogBinding.inflate(layoutInflater)
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
    var selectedButtonCount = 0

    private fun playGame(cellId: Int, selectedButton: Button) {

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
        selectedButtonCount++

        checkWinner(selectedButtonCount)

    }

    private fun checkWinner(buttonCount: Int) {
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

        if (winner==1 && buttonCount<=9){
            showTheResult("Player 1 win the Game")
        }else if (winner==2 && buttonCount<=9){
            showTheResult("Player 2 win the Game")
        }else if(winner ==-1 && buttonCount==9){
            showTheResult("Match Drawn...")
        }

//        else if(winner==-1){
//            showTheResult("MATCH DRAW...")
//        }


//        if (winner==1){
//            val dialog = Dialog(this)
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            dialog.setCancelable(false)
//            dialog.setContentView(R.layout.winner_dialog)
//            dialog.findViewById<TextView>(R.id.winnerTV).text= "Player 1 win the Game"
//
//            dialog.findViewById<Button>(R.id.playAgainBtn).setOnClickListener{
//                val intent = Intent(this,GameActivity::class.java)
//                finish() //removes all the information of past
//                startActivity(intent)
//            }
//
//            dialog.findViewById<Button>(R.id.exitBtn).setOnClickListener{
//                val intent = Intent(this,StartActivity::class.java)
//                startActivity(intent)
//            }
//
//            dialog.show()
//        }else if(winner==2){
//           showTheResult("Player 2 win the Game")
//        }


//        if (winner == 1) {
//            Toast.makeText(this, "Player1 Wins....", Toast.LENGTH_LONG).show()
//        } else if (winner == 2) {
//            Toast.makeText(this, "Player2 Wins....", Toast.LENGTH_LONG).show()
//        }

    }

    private fun showTheResult(winner:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.winner_dialog)
        dialog.findViewById<TextView>(R.id.winnerTV).text= winner

        dialog.findViewById<Button>(R.id.playAgainBtn).setOnClickListener{
            val intent = Intent(this,GameActivity::class.java)
            finish() //removes all the information of past
            startActivity(intent)
        }

        dialog.findViewById<Button>(R.id.exitBtn).setOnClickListener{
            val intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

}