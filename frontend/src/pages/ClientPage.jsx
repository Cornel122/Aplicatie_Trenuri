import Rezervare from "../components/Rezervare";
import Ruta from "../components/Ruta";
import Recomandare from "../components/Recomandare";

function ClientPage({ utilizator, logout }) {

    return (

        <div className="container">

            <div className="header">

                <h1>Client</h1>

                <button onClick={logout}>
                    Logout
                </button>

            </div>

            <p>
                Logat ca: {utilizator.nume}
            </p>

            <Rezervare utilizator={utilizator} />

            <Ruta />

            <Recomandare />

        </div>
    );
}

export default ClientPage;