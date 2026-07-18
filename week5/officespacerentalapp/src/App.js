import "./App.css";

function App() {

  const offices = [
    {
      name: "Smart Workspace",
      rent: 55000,
      address: "Bangalore",
      image: "/images/office1.avif"
    },
    {
      name: "Tech Park Office",
      rent: 75000,
      address: "Hyderabad",
      image: "/images/office2.avif"
    },
    {
      name: "Business Hub",
      rent: 62000,
      address: "Chennai",
      image: "/images/office3.avif"
    }
  ];

  return (

    <div className="App">

      <h1>Office Space Rental App</h1>

      {
        offices.map((office, index) => (

          <div key={index}>

            <img
              src={office.image}
              alt={office.name}
              width="300"
              height="200"
            />

            <h2>{office.name}</h2>

            <h3
              style={{
                color: office.rent < 60000 ? "red" : "green"
              }}
            >
              Rent : ₹{office.rent}
            </h3>

            <h3>Address : {office.address}</h3>

            <hr />

          </div>

        ))
      }

    </div>

  );

}

export default App;