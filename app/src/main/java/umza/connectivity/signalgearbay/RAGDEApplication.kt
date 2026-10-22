package umza.connectivity.signalgearbay

import android.app.Application
import umza.connectivity.signalgearbay.di.dataModule
import umza.connectivity.signalgearbay.di.dispatcherModule
import umza.connectivity.signalgearbay.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class RAGDEApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@RAGDEApplication)
            modules(appModules)
        }
    }
}
