package com.example.testfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testfigma.ui.theme.TestFigmaTheme

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon : Int) {
    object Home : Screen("home", R.string.home_bottom, R.drawable.iconamoon_home)
    object search : Screen("search", R.string.search_bottom, R.drawable.ri_search_line)
    object down : Screen("down", R.string.search_bottom, R.drawable.ri_search_line)
    object filed: Screen("filed", R.string.filed_bottom, R.drawable.ci_folder)
    object  account: Screen("account", R.string.account_bottom, R.drawable.iconamoon_profile_bold)
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val listBottom = listOf(Screen.Home,Screen.search, Screen.filed, Screen.account)
            TestFigmaTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = {
                        BottomNavigation(backgroundColor = Color.White, modifier = Modifier.background(
                            Color.Black
                        )
                            .height(76.dp)
                            .border(
                                0.2.dp,
                                Color.Black,
                                RoundedCornerShape(10,10,30,30)
                            )
                            .clip(RoundedCornerShape(10,10,30,30))
                    ) {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        listBottom.forEachIndexed{index,screen ->
                            if (index == 2){
                                BottomNavigationItem(
                                    selected = false,
                                    onClick = { /*TODO*/ },
                                    icon = { /*TODO*/ })
                            }
                            BottomNavigationItem(
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true, onClick = { navController.navigate(screen.route)}
                                , icon = { Image(painter = painterResource(id = screen.icon), contentDescription = null) }
                                , modifier = Modifier.fillMaxHeight()
                                , unselectedContentColor = Color.Transparent

                            )

                        }
                    }
            }
                    , floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.White, shape = RoundedCornerShape(90.dp)) {
                            Image(painter = painterResource(id = R.drawable.frame_7), contentDescription = null)
                        }
                    }
                    , floatingActionButtonPosition = FabPosition.Center
                    , isFloatingActionButtonDocked = true
                    , scaffoldState = rememberScaffoldState()

                )
                {
                    NavHost(navController = navController, startDestination = Screen.Home.route, Modifier.padding(it) ){
                        composable(route = Screen.Home.route){
                            Home()
                        }
                        composable(route = Screen.search.route){
                            Home()
                        }

                        composable(route = Screen.filed.route){
                            Home()
                        }
                        composable(route = Screen.account.route){
                            Home()
                        }

                    }

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestFigmaTheme {

    }
}