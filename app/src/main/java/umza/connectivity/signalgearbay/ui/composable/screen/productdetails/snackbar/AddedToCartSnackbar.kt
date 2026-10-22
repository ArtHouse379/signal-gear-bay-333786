package umza.connectivity.signalgearbay.ui.composable.screen.productdetails.snackbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import umza.connectivity.signalgearbay.R
import umza.connectivity.signalgearbay.ui.theme.LocalDimens

private val IconSize = 20.dp
private val SnackbarElevation = 6.dp

private val DefaultBottomGap = 8.dp

@Composable
fun AddedToCartSnackbar(
    visible: Boolean,
    modifier: Modifier = Modifier,
    bottomGap: Dp = DefaultBottomGap,
) {
    val dimens = LocalDimens.current

    AnimatedVisibility(
        visible = visible,
        modifier = modifier,
        enter = slideInVertically { height -> height } + fadeIn(),
        exit = slideOutVertically { height -> height } + fadeOut(),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.screenPadding)
                .padding(bottom = bottomGap),
            shape = RoundedCornerShape(dimens.cardCornerRadius),
            color = MaterialTheme.colorScheme.inverseSurface,
            contentColor = MaterialTheme.colorScheme.inverseOnSurface,
            shadowElevation = SnackbarElevation,
        ) {
            Row(
                modifier = Modifier.padding(dimens.cardPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(IconSize),
                )

                Spacer(modifier = Modifier.width(dimens.itemSpacing))

                Text(
                    text = stringResource(R.string.product_details_snackbar_added_to_cart),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
