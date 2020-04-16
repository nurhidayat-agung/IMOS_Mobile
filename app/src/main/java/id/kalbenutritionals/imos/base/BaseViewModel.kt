package id.kalbenutritionals.imos.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

open class BaseViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()
    val liveDataState = MutableLiveData<LiveDataState>()

    protected fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}