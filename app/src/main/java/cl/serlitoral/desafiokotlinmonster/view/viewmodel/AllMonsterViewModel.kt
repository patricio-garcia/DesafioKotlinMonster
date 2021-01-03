package cl.serlitoral.desafiokotlinmonster.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.serlitoral.desafiokotlinmonster.model.Monster
import cl.serlitoral.desafiokotlinmonster.model.reposotory.MonsterRepository
import cl.serlitoral.desafiokotlinmonster.model.reposotory.iRepository

class AllMonsterViewModel(private val repository: iRepository): ViewModel() {
    private val allMonsterLiveData = repository.getAllMonster()
    fun getAllMonsterLiveData(): LiveData<List<Monster>> = allMonsterLiveData
    fun clearAllCreatures() = repository.clearAllMonster()
}
