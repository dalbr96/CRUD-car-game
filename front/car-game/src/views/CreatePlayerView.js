import React, { useState } from 'react'


const HOST_API = "http://localhost:8080/api"


const CreatePlayerView = (props) => {

    const [players, setPlayers] = useState([]);
    let colorList = [];
    let partialResults = [];


    const startGame = (event) => {

        event.preventDefault();

        var playerListEntity = [];

        for (var i in players) {

            console.log(i);
            const player = players[i];
            console.log(player)

            playerListEntity.push({
                name: player,
            })

        }

        for(var i=0; i < playerListEntity.length; i++){

            const playerName = playerListEntity[i].name;
            const color = colorList[i];
            partialResults.push({"name": playerName, "color": color})

            console.log(partialResults)

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
                    partialResults.push(response)
                    console.log(partialResults)
                })

        }


        console.log(partialResults)
    };

    const submitForm = (event) => {
        setPlayers({ ...players, [event.target.name]: event.target.value })
    }

    const submitColor = (event) =>{
        colorList.push(event.target.value)
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
                        <select defaultValue ="Color" name={`player${i}`} className="form-select" aria-label="Default select example" onChange={submitColor}>
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