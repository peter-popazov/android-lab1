package ua.opnu.androidlab1

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.compose.foundation.Image;
import androidx.compose.foundation.background;
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.painterResource;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;

class Task1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                BirthdayCard("Alex")
            }
        }
    }
}

@Composable
fun BirthdayCardTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFFD84315),
            background = Color(0xFFFFE0B2)
        ),
        content = content
    )
}

@Composable
fun BirthdayCard(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE0B2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cake),
            contentDescription = "Birthday Cake",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Happy Birthday, $name!",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD84315)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Wishing you all the happiness and joy on your special day!",
            fontSize = 20.sp,
            color = Color(0xFF6D4C41)
        )
    }
}
