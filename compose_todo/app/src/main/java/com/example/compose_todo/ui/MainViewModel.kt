package com.example.compose_todo.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose_todo.model.TodoData

class MainViewModel : ViewModel() {
    private var _text = MutableLiveData("")
    var text :LiveData<String>?= _text
    val setText : (String) -> Unit ={
        _text.value =it
    }
    var todoList = mutableStateListOf<TodoData>()

    val onSubmit: (String) -> Unit = {
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(TodoData(key = key, text = text.value.toString()))
    }

    val onToggle: (Int, Boolean) -> Unit = { key, check ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList.set(i, todoList.get(i).copy(done = check))
    }

    val onEdit : (Int, String) -> Unit = { key, text ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList.set(i, todoList.get(i).copy(text=text))
    }

    val onDelete : (Int) -> Unit = {key ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList.removeAt(i)
    }

}