package cn.cuzlab.search.dsl

interface Builder<T> {
    fun build(): T
}