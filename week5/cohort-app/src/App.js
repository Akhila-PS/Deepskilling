import CohortDetails from "./components/CohortDetails";
import cohorts from "./cohorts";

function App() {
    return (
        <div>
            <h1>Cohort Dashboard</h1>

            {cohorts.map((cohort, index) => (
                <CohortDetails
                    key={index}
                    cohort={cohort}
                />
            ))}
        </div>
    );
}

export default App;