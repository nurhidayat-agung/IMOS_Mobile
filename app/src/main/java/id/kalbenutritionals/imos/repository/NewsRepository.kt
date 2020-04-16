package id.kalbenutritionals.imos.repository

import id.kalbenutritionals.imos.network.ApiService
import id.kalbenutritionals.imos.model.News
import io.reactivex.Observable

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

class NewsRepository(val api: ApiService) {

    fun getNews(): Observable<List<News>> {
        return api.getNews()
            .flatMapIterable {
                it.articles
            }
            .map {
                News(
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt,
                    author = it.author
                )
            }
            .toList()
            .toObservable()
    }
}