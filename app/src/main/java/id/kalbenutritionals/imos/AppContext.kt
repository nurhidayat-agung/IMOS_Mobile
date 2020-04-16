package id.kalbenutritionals.imos

import android.app.Application
import id.kalbenutritionals.imos.context.networkModule
import id.kalbenutritionals.imos.context.repositoryModule
import id.kalbenutritionals.imos.context.viewModelModule
import org.koin.android.ext.android.startKoin

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(networkModule, repositoryModule, viewModelModule))
    }
}