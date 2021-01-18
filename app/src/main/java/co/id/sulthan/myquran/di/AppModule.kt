package co.id.sulthan.myquran.di

import co.id.sulthan.myquran.ui.ayat.AyatVM
import co.id.sulthan.myquran.ui.surat.SuratVM
import co.id.sulthan.core.domain.usecase.AyatInteractor
import co.id.sulthan.core.domain.usecase.AyatUseCase
import co.id.sulthan.core.domain.usecase.SuratInteractor
import co.id.sulthan.core.domain.usecase.SuratUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<SuratUseCase> { SuratInteractor(get()) }
    factory<AyatUseCase> { AyatInteractor(get()) }
}

val vieModelModule = module {
    single { SuratVM(get()) }
    single { AyatVM(get()) }
}