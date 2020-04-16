package id.kalbenutritionals.imos.context

import id.kalbenutritionals.imos.ui.home.HomeViewModel
import org.koin.dsl.module.module

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

val viewModelModule = module {
    single {
        HomeViewModel(get())
    }
}