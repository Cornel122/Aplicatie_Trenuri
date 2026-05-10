import { useEffect, useState } from "react";
import api from "../api";

function Ruta() {

    const [statii, setStatii] = useState([]);

    const [statiePlecareId, setStatiePlecareId] = useState("");

    const [statieSosireId, setStatieSosireId] = useState("");

    const [mesaj, setMesaj] = useState("");

    useEffect(() => {
        incarcaStatii();
    }, []);

    const incarcaStatii = async () => {

        const response = await api.get("/statii");

        setStatii(response.data);
    };

    const cautaRuta = async () => {

        try {

            const response = await api.post("/rute/cauta", {

                statiePlecareId,
                statieSosireId

            });

            setMesaj(response.data);

        } catch (e) {

            setMesaj("Eroare la cautare ruta");
        }
    };

    return (

        <div className="card">

            <h2>Cautare ruta</h2>

            <select
                value={statiePlecareId}
                onChange={(e) => setStatiePlecareId(e.target.value)}
            >

                <option value="">
                    Statie plecare
                </option>

                {statii.map((statie) => (

                    <option key={statie.id} value={statie.id}>
                        {statie.nume}
                    </option>

                ))}

            </select>

            <select
                value={statieSosireId}
                onChange={(e) => setStatieSosireId(e.target.value)}
            >

                <option value="">
                    Statie sosire
                </option>

                {statii.map((statie) => (

                    <option key={statie.id} value={statie.id}>
                        {statie.nume}
                    </option>

                ))}

            </select>

            <button onClick={cautaRuta}>
                Cauta ruta
            </button>

            <pre className="message">
                {mesaj}
            </pre>

        </div>
    );
}

export default Ruta;