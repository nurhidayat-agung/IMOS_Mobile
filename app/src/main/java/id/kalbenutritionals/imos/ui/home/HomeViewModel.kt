package id.kalbenutritionals.imos.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import id.kalbenutritionals.imos.base.BaseViewModel
import id.kalbenutritionals.imos.base.OnError
import id.kalbenutritionals.imos.base.OnLoading
import id.kalbenutritionals.imos.base.ShowNews
import id.kalbenutritionals.imos.repository.NewsRepository
import id.kalbenutritionals.imos.model.News
import id.kalbenutritionals.imos.utils.extensions.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

class HomeViewModel(private val repo: NewsRepository) : BaseViewModel() {

    private lateinit var newsList: MutableList<News>

    fun getNews() {
        if (this::newsList.isInitialized) {
            liveDataState.value = ShowNews(newsList)
            return
        }

        newsList = mutableListOf()

        disposables.add(
                repo.getNews()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            liveDataState.value = OnLoading(true)
                        }
                        .doOnComplete {
                            liveDataState.value = OnLoading(false)
                        }
                        .subscribe({
                            this.newsList.addAll(it)
                            liveDataState.value = ShowNews(newsList)
                        }, this::onError)
        )
    }

    private fun onError(t: Throwable) {
        liveDataState.value = OnError(t.localizedMessage)
        t.printStackTrace()
        logE(t.message)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        dispose()
    }
}