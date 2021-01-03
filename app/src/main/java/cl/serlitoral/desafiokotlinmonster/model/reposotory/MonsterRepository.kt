package cl.serlitoral.desafiokotlinmonster.model.reposotory

import android.app.Application
import androidx.lifecycle.LiveData
import cl.serlitoral.desafiokotlinmonster.model.Monster
import cl.serlitoral.desafiokotlinmonster.model.db.MonsterDatabase
import cl.serlitoral.desafiokotlinmonster.model.db.MonsterDatabase.Companion.getDatabase
import cl.serlitoral.desafiokotlinmonster.model.db.iMonsterDAO

class MonsterRepository(application: Application?, private var monsterDao: iMonsterDAO): iRepository {
    private val monsterLDList: LiveData<List<Monster>>

    override fun saveMonster(monster: Monster) {
        MonsterDatabase.databaseWriteExcecutor.execute {
            monsterDao.insertMonster(monster)
        }
    }

    override fun getAllMonster(): LiveData<List<Monster>> {
        return monsterLDList
    }

    override fun clearAllMonster() {
        MonsterDatabase.databaseWriteExcecutor.execute {
            monsterDao.deleteAllMonsters()
        }
    }

    init {
        val db = getDatabase(application!!)
        monsterDao = db.monsterDao()
        monsterLDList = monsterDao.getAllMonsters()
    }
}