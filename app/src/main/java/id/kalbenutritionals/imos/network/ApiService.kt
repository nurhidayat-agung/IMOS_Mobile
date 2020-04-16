package id.kalbenutritionals.imos.network

import id.kalbenutritionals.imos.network_model.NewsResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

interface ApiService {

    @GET("top-headlines?country=id")
    fun getNews(): Observable<NewsResponseModel>
}