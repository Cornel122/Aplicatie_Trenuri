import Rezervare from "../components/Rezervare";
import Ruta from "../components/Ruta";

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

        </div>
    );
}

export default ClientPage;