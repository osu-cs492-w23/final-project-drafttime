const express = require('express')
const app = express()

const fetch = require('node-fetch')

// /**
//  * Here will be a series of functions to filter the active players into seperate arrays
//  * I may refactor this to the server
//  */


function getNflTeamDataArray() {
  
  

    let nflTeamDataArray = []
  
    let nflTeams = ['ARI', 'ATL', 'BAL', 'BUF', 'CAR', 'CHI', 'CIN', 'CLE', 'DAL', 'DEN', 'DET', 'GB', 'HOU', 'IND', 'JAX', 'KC', 'MIA', 'MIN', 'NE', 'NO', 'NYG', 'NYJ', 'LV', 'PHI', 'PIT', 'LAC', 'SF', 'SEA', 'LAR', 'TB', 'TEN', 'WAS']
     
  
    for (let i = 0; i < nflTeams.length; i++) {
      var team = nflTeams[i];
      
      let nflTeamData = activeNflData.filter((player) => {
        if (player.team === team) {
          return true
        }
        else {
          return false
        }
      })
  
      nflTeamDataArray[i] = nflTeamData
  
    }
  
    // console.log('==nflTeamDataArray: ', nflTeamDataArray)
  
    return nflTeamDataArray
  }


let testData

let processedData

let nflData

let activeNflData

let nflTeamDataArray

app.use(express.json()) // Middleware

/**
 * Functions to organize data
 */

async function getTeamData() {
     
    await callSleeperApi(sleeperData)

    testData =  sleeperData[0]
    
    // console.log("== testData",testData)

    
    processedData = Object.values(testData)


    nflData = processedData.filter((element) => {
        if (element.sport === "nfl") {
            return true
        } else {
            return false
        }
    })

    activeNflData = nflData.filter((element) => {
        if (element.status === "Active") {
            return true
        } else {
            return false
        }
    })

    nflTeamDataArray = getNflTeamDataArray()

    console.log("==nflTeamDataArray: ", nflTeamDataArray)

    
 }


let sleeperData = []

//setup async function to do sleeper api call
async function callSleeperApi(sleeperData) {
    let url = 'https://api.sleeper.app/v1/players/nfl'
    
    let response = await fetch(url)
    
    let body = await response.json();

    sleeperData.push(body) 
    
    return
}
 

/**
 *  API end points
 */
app.get("/players", (req, res) => {
    res.json(sleeperData)
    res.status(200)
})

app.get("/nflTeamDataArray", (req, res) => {
    res.json(nflTeamDataArray)
    res.status(200)
})

app.listen(8080, function () {
    console.log("Server started on port 8080");
    getTeamData()
})