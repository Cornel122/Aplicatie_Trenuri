import { useEffect, useState } from "react";
import api from "../api";

function IntarziereTren() {

    const [trenuri, setTrenuri] = useState([]);

    const [trenId, setTrenId] = useState("");

    const [minute, setMinute] = useState("");

    const [mesaj, setMesaj] = useState("");

    useEffect(() => {
        incarcaTrenuri();
    }, []);

    const incarcaTrenuri = async () => {

        const response = await api.get("/trenuri");

        setTrenuri(response.data);
    };

    const adaugaIntarziere = async () => {

        const response =
            await api.put(
                `/admin/trenuri/${trenId}/intarziere?minute=${minute}`
            );

        setMesaj(response.data);
    };

    return (

        <div className="card">

            <h2>Intarziere tren</h2>

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
                    </option>

                ))}

            </select>

            <button onClick={incarcaTrenuri}>
                Refresh trenuri
            </button>

            <input
                placeholder="Minute intarziere"
                value={minute}
                onChange={(e) => setMinute(e.target.value)}
            />

            <button onClick={adaugaIntarziere}>
                Salveaza intarziere
            </button>

            <p className="message">
                {mesaj}
            </p>

        </div>
    );
}

export default IntarziereTren;