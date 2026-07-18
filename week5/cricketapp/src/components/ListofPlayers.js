import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "KL Rahul", score: 45 },
        { name: "Shubman Gill", score: 91 },
        { name: "Hardik Pandya", score: 60 },
        { name: "Ravindra Jadeja", score: 72 },
        { name: "R Ashwin", score: 65 },
        { name: "Mohammed Shami", score: 58 },
        { name: "Jasprit Bumrah", score: 88 },
        { name: "Mohammed Siraj", score: 40 },
        { name: "Kuldeep Yadav", score: 75 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <ul>
                {
                    players.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

            <h2>Players with Score Below 70</h2>

            <ul>
                {
                    lowScorePlayers.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

        </div>
    );
}

export default ListofPlayers;