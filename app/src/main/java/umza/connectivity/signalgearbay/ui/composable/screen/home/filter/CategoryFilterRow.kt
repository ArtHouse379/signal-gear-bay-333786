package umza.connectivity.signalgearbay.ui.composable.screen.home.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import umza.connectivity.signalgearbay.R
import umza.connectivity.signalgearbay.data.model.ProductCategory
import umza.connectivity.signalgearbay.ui.theme.LocalDimens

@Composable
fun CategoryFilterRow(
    selectedCategory: ProductCategory?,
    modifier: Modifier = Modifier,
    onCategoryClick: (ProductCategory?) -> Unit,
) {
    val dimens = LocalDimens.current

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimens.screenPadding),
        horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
    ) {
        item {
            CategoryChip(
                isSelected = selectedCategory == null,
                title = stringResource(R.string.ragde_category_all),
                onClick = { onCategoryClick(null) },
            )
        }

        items(items = ProductCategory.entries) { category ->
            CategoryChip(
                isSelected = selectedCategory == category,
                title = stringResource(category.titleRes),
                onClick = { onCategoryClick(category) },
            )
        }
    }
}

@Composable
private fun CategoryChip(
    isSelected: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = { Text(text = title) },
        modifier = modifier,
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = isSelected,
            borderColor = MaterialTheme.colorScheme.outlineVariant,
            selectedBorderColor = MaterialTheme.colorScheme.secondary,
            borderWidth = dimens.controlBorderWidth,
            selectedBorderWidth = dimens.controlBorderWidth,
        ),
    )
}
