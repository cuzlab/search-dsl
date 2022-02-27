package cn.cuzlab.search.dsl

import kotlin.test.Test

class TermTest {

    @Test
    fun `test simple term`() {
        val query =
            searchDSL {
                query {
                    term {
                        "name" {
                            value = "张三"
                        }
                    }
                }
            }

        query dsl_as """
            {
              "query": {
                "term": {
                  "name": {
                    "value": "张三"
                  }
                }
              }
            }
        """
    }
}