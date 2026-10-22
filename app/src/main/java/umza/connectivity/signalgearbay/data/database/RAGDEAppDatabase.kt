package umza.connectivity.signalgearbay.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import umza.connectivity.signalgearbay.data.database.dao.CartItemDao
import umza.connectivity.signalgearbay.data.database.dao.OrderDao
import umza.connectivity.signalgearbay.data.database.converter.Converters
import umza.connectivity.signalgearbay.data.entity.CartItemEntity
import umza.connectivity.signalgearbay.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RAGDEAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}