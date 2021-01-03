package cl.serlitoral.desafiokotlinmonster.model

data class AttributeValue(val name: String = "", val value: Int = 0) {
    override fun toString() = "$name: $value"
}