package dev.idee.cicdandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dev.idee.cicdandroid.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private val movieAdapter = MovieListAdapter(DiffUtilCallback())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        with(binding.movieRecyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        viewModel.movieListLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            movieAdapter.submitList(it)
        })
    }

}
