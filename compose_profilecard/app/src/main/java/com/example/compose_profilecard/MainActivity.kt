package com.example.compose_profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose_profilecard.ui.theme.Compose_profilecardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_profilecardTheme {
                cardEx(cardData = cardData)

            }
        }

    }
    companion object{
        val cardData = CardData(
            imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
            imageDescription = "엔텔로프 캐논",
            author = "Dalianum",
            description = "엔델로프 내켠은 죽기 전에 꼭 봐야할 절졍으로 소개되었습니다."
        )
    }
}

@Composable
fun cardEx(cardData : CardData){
    Card(
        elevation =  CardDefaults.cardElevation(
            defaultElevation = 10.dp),
        modifier = Modifier.padding(4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = "이미지",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(
            ) {
                Text(text = cardData.author )
                Text(text = cardData.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Compose_profilecardTheme {
        cardEx(cardData = MainActivity.cardData)
    }
}


