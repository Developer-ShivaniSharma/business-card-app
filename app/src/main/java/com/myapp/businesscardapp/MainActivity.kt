package com.myapp.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard("Jennifer Doe", "Android Developer")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(text: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Header(
            title = text,
            description = subtitle,
            image = painterResource(R.drawable.android_logo),
            modifier = modifier
                .weight(7f)
                .align(Alignment.CenterHorizontally)
        )

        ContactInfo(
            phone = "1234567890",
            handle = "@socialmediahandle",
            email = "businessCard@gmail.com",
            modifier = modifier
                .weight(3f)
                .padding(16.dp)
        )
    }
}

@Composable
fun ContactInfo(phone: String, handle: String, email: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        ContactInformationItem(image = Icons.Filled.Call, text = phone)
        ContactInformationItem(image = Icons.Filled.Share, text = handle)
        ContactInformationItem(image = Icons.Filled.Email, text = email)
    }
}


@Composable
fun Header(title: String, description: String, image: Painter, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xFF073042))
                .size(96.dp, 96.dp)
                .padding(10.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = title,
            fontSize = 36.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF006B37)
        )
    }
}

@Composable
fun ContactInformationItem(image: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row {
        Icon(
            imageVector = image,
            contentDescription = null,
            modifier = Modifier.padding(9.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(9.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            text = "Jennifer Doe",
            subtitle = "Android Developer",
            modifier = Modifier
                .padding(16.dp)
                .background(Color(0xFFD2E8D4))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessHeaderPreview() {
    BusinessCardAppTheme {
        Header(
            title = "Jennifer Doe",
            description = "Android Developer",
            image = painterResource(R.drawable.android_logo),
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoPreview() {
    BusinessCardAppTheme {
        ContactInfo(
            phone = "1234567890",
            handle = "@socialmediahandle",
            email = "businessCard@gmail.com",
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoItemPreview() {
    BusinessCardAppTheme {
        ContactInformationItem(image = Icons.Filled.Call, text = "+91 93158 29342")
    }
}