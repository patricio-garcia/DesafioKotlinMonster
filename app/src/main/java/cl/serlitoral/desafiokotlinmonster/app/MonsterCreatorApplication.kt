package cl.serlitoral.desafiokotlinmonster.app

import android.app.Application
import androidx.room.Room
import cl.serlitoral.desafiokotlinmonster.model.db.MonsterDatabase

class MonsterCreatorApplication : Application() {

    companion object {
        lateinit var database: MonsterDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, MonsterDatabase::class.java, "monster_database")
            .build()
    }
}