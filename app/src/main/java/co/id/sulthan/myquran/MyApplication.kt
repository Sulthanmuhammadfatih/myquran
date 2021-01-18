package co.id.sulthan.myquran

import android.app.Application
import co.id.sulthan.core.di.databaseModule
import co.id.sulthan.core.di.mapperModule
import co.id.sulthan.core.di.networkModule
import co.id.sulthan.core.di.repositoryModule
import co.id.sulthan.myquran.di.useCaseModule
import co.id.sulthan.myquran.di.vieModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule ,
                    repositoryModule,
                    useCaseModule ,
                    vieModelModule,
                    mapperModule
                )
            )
        }
    }
}