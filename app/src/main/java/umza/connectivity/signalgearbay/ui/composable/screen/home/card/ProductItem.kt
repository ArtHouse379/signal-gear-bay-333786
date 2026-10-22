package umza.connectivity.signalgearbay.ui.composable.screen.home.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import umza.connectivity.signalgearbay.R
import umza.connectivity.signalgearbay.data.model.Product
import umza.connectivity.signalgearbay.ui.composable.screen.shared.ProductImage
import umza.connectivity.signalgearbay.ui.theme.LocalDimens
import umza.connectivity.signalgearbay.ui.theme.cardBorderStroke
import umza.connectivity.signalgearbay.ui.theme.imageBorder

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onAddToCartClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        ProductImage(
            imageUrl = product.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .imageBorder(RectangleShape),
        )

        Row(
            modifier = Modifier.padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = stringResource(product.category.titleRes),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )

                Spacer(modifier = Modifier.height(dimens.itemSpacing))

                Text(
                    text = stringResource(R.string.price, product.price),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Button(
                onClick = onAddToCartClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Text(text = stringResource(R.string.button_add_to_cart_label))
            }
        }
    }
}
