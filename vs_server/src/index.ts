/**
 * IMPORTANT: 
 * ---------
 * Do not manually edit this file if you'd like to use Colyseus Arena
 * 
 * If you're self-hosting (without Arena), you can manually instantiate a
 * Colyseus Server as documented here: 👉 https://docs.colyseus.io/server/api/#constructor-options 
 */
// import { listen } from "@colyseus/arena";

// Import arena config
// import arenaConfig from "./arena.config";

// Create and listen on 2567 (or PORT environment variable.)
// listen(arenaConfig);

// Colyseus + Express
// import { Server } from "colyseus";
import { createServer } from "http";
// import express from "express";

import http from "http";
import express from "express";
import cors from "cors";
import { matchMaker, Server } from "colyseus";
import { monitor } from "@colyseus/monitor";

import { GameRoom } from "./rooms/GameRoom";


// const port = Number(process.env.port) || 3000;
const port = 4166;

const app = express();
app.use(express.json());

const gameServer = new Server({
  server: createServer(app)
});

// gameServer.listen(port);

  app.get("/", (req, res) => {
            res.send("Server is up and running");
  });

// gameServer.define("my_room", GameRoom);
gameServer.define("my_room", GameRoom);



// matchMaker.createRoom()
// matchMaker.createRoom("my_room", {}).then(room => console.log(room));


app.use("/colyseus", monitor());

gameServer.listen(port);
console.log(`Listening on ws://localhost:${ port }`)