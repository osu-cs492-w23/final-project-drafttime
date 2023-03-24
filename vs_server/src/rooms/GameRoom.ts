import { Room, Client } from "colyseus";
import { MyState } from "./schema/MyState";

export class GameRoom extends Room<MyState> {
  onCreate() {
    var state = new MyState()
    this.setState(state)
    setInterval(() => {

      state.boo = !state.boo
      this.maxClients = 2

//       console.log(state.boo)

    }, 1000)

  }
  onJoin(client: Client, options: any) {
    console.log("Client joined ", client.id)
    console.log("////////////////////////////////////////////")
  }

  onLeave(client: Client, consented: boolean) {
    console.log("Client left ", client.id)
  }
}
