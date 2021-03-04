import React, {useState} from 'react'

const CreatePlayerView = () =>{

    const [players, setPlayers] = useState();

    const startGame = (event) => {
        event.preventDefault();

        console.log(players);
    };
    
    const submitForm = (event) =>{       

        setPlayers({...players, [event.target.name]: event.target.value})
    }

    return(
        <div className="container p-3 form-container">
            <form onSubmit = {startGame}>
                <div className="mb-3">
                    <label className="form-label">Jugador 1</label>
                    <input type="text" className="form-control" name = "player1" onChange={submitForm}></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Jugador 2</label>
                    <input type="text" className="form-control" name = "player2" onChange={submitForm}></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Jugador 3</label>
                    <input type="text" className="form-control" name = "player3" onChange={submitForm}></input>
                </div>
                <div className = "button-container">
                    <button type = "submit" className="btn btn-primary">Empezar Juego</button>
                </div>
            </form>
        </div>
    )

}

export default CreatePlayerView