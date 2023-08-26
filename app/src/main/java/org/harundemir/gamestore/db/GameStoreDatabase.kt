package org.harundemir.gamestore.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.harundemir.gamestore.db.dao.CartDao
import org.harundemir.gamestore.models.Cart
import org.harundemir.gamestore.utils.Converters

@Database(
    entities = [Cart::class], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GameStoreDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: GameStoreDatabase? = null

        fun getDatabase(context: Context): GameStoreDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, GameStoreDatabase::class.java, "game_store_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}