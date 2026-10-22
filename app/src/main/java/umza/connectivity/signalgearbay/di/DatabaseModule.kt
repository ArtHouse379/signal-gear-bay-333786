package umza.connectivity.signalgearbay.di

import androidx.room.Room
import umza.connectivity.signalgearbay.data.database.RAGDEAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "ragde_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = RAGDEAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<RAGDEAppDatabase>().cartItemDao() }

    single { get<RAGDEAppDatabase>().orderDao() }
}