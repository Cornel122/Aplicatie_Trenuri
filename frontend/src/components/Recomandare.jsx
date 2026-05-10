import { useEffect, useState } from "react";
import api from "../api";

function Recomandare() {

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

    const recomandare = async () => {

        const response =
            await api.post("/recomandare", {

                statiePlecareId,
                statieSosireId

            });

        setMesaj(response.data);
    };

    return (

        <div className="card">

            <h2>Recomandare inteligenta tren</h2>

            <select
                value={statiePlecareId}
                onChange={(e) =>
                    setStatiePlecareId(e.target.value)
                }
            >

                <option value="">
                    Statie plecare
                </option>

                {statii.map((statie) => (

                    <option
                        key={statie.id}
                        value={statie.id}
                    >
                        {statie.nume}
                    </option>

                ))}

            </select>

            <select
                value={statieSosireId}
                onChange={(e) =>
                    setStatieSosireId(e.target.value)
                }
            >

                <option value="">
                    Statie sosire
                </option>

                {statii.map((statie) => (

                    <option
                        key={statie.id}
                        value={statie.id}
                    >
                        {statie.nume}
                    </option>

                ))}

            </select>

            <button onClick={recomandare}>
                Recomanda tren
            </button>

            <pre className="message">
                {mesaj}
            </pre>

        </div>
    );
}

export default Recomandare;