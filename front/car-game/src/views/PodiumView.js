import React from 'react'

const PodiumView = (props) => {
    return (
        <div>
            <h2>Ganadores</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Primer Lugar</th>
                        <th scope="col">Segundo Lugar</th>
                        <th scope="col">Tercer Lugar</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{props.podium.firstPlayerName}</td>
                        <td>{props.podium.secondPlayerName}</td>
                        <td>{props.podium.thirdPlayerName}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default PodiumView
