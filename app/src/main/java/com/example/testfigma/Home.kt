package com.example.testfigma

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


sealed class Map(val name: String, val icon : Int, val color: Color) {
    object math : Map("Math", R.drawable.iconamoon_home, Color(0xFF3FF421.toInt()))
    object medicin : Map("Medicin", R.drawable.ri_search_line, Color(0xFFF7C846.toInt()))
    object it : Map("It",  R.drawable.ri_search_line, Color(0xFFFC574E.toInt()) )
    object busines: Map("Busines", R.drawable.ci_folder, Color(0xFFC08EFF.toInt()))
}
@Preview
@Composable
fun Home (){
    val list = listOf(Map.math,Map.medicin,Map.it,Map.busines)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(start = 20.dp, end = 20.dp) ) {
        Text(text = "Subject Map"
            , modifier = Modifier.padding(top = 56.dp)
            , color = Color.White
            , fontSize = 36.sp
            , fontWeight = FontWeight(800)
        )
        Box( modifier = Modifier
            .size(36.dp)
            .align(alignment = Alignment.End)) {
            Image(painter = painterResource(id = R.drawable.vector)
                , contentDescription = null

            )
        }

        ItemHobbySelected(list)
        Text(text ="Recent Dowloaded", color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(top = 20.dp, bottom = 30.dp)
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            itemRecent(name = "Giải tích", color = Color(0xFF99EF83.toInt()) )
            itemRecent(name = "Ngôn Ngữ C", color = Color(0xFF8AFEE2.toInt()))
        }

    }






}

@Composable
fun itemRecent(name: String, color:Color){
    Column(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .border(0.dp, Color.Transparent, RoundedCornerShape(20.dp))
        .size(160.dp, 130.dp)
        .background(color)
        .padding(15.dp)

    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)){
            Image(painter = painterResource(id = R.drawable.tabler_math_max), contentDescription = null,
                modifier = Modifier.align(Alignment.TopCenter))
            Image(painter = painterResource(id = R.drawable.tabler_math_max), contentDescription = null,
                modifier = Modifier.align(Alignment.BottomCenter)
            )

            Image(painter = painterResource(id = R.drawable.tabler_math_max), contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Image(painter = painterResource(id = R.drawable.tabler_math_max), contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        Text(text = name,
            fontWeight = FontWeight(600),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        )
    }
}
@Composable
fun ItemHobbySelected(list: List<Map>){
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        columns = GridCells.Fixed(2)){
        items(items = list) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(0.dp, Color.Transparent, RoundedCornerShape(20.dp))
                    .height(80.dp)
                    .background(it.color)
                    .padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(42.dp)
                )
                Text(
                    text = it.name,
                    color = Color.White,
                    fontSize = 24.sp,
                    maxLines = 1,

                    )
            }
        }
    }
}