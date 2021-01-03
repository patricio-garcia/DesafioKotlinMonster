package cl.serlitoral.desafiokotlinmonster.model.reposotory

import androidx.lifecycle.LiveData
import cl.serlitoral.desafiokotlinmonster.model.Monster

interface iRepository {
    fun saveMonster(monster: Monster)
    fun getAllMonster(): LiveData<List<Monster>>
    fun clearAllMonster()
}