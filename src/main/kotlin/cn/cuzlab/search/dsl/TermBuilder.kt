package cn.cuzlab.search.dsl

class TermBuilder : Builder<Term> {
    private var values = mutableMapOf<String, TermValue>()

    operator fun String.invoke(data: TermValue.() -> Unit) {
        values[this] = TermValue().apply(data)
    }

    override fun build(): Term = Term(values)
}

data class Term(val values: MutableMap<String, TermValue>) : QueryDSL {
    override fun toDSL(): String {
        val sb = StringBuilder()
        sb.append("{")
        var count = values.count()
        for ((key, value) in values) {
            sb.append(""""$key":${value.toDSL()}""")
            if (--count > 0) {
                sb.append(",")
            }
        }
        sb.append("}")

        return sb.toString()
    }
}


class TermValue : QueryDSL {
    var value: String = ""
    var boost: Float? = null

    override fun toDSL(): String {
        val valuePair = """"value":"$value""""
        val boostPair = if (boost == null) "" else ""","boost":$boost"""

        return "{$valuePair$boostPair}"
    }
}