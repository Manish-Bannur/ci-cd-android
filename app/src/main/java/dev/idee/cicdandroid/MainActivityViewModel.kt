package dev.idee.cicdandroid

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MainActivityViewModel : ViewModel() {

    val movieListLiveData = MutableLiveData<List<MovieModel>>()

    open fun getMovieLiveData(): MutableLiveData<List<MovieModel>> {
        return movieListLiveData
    }

    fun setMovieLiveData(movieModelList: List<MovieModel>) {
        movieListLiveData.value = movieModelList
    }

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        APIClient.client.create(ApiInterface::class.java).getPopularMovies("8bc707ec970aa53d70ad42114e472e85")
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e("MainActivityViewModel", t.toString())
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    response.body()?.let {
                        Log.e("MainActivityViewModel >> ", it.movieModelList.size.toString())
                        setMovieLiveData(it.movieModelList)
                    }
                }
            })
    }
}