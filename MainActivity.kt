package com.example.prepare

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.prepare.ui.theme.PrepareTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrepareTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BirthdayGreetingWithImage("Falling Detection", "") {
                        startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                    }
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    val image = painterResource(R.drawable.falling)
    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message,
                fontSize = 36.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = from,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp, end = 16.dp)
                    .align(alignment = Alignment.End)
            )
        }
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Streaming Service")
        }
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    PrepareTheme {
        BirthdayGreetingWithImage("Falling Detection", "") { }
    }
}