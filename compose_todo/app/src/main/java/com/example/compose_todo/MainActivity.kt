package com.example.compose_todo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_todo.model.TodoData
import com.example.compose_todo.ui.MainViewModel
import com.example.compose_todo.ui.theme.Compose_todoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_todoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    topLevel()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun todoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = text,
            onValueChange = onTextChange
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = { onSubmit(text) }
        ) {
            Text(text = "등록하기")
        }
    }
}

@JvmOverloads
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun topLevel(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {


    Scaffold {
        Column(
            modifier= Modifier.padding(12.dp)
        ) {
            todoInput(text = viewModel.text.observeAsState().value.toString(), onTextChange = { viewModel.text.value =it}, onSubmit = viewModel.onSubmit)
            LazyColumn {
                items(viewModel.todoList) {
                    todo(
                        todoData = it,
                        onToggle = viewModel.onToggle,
                        onEdit = viewModel.onEdit ,
                        onDelete = viewModel.onDelete
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun todo(
    todoData: TodoData,
    onToggle: (Int, Boolean) -> Unit,
    onEdit: (Int, String) -> Unit,
    onDelete :(Int) ->Unit
) {
    var isEditing = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
    }
    Crossfade(targetState = isEditing.value, label = "") {
        when (it) {
            false -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = todoData.text, modifier = Modifier.weight(1f))
                    Text(text = "완료")
                    Checkbox(
                        checked = todoData.done,
                        onCheckedChange = { checked ->
                            onToggle(todoData.key, checked)
                        })
                    Button(onClick = { isEditing.value = true }) {
                        Text(text = "수정")
                    }
                    Button(onClick = { onDelete(todoData.key) }) {
                        Text(text = "삭제")
                    }
                }
            }

            true -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val (newText, setNewText) = remember {
                        mutableStateOf(todoData.text)
                    }
                    OutlinedTextField(
                        value = newText,
                        onValueChange = setNewText,
                        modifier = Modifier.weight(1f)
                    )
                    Button(onClick = {
                        onEdit(todoData.key, newText)
                        isEditing.value=false
                    }) {
                        Text(text = "완료")
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Compose_todoTheme {
        todoInput(text = "청소하기", onTextChange = {}, onSubmit = { null })
    }
}

@Preview(showBackground = true)
@Composable
fun topLevelPreview() {
    Compose_todoTheme {
        topLevel()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun todoPreivew() {
//    Compose_todoTheme {
//        todo(TodoData(key = 1, text = "테스트", done = false), onToggle = { key, check ->
//            null
//        }, onEdit = {}, onDelete = {})
//    }
//}
