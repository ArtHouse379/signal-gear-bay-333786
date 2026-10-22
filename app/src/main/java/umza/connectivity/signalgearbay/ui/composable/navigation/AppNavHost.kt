package umza.connectivity.signalgearbay.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import umza.connectivity.signalgearbay.ui.composable.screen.cart.RAGDECartScreen
import umza.connectivity.signalgearbay.ui.composable.screen.checkout.RAGDECheckoutScreen
import umza.connectivity.signalgearbay.ui.composable.screen.home.RAGDEHomeScreen
import umza.connectivity.signalgearbay.ui.composable.screen.onboarding.RAGDEOnboardingScreen
import umza.connectivity.signalgearbay.ui.composable.screen.order.RAGDEOrdersScreen
import umza.connectivity.signalgearbay.ui.composable.screen.productdetails.RAGDEProductDetailsScreen
import umza.connectivity.signalgearbay.ui.composable.screen.settings.RAGDESettingsScreen
import umza.connectivity.signalgearbay.ui.composable.screen.splash.RAGDESplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            RAGDESplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            RAGDEOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            RAGDEHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            RAGDEProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            RAGDECartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            RAGDECheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            RAGDEOrdersScreen()
        }

        composable<NavRoute.Settings> {
            RAGDESettingsScreen()
        }
    }
}