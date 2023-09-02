package org.harundemir.gamestore.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.db.dao.OrderItemsDao
import org.harundemir.gamestore.db.dao.OrdersDao
import org.harundemir.gamestore.models.CartItem
import org.harundemir.gamestore.models.Order
import org.harundemir.gamestore.models.OrderItem
import org.harundemir.gamestore.utils.Converters

@Database(
    entities = [CartItem::class, Order::class, OrderItem::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GameStoreDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
    abstract fun ordersDao(): OrdersDao
    abstract fun orderItemsDao(): OrderItemsDao

    companion object {
        @Volatile
        private var INSTANCE: GameStoreDatabase? = null

        fun getDatabase(context: Context): GameStoreDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GameStoreDatabase::class.java,
                    "game_store_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}