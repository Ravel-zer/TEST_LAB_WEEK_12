package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "d8002cfa64b035e1255aa1a79dd81aac"

    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            emit(movieService.getPopularMovies(apiKey).results)
        }.flowOn(Dispatchers.IO)
    }
}