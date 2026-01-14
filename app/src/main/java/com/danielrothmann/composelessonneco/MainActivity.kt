package com.danielrothmann.composelessonneco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //MyColumn()
            //MyLazyColumn()
            //MyLazyListColumn()
            //MyLazyListRow()
            //ListPersons()
            //ListPersonsColor()
            ListStudent()
        }
    }
}

@Preview
@Composable
private fun ListStudent() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        itemsIndexed(student) { index, student ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "${index + 1}. ${student.name}",
                        fontSize = 24.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Возраст: ${student.age}",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
private fun ListPersonsColor() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        itemsIndexed(people) { index, person ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text(
                    text = "${index + 1}. ${person.name}",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .background(color = Color.DarkGray)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = "Возраст: ${person.age}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun ListPersons() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {
        itemsIndexed(people) { index, person ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "${index + 1}. ${person.name}")
                Text(text = "Возраст: ${person.age}")
            }
        }
    }

}

@Composable
private fun MyLazyListColumn() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {
        itemsIndexed( // два элемнта: индекс и элемент
            listOf(
                "Start",
                "Item 1",
                "Item 2",
                "Item 3",
                "End"
            ) // принимет любые списки и коллекции, data классы
        ) { index, item -> // index - индекс (позиция в списке), item - элемент (значение)
            Text(
                text = item,
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }

}

@Composable
private fun MyLazyListRow(){ //LazyRow уже сам управляет горизонтальной прокруткой.
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        itemsIndexed( // два элемнта: индекс и элемент
            listOf("Start","Item One", "Item 2", "Item Next", "End", "TestScrollHorizontal")
        ) {_, item ->
            Text(
                text = item,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }
    }

}


@Composable
private fun MyLazyColumn() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {
        items(count = 100) { // Указание лямбды для каждого элемента //количество элементов в списке
            Text(
                text = "Item $it",
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
private fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    )
    {
        for (i in 1..100) {
            Text(
                text = "Item $i",
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 4.dp)

            )
        }
    }
}

data class Person(
    val id: Int,
    val name: String,
    val age: Int
)

data class Student(
    val name: String,
    val age: Int
)

// Список людей
val people = listOf(
    Person(1, "Анна", 25),
    Person(2, "Иван", 30),
    Person(3, "Мария", 28)
)

// Список студентов
val student = listOf(
    Student("Anna", 25),
    Student("Jon", 30),
    Student("Harry", 28),
    Student("Alex", 35),
    Student("Mister Cat", 2)
)







