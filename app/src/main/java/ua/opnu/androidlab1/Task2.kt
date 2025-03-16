package ua.opnu.androidlab1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Task2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordScrambleGame()
        }
    }
}

@Composable
fun WordScrambleGame() {
    val wordList = listOf("android", "kotlin", "compose", "studio", "developer")
    var currentWord by remember { mutableStateOf(wordList.random()) }
    var scrambledWord by remember { mutableStateOf(currentWord.toCharArray().apply { shuffle() }.concatToString()) }
    var userGuess by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Guess the Word!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Scrambled Word: $scrambledWord", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = userGuess,
            onValueChange = { userGuess = it },
            label = { Text("Your Guess") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (userGuess.text.equals(currentWord, ignoreCase = true)) {
                message = "Correct! Starting new game..."
                currentWord = wordList.random()
                scrambledWord = currentWord.toCharArray().apply { shuffle() }.concatToString()
                userGuess = TextFieldValue()
            } else {
                message = "Wrong! Try Again."
            }
        }) {
            Text("Submit")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message, fontSize = 16.sp)
    }
}
