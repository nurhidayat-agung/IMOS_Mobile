package id.kalbenutritionals.imos.base

import id.kalbenutritionals.imos.model.News

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

sealed class LiveDataState

data class ShowNews(val news: List<News>) : LiveDataState()
data class OnLoading(val show: Boolean) : LiveDataState()
data class OnError(val msg: String) : LiveDataState()