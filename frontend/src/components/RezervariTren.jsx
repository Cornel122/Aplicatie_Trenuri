import { useEffect, useState } from "react";
import api from "../api";

function RezervariTren() {

    const [trenuri, setTrenuri] = useState([]);

    const [trenId, setTrenId] = useState("");

    const [rezervari, setRezervari] = useState([]);

    useEffect(() => {
        incarcaTrenuri();
    }, []);

    const incarcaTrenuri = async () => {

        const response = await api.get("/trenuri");

        setTrenuri(response.data);
    };

    const veziRezervari = async () => {

        const response =
            await api.get(
                `/admin/trenuri/${trenId}/rezervari`
            );

        setRezervari(response.data);
    };

    return (

        <div className="card">

            <h2>Rezervari tren</h2>

            <select
                value={trenId}
                onChange={(e) => setTrenId(e.target.value)}
            >

                <option value="">
                    Alege tren
                </option>

                {trenuri.map((tren) => (

                    <option
                        key={tren.id}
                        value={tren.id}
                    >
                        {tren.numarTren}
                    </option>

                ))}

            </select>

            <button onClick={veziRezervari}>
                Vezi rezervari
            </button>

            <div>

                {rezervari.map((rezervare) => (

                    <div
                        key={rezervare.id}
                        className="list-item"
                    >

                        {rezervare.emailClient}
                        {" - "}
                        {rezervare.numarBilete}
                        {" bilete"}

                    </div>

                ))}

            </div>

        </div>
    );
}

export default RezervariTren;