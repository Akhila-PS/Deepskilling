import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        name="Akhil Sharma" 
        school="DeepSkilling Academy" 
        total={450} 
        goal={500} 
      />
    </div>
  );
}

export default App;