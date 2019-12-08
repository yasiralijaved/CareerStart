package com.careerstart.app.ui.student.ui.myprojects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyProjectViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "The list of all Projects"
    }
    val text: LiveData<String> = _text
}