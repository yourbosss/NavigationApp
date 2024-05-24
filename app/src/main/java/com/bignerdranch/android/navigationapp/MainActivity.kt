package com.bignerdranch.android.navigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController//управление между переменными.
    private lateinit var appBarConfiguration: AppBarConfiguration//управление кнопки назад и бок меню
    private lateinit var drawerLayout: DrawerLayout//боковое меню
    private lateinit var navigationView: NavigationView// отображение элементов в бок меню

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragmentContainerView)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        navigationView.setupWithNavController(navController)// связывает NavigationView (боковое меню) с NavController (
        // контроллером навигации) в приложении Android, использующем Navigation Component.

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }//AppBarConfiguration - это класс, который определяет поведение панели действий в контексте навигации.
    //создает экземпляр AppBarConfiguration с двумя параметрами:
    //navController.graph: граф навигации, связанный с navController. Это определяет пункты назначения, доступные для навигации.
    //drawerLayout: экземпляр DrawerLayout, представляющий боковое меню в приложении. Это позволяет панели действий управлять кнопкой открытия бокового меню.

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
//Метод onSupportNavigateUp() переопределяется в коде для обработки нажатия
// на кнопку "назад" в панели действий (app bar) приложения Android, использующего Navigation Component.
//al navController = findNavController(R.id.fragmentContainerView) находит контроллер навигации (NavController) по идентификатору fragmentContainerView.
// Это необходимо, потому что navController не доступен напрямую в этом методе.
//Если navController не может выполнить навигацию назад, метод возвращает super.onSupportNavigateUp(). Э
// то вызывает стандартную обработку нажатия на кнопку "назад" для дальнейше обработки.
