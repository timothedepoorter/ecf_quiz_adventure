import React, {useState} from 'react';
import Question from './components/Question';
import Player from "./components/Player";


function App() {
    const [player, setPlayer] = useState(null);
    return (
      <div>
        <header>
          <h1>Quiz Adventure</h1>
        </header>
        <main>
            <main>
                {player ? (
                    <Question player={player}/>
                ) : (
                    <Player setPlayer={setPlayer}/>
                )}
            </main>
        </main>
      </div>
    );
}

export default App;