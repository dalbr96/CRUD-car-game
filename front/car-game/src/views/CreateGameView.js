import React, { useState } from 'react'
import ReactDOM from 'react-dom';
import CreatePlayerView from './CreatePlayerView'

const HOST_API = "http://localhost:8080/api"

const CreateGameView = () => {

    const [numberOfPlayers, setNumberOfPlayers] = useState(0)
    const [distance, setDistance] = useState(0)



    const create = (event) => {

        event.preventDefault();

        const request = {
            numberOfPlayers: numberOfPlayers,
            distance: distance
        }

        fetch(`${HOST_API}/game`, {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(response => {
                console.log(response)
                ReactDOM.render(<CreatePlayerView players = {response.numberOfPlayers} gameId = {response.id}/>, document.getElementById("app-container"))
            })
    }

    return (
        <div className="container p-3 form-container">
            <form>
                <div className="mb-3">
                    <label className="form-label">Numero de Jugadores</label>
                    <input type="number" min="3" className="form-control" id="players" onChange={(event) => {
                        setNumberOfPlayers(event.target.value)
                    }}></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Distancia</label>
                    <input type="number" min="1" className="form-control" id="distance" onChange={(event) => {
                        setDistance(event.target.value)
                    }}></input>
                </div>
                <div className="button-container">
                    <button className="btn btn-primary" onClick={create}>Enviar</button>
                </div>
            </form>
        </div>
    )
}

export default CreateGameView;