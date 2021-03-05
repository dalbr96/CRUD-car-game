import React, { useState } from 'react'
import ReactDOM from 'react-dom'
import PartialResultsView from './PartialResultsView'


const HOST_API = "http://localhost:8080/api"
let colorList = [];

const CreatePlayerView = (props) => {

    const [players, setPlayers] = useState([]);

    const startGame = (event) => {

        event.preventDefault();

        var playerListEntity = [];

        for (let i in players) {
            const player = players[i];

            playerListEntity.push({
                name: player,
            })

        }

        for (var i = 0; i < playerListEntity.length; i++) {

            const playerName = playerListEntity[i].name;

            const color = colorList[i];

            const request = {
                name: playerName
            }

            fetch(`${HOST_API}/player`, {
                method: "POST",
                body: JSON.stringify(request),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(response => {
                    response.gameId = props.gameId;
                    response.color = color;
                    response.distance = 0;

                    const request = {
                        playerName: playerName,
                        playerId: response.id,
                        gameId: props.gameId,
                        partialDistance: response.distance,
                        color: response.color
                    }

                    fetch(`${HOST_API}/partial-result`, {
                        method: "POST",
                        body: JSON.stringify(request),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                        .then(response => response.json())
                        .then(response => {
                            console.log(response)
                        })

                })

        }
        ReactDOM.render(<PartialResultsView gameId={props.gameId} />, document.getElementById("app-container"))
    }

    const submitForm = (event) => {
        setPlayers({ ...players, [event.target.name]: event.target.value })
    }

    const submitColor = (event) => {
        colorList.push(event.target.value)
        console.log(colorList)
    }

    var playerList = []

    for (let i = 1; i <= props.players; i++) {
        playerList.push(
            <div key={i}>
                <div className="mb-3 row">
                    <label className="form-label">{`Jugador ${i}`}</label>
                    <div className="col">
                        <input type="text" className="form-control" name={`player${i}`} onInput={submitForm} ></input>
                    </div>
                    <div className="col">
                        <select defaultValue="Color" name={`player${i}`} className="form-select" aria-label="Default select example" onChange={submitColor}>
                            <option value="Black">Black</option>
                            <option value="Red">Red</option>
                            <option value="White">White</option>
                            <option value="Blue">Blue</option>
                            <option value="Green">Green</option>
                        </select>
                    </div>

                </div>
            </div>
        )
    }

    return (
        <div className="container p-3 form-container">
            <form onSubmit={startGame}>
                {playerList}
                <div className="button-container">
                    <button type="submit" className="btn btn-primary">Empezar Juego</button>
                </div>
            </form>
        </div>
    )

}

export default CreatePlayerView