import { useEffect, useState } from "react";
import api from "../api";

function Rezervare({ utilizator }) {

    const [trenuri, setTrenuri] = useState([]);

    const [trenId, setTrenId] = useState("");
    const [emailClient, setEmailClient] = useState("");
    const [numarBilete, setNumarBilete] = useState(1);

    const [mesaj, setMesaj] = useState("");

    useEffect(() => {
        incarcaTrenuri();
    }, []);

    const incarcaTrenuri = async () => {

        const response = await api.get("/trenuri");

        setTrenuri(response.data);
    };

    const rezerva = async () => {

        try {

            const response = await api.post("/rezervari", {

                utilizatorId: utilizator.id,
                trenId,
                emailClient,
                numarBilete

            });

            setMesaj(response.data);

        } catch (e) {

            setMesaj("Eroare la rezervare");
        }
    };

    return (

        <div className="card">

            <h2>Rezervare bilete</h2>

            <select
                value={trenId}
                onChange={(e) => setTrenId(e.target.value)}
            >

                <option value="">
                    Alege tren
                </option>

                {trenuri.map((tren) => (

                    <option key={tren.id} value={tren.id}>

                        {tren.numarTren}
                        {" "}-
                        {" "}capacitate {tren.capacitate}

                    </option>

                ))}

            </select>

            <button onClick={incarcaTrenuri}>
                Refresh trenuri
            </button>

            <input
                placeholder="Email client"
                value={emailClient}
                onChange={(e) => setEmailClient(e.target.value)}
            />

            <input
                type="number"
                placeholder="Numar bilete"
                value={numarBilete}
                onChange={(e) => setNumarBilete(e.target.value)}
            />

            <button onClick={rezerva}>
                Rezerva
            </button>

            <p className="message">
                {mesaj}
            </p>

        </div>
    );
}

export default Rezervare;