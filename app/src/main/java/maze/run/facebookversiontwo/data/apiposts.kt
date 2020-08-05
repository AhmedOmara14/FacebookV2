package maze.run.facebookversiontwo.data

import io.reactivex.Observable
import maze.run.facebookversiontwo.pojo.Posts
import retrofit2.Call
import retrofit2.http.GET

interface apiposts {
    @GET("/posts")
    fun getposts(): Observable<List<Posts>>
}