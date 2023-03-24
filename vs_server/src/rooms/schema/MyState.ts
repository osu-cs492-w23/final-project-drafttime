import { Schema, type } from "@colyseus/schema";

export class MyState extends Schema {
    @type("boolean")
    boo: boolean = false
}
