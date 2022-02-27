package cn.cuzlab.search.dsl

class SearchDSLBuilder : Builder<SearchDSL> {
    private var query: Query? = null

    override fun build(): SearchDSL = SearchDSL(query)

    fun query(block: QueryBuilder.() -> Unit) {
        query = QueryBuilder().apply(block).build()
    }
}

data class SearchDSL(val query: Query?) : QueryDSL {
    override fun toDSL(): String {
        return """{"query":${query?.toDSL()}}"""
    }
}

fun searchDSL(dsl: SearchDSLBuilder.() -> Unit): SearchDSL {
    return SearchDSLBuilder().apply(dsl).build()
}