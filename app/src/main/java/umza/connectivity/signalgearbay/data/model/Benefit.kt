package umza.connectivity.signalgearbay.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Router
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Default.Verified,
        text = "Business-grade quality",
    ),
    Benefit(
        icon = Icons.Default.Shield,
        text = "Two-year warranty",
    ),
    Benefit(
        icon = Icons.Default.Router,
        text = "Network essentials",
    ),
)
