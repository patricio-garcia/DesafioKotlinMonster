package cl.serlitoral.desafiokotlinmonster.model.db

import androidx.room.TypeConverter
import cl.serlitoral.desafiokotlinmonster.model.MonsterAttributes
import java.util.*

class MonsterAttributesConverter {
    @TypeConverter
    fun fromCreatureAttributes(attributes: MonsterAttributes?): String? {
        if (attributes != null) {
            return String.format(
                Locale.US,
                "%d,%d,%d",
                attributes.intelligence,
                attributes.ugliness,
                attributes.evilness
            )
        }
        return null
    }

    @TypeConverter
    fun toCreatureAttributes(value: String?): MonsterAttributes? {
        if (value != null) {
            val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return MonsterAttributes(
                java.lang.Integer.parseInt(pieces[0]),
                java.lang.Integer.parseInt(pieces[1]),
                java.lang.Integer.parseInt(pieces[2])
            )
        }
        return null
    }
}