# Search-DSL
类型安全的Elasticsearch Query DSL。

一种简单、快速且更接近原生Elasticsearch Query DSL的方式创建查询，在kibana中创建的Query DSL通过简单的转换就能使用。

类型安全、直观、零认知负担。

# 快速开始

```kotlin
//kotlin
```


# 示例

## Term

### Query DSL

```json
//GET _search
{
  "query": {
    "term": {
      "name": {
        "value": "张三"
      }
    }
  }
}
```

### Search DSL

```kotlin
searchDSL {
    query {
        term {
            "name" {
                value = "张三"
            }
        }
    }
}
```

### Java Client（HLRC）

```java
SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
searchSourceBuilder.query(QueryBuilders.termQuery("name", "张三"));
```

# Roadmap

## 进度

1. - [x] 新建文件夹 
