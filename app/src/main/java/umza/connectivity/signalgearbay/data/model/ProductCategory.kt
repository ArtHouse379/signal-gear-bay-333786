package umza.connectivity.signalgearbay.data.model

import androidx.annotation.StringRes
import umza.connectivity.signalgearbay.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    ROUTERS(R.string.product_category_routers_title),
    MODEMS(R.string.product_category_modems_title),
    NETWORK_SWITCHES(R.string.product_category_network_switches_title),
    TWO_WAY_RADIOS(R.string.product_category_two_way_radios_title),
}
