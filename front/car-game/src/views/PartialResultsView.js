import React, { useEffect, useState } from 'react'

const PartialResultsView = (props) => {

    const HOST_API = "http://localhost:8080/api"

    let partialResults = []
    const [gameStarted, setGameStarted] = useState(false);

    let runGame = async () => {
        setGameStarted(true);
        fetch(`${HOST_API}/${props.gameId}/run-game/`)
            .then(response => response.json())
            .then(response => console.log(response))
    };

    const bringInformation = () => {
        fetch(`${HOST_API}/partial-result/game/${props.gameId}`)
            .then(response => response.json())
            .then(response => partialResults =response)
    }


    useEffect(() => {

        setInterval(bringInformation, 1000)
        if(!gameStarted){
            runGame();
        }

        

    })

    return (
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">Jugador</th>
                    <th scope="col">Color</th>
                    <th scope="col">Distancia</th>
                </tr>
            </thead>
            <tbody>
                {partialResults.map((result) => {
                    return (
                        <tr key={result.playerId}>
                            <td>{result.playerName}</td>
                            <td>{result.color}</td>
                            <td>{result.partialDistance}</td>
                        </tr>
                    )
                })}

            </tbody>
        </table>)

}

export default PartialResultsView;