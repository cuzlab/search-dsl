package cn.cuzlab.search.dsl

class QueryBuilder : Builder<Query> {
    private var term: Term? = null

    override fun build(): Query = Query(term)

    fun term(block: TermBuilder.() -> Unit) {
        term = TermBuilder().apply(block).build()
    }
}

data class Query(val term: Term?) : QueryDSL {
    override fun toDSL(): String {
        return """{"term":${term?.toDSL()}}"""
    }
}