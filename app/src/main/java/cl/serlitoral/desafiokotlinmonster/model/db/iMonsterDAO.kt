package cl.serlitoral.desafiokotlinmonster.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.serlitoral.desafiokotlinmonster.model.Monster

@Dao
interface iMonsterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMonster(monster: Monster)

    @Query("SELECT * FROM monster_table ORDER BY name ASC")
    fun getAllMonsters(): LiveData<List<Monster>>

    @Query("DELETE FROM monster_table")
    fun deleteAllMonsters()
}