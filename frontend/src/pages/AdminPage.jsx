import TrenCrud from "../components/TrenCrud";
import RutaCrud from "../components/RutaCrud";
import RezervariTren from "../components/RezervariTren";
import IntarziereTren from "../components/IntarziereTren";

function AdminPage({ utilizator, logout }) {

    return (

        <div className="container">

            <div className="header">

                <h1>Administrator</h1>

                <button onClick={logout}>
                    Logout
                </button>

            </div>

            <p>Logat ca: {utilizator.nume}</p>

            <TrenCrud />

            <RutaCrud />

            <RezervariTren />

            <IntarziereTren />

        </div>
    );
}

export default AdminPage;