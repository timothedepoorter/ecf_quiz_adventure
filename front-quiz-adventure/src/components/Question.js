// src/components/Question.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Question = ({ player }) => {
    const [question, setQuestion] = useState(null);
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
    const [questions, setQuestions] = useState([]);
    const [score, setScore] = useState(0);

    useEffect(() => {
        const fetchQuestions = async () => {
            try {
                const response = await axios.get('http://localhost:8080/question');
                setQuestions(response.data);
                setQuestion(response.data[0]);
            } catch (error) {
                console.error('Erreur pour obtenir les questions', error);
            }
        };

        fetchQuestions();
    }, []);

    const handleAnswerClick = (answer) => {
        if (answer === question.correctAnswer) {
            setScore(score + 1)
        }
        const nextQuestionIndex = currentQuestionIndex + 1;
        if (nextQuestionIndex < questions.length) {
            setCurrentQuestionIndex(nextQuestionIndex);
            setQuestion(questions[nextQuestionIndex]);
        } else {
            if (score > player.highscore) {
                savePlayerScore();
            }
            // pb -> affiche l'ancien highscore si le score actuel est supérieur
            alert('Quiz terminé! Votre score est de ' + score + ' et votre meilleur score était de ' + player.highscore);
        }
    };

    const savePlayerScore = async () => {
        try {
            await axios.put('http://localhost:8080/player/' + player.id, { ...player, "highscore": score });
        } catch (error) {
            console.error('Erreur lors de l\'enregistrement du score', error);
        }
    };


    if (!question) {
        return <div>Aucune question disponible.</div>;
    }

    return (
        <div>
            <h1>{question.text}</h1>
            <div>
                {question.answer.map((answer, index) => (
                    <button key={index} onClick={() => handleAnswerClick(answer)}>
                        {answer}
                    </button>
                ))}
            </div>
        </div>
    );
};

export default Question;
