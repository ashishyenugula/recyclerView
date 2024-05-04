package com.ashish.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.ashish.myapplication.databinding.ActivityMainBinding
import com.ashish.myapplication.network.RetrofitClient
import com.ashish.myapplication.repository.MainRepository
import com.ashish.myapplication.utills.MainViewModel
import com.ashish.myapplication.utills.MyViewModelFactory
import com.ashish.myapplication.utills.NetworkUtil


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val retrofitService = RetrofitClient.apiInterface
        val mainRepository = MainRepository(retrofitService)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(mainRepository)
        )[MainViewModel::class.java]


        val adapter = RecyclerViewAdapter()
        binding.recyclerview.adapter = adapter


        if (NetworkUtil.checkConnectivity(this))
            viewModel.getAllImages()
        else
            viewModel.onError("Check Internet Connection..!!")


        viewModel.list.observe(this) {
            adapter.setImages(it)
        }


    }
}