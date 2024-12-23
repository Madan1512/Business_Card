package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
              Surface(
                  modifier = Modifier
                      .fillMaxSize()

              ){
                  BackGround(painterResource(R.drawable.background), modifier = Modifier)
                }
            }
        }
    }

}
@Composable
fun UserDetails(
    image:Painter,
    name:String,
    role: String,
    text1:String,
    text2:String,
    text3:String,
    modifier:Modifier=Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier=modifier
                .padding(20.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            )

        Text(
            text = role,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            modifier = modifier
                .padding(start = 50.dp, end = 50.dp)
        )

        Column(
            modifier=modifier
                .padding(25.dp)
        ){
            AboutMeCard(text=text1,)
            AboutMeCard(text=text2,)
            AboutMeCard(text=text3,modifier=Modifier.padding(end = 25.dp))

            }
        SocialIcons()
    }

}
@Composable
fun SocialIcons()
{
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
    ){
        Icon(
            Icons.Rounded.Email,
            contentDescription = "Email Icon",
            modifier = Modifier.size(45.dp),
            tint = Color.White
            )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            Icons.Rounded.Call,
            contentDescription = "Call Icon",
            modifier = Modifier.size(45.dp),
            tint = Color.White
            
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            Icons.Rounded.Share,
            contentDescription = "Share Icon",
            modifier = Modifier.size(45.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            Icons.Rounded.Close,
            contentDescription = "Close Icon",
            modifier = Modifier.size(45.dp),
            tint = Color.White


        )
    }
}
@Composable
fun AboutMeCard(text:String,modifier:Modifier=Modifier)
{
    Row(
        modifier=modifier
            .padding(10.dp)

    ) {


        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .padding(
                    start = 50.dp,
                    end = 50.dp,
                    top = 20.dp,
                    bottom = 20.dp
                )
        )
    }

}

@Composable
fun BackGround(bgimage:Painter,modifier: Modifier=Modifier)
{
    Box{
        Image(
            painter = bgimage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()


        )
        UserDetails(
            image = painterResource(R.drawable.download),
            name = stringResource(R.string.full_name),
            role = stringResource((R.string.role)),
            text1 = stringResource(R.string.profile_text1),
            text2 = stringResource(R.string.profile_text2),
            text3 = stringResource(R.string.profile_text3),

        )

    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
       BackGround(painterResource(R.drawable.background), modifier = Modifier)
    }
}