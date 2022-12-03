package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//class MainViewModel @Inject constructor() : ViewModel() {
//}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    internal val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preference: Preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            preference.hoge = true
            binding.textView.text = "True"
        }

        binding.button2.setOnClickListener {
            preference.hoge = false
            binding.textView.text = "False"
        }

        binding.textView.text =
            if (preference.hoge) "True"
            else "False"
    }
}