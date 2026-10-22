package umza.connectivity.signalgearbay.di

import umza.connectivity.signalgearbay.ui.viewmodel.AppViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.CartViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.CheckoutViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.OnboardingViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.OrderViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.ProductDetailsViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.ProductViewModel
import umza.connectivity.signalgearbay.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}