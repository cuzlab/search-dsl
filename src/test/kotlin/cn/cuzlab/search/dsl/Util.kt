package cn.cuzlab.search.dsl

import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.test.assertEquals

val objectMapper = ObjectMapper()
fun json_zip(json: String): String = objectMapper.readTree(json).let { objectMapper.writeValueAsString(it) }

infix fun <T : QueryDSL> T.dsl_as(json: String) {
    assertEquals(json_zip(this.toDSL()), json_zip(json))
}