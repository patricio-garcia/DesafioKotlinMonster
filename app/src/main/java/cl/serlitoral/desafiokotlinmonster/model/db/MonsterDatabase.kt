package cl.serlitoral.desafiokotlinmonster.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.serlitoral.desafiokotlinmonster.model.Monster
import java.util.concurrent.Executors

@Database(entities = [Monster::class], version = 1)
@TypeConverters(MonsterAttributesConverter::class)
abstract class MonsterDatabase: RoomDatabase() {
    abstract fun monsterDao(): iMonsterDAO

    companion object {
        private var INSTANCE: MonsterDatabase? = null
        const val NUMBER_OF_THREADS = 5

        @JvmField
        val databaseWriteExcecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        @JvmStatic
        fun getDatabase(context: Context): MonsterDatabase {
            if (INSTANCE == null) {
                synchronized(MonsterDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room
                            .databaseBuilder(
                                context.applicationContext,
                                MonsterDatabase::class.java,
                                "monster_db"
                            )
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}