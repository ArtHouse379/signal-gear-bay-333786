package umza.connectivity.signalgearbay.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import umza.connectivity.signalgearbay.data.entity.OrderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Query("SELECT * FROM orders")
    fun observeAll(): Flow<List<OrderEntity>>

    @Insert
    suspend fun save(orderEntity: OrderEntity): Long
}
