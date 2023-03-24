package com.example.drafttime.data
import io.colyseus.annotations.SchemaField
import io.colyseus.serializer.schema.Schema
import io.colyseus.util.default

class MyState : Schema() {
    @SchemaField("0/boolean")
    var boo = Boolean.default
}
