package umza.connectivity.signalgearbay.di

import umza.connectivity.signalgearbay.data.repository.CartRepository
import umza.connectivity.signalgearbay.data.repository.OnboardingRepository
import umza.connectivity.signalgearbay.data.repository.OrderRepository
import umza.connectivity.signalgearbay.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}