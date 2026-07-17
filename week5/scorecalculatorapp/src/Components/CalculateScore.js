import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const { name, school, total, goal } = props;
  const average = (total / goal) * 100;

  return (
    <div className="score-card">
      <h1>Student Score Card</h1>
      <h2>Name: {name}</h2>
      <h2>School: {school}</h2>
      <h2>Total Marks: {total}</h2>
      <h2>Goal Marks: {goal}</h2>
      <h2 className="average">Average Score: {average.toFixed(2)}%</h2>
    </div>
  );
}

export default CalculateScore;