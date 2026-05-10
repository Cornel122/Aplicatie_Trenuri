import { useEffect, useState } from "react";
import api from "../api";

function RutaCrud() {

    const [rute, setRute] = useState([]);

    const [trenuri, setTrenuri] = useState([]);

    const [statii, setStatii] = useState([]);

    const [rutaId, setRutaId] = useState("");

    const [trenId, setTrenId] = useState("");

    const [statiePlecareId, setStatiePlecareId] = useState("");

    const [statieSosireId, setStatieSosireId] = useState("");

    const [oraPlecare, setOraPlecare] = useState("");

    const [oraSosire, setOraSosire] = useState("");

    const [mesaj, setMesaj] = useState("");

    useEffect(() => {
        incarcaDate();
    }, []);

    const incarcaDate = async () => {

        const trenuriResponse =
            await api.get("/trenuri");

        const statiiResponse =
            await api.get("/statii");

        const ruteResponse =
            await api.get("/admin/rute");

        setTrenuri(trenuriResponse.data);

        setStatii(statiiResponse.data);

        setRute(ruteResponse.data);
    };

    const corpRuta = () => ({

        tren: {
            id: trenId
        },

        statiePlecare: {
            id: statiePlecareId
        },

        statieSosire: {
            id: statieSosireId
        },

        oraPlecare,

        oraSosire
    });

    const adaugaRuta = async () => {

        await api.post(
            "/admin/rute",
            corpRuta()
        );

        setMesaj("Ruta adaugata");

        incarcaDate();
    };

    const modificaRuta = async () => {

        await api.put(
            `/admin/rute/${rutaId}`,
            corpRuta()
        );

        setMesaj("Ruta modificata");

        incarcaDate();
    };

    const stergeRuta = async () => {

        await api.delete(`/admin/rute/${rutaId}`);

        setMesaj("Ruta stearsa");

        incarcaDate();
    };

    return (

        <div className="card">

            <h2>Administrare rute</h2>

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

            <button onClick={incarcaDate}>
                Refresh date
            </button>

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

            <input
                placeholder="Ora plecare"
                value={oraPlecare}
                onChange={(e) => setOraPlecare(e.target.value)}
            />

            <input
                placeholder="Ora sosire"
                value={oraSosire}
                onChange={(e) => setOraSosire(e.target.value)}
            />

            <button onClick={adaugaRuta}>
                Adauga
            </button>

            <button onClick={modificaRuta}>
                Modifica
            </button>

            <button onClick={stergeRuta}>
                Sterge
            </button>

            <p className="message">
                {mesaj}
            </p>

        </div>
    );
}

export default RutaCrud;