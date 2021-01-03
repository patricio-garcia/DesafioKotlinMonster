package cl.serlitoral.desafiokotlinmonster.view.monsteravatars

import cl.serlitoral.desafiokotlinmonster.R
import cl.serlitoral.desafiokotlinmonster.model.MonsterImage

object MonsterStore {
    val MONSTERS_IMAGE: List<MonsterImage> by lazy {
        val monsters = mutableListOf<MonsterImage>()

        monsters.add(MonsterImage(R.drawable.asset01))
        monsters.add(MonsterImage(R.drawable.asset02))
        monsters.add(MonsterImage(R.drawable.asset03))
        monsters.add(MonsterImage(R.drawable.asset04))
        monsters.add(MonsterImage(R.drawable.asset05))
        monsters.add(MonsterImage(R.drawable.asset06))

        monsters
    }
}