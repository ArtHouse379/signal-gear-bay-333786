package umza.connectivity.signalgearbay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import umza.connectivity.signalgearbay.ui.composable.approot.AppRoot
import umza.connectivity.signalgearbay.ui.theme.RAGDEAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RAGDEAppTheme {
                AppRoot()
            }
        }
    }
}
