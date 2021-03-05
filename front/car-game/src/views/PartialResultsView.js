import React, { useEffect, useState } from 'react'
import PodiumView from './PodiumView'

const PartialResultsView = (props) => {

    const HOST_API = "http://localhost:8080/api"

    const [partialResults, setPartialResults] = useState([])
    const [gameStarted, setGameStarted] = useState(false);
    const [gameEnded, setGameEnded] = useState(false);
    const [podium, setPodium] = useState([])

    let runGame = async () => {
        setGameStarted(true);
        fetch(`${HOST_API}/${props.gameId}/run-game/`)
            .then(response => response.json())
            .then(response => {
                setGameEnded(true);
                setPodium(response);
                console.log(response)
            })
    };

    const bringInformation = () => {
        fetch(`${HOST_API}/partial-result/game/${props.gameId}`)
            .then(response => response.json())
            .then(response => {setPartialResults(response)})
    }


    useEffect(() => {

        setTimeout(bringInformation, 1000)

        if (!gameStarted) {
            runGame();
        }



    })

    return (
        <div>
            <table className="table" key="PartialResults">
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
            </table>
            {gameEnded && <PodiumView podium = {podium} key="Podium"/>}
        </div>


    )

}

export default PartialResultsView;