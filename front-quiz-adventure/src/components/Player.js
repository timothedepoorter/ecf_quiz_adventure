// src/components/Player.js
import React, { useState } from 'react';
import axios from 'axios';

const Player = ({ setPlayer }) => {
    const [username, setUsername] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/player', { username, highscore: 0 });
            setPlayer(response.data);
        } catch (err) {
            setError('Erreur lors de la création du joueur.');
            console.error(err);
        }
    };

    return (
        <div>
            <h2>Entrez votre pseudonyme</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                />
                <button type="submit">Commencer</button>
            </form>
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </div>
    );
};

export default Player;
