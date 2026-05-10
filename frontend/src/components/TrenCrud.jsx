import { useEffect, useState } from "react";
import api from "../api";

function TrenCrud() {

    const [trenuri, setTrenuri] = useState([]);

    const [id, setId] = useState("");

    const [numarTren, setNumarTren] = useState("");
    const [capacitate, setCapacitate] = useState("");
    const [intarziere, setIntarziere] = useState(0);

    const [mesaj, setMesaj] = useState("");

    useEffect(() => {
        incarcaTrenuri();
    }, []);

    const incarcaTrenuri = async () => {

        const response = await api.get("/trenuri");

        setTrenuri(response.data);
    };

    const adaugaTren = async () => {

        await api.post("/admin/trenuri", {

            numarTren,
            capacitate,
            intarziere

        });

        setMesaj("Tren adaugat");

        incarcaTrenuri();
    };

    const modificaTren = async () => {

        await api.put(`/admin/trenuri/${id}`, {

            numarTren,
            capacitate,
            intarziere

        });

        setMesaj("Tren modificat");

        incarcaTrenuri();
    };

    const stergeTren = async () => {

        await api.delete(`/admin/trenuri/${id}`);

        setMesaj("Tren sters");

        incarcaTrenuri();
    };

    const selecteazaTren = (tren) => {

        setId(tren.id);

        setNumarTren(tren.numarTren);

        setCapacitate(tren.capacitate);

        setIntarziere(tren.intarziere);
    };

    return (

        <div className="card">

            <h2>Administrare trenuri</h2>

            <button onClick={incarcaTrenuri}>
                Refresh trenuri
            </button>

            <input
                placeholder="Numar tren"
                value={numarTren}
                onChange={(e) => setNumarTren(e.target.value)}
            />

            <input
                placeholder="Capacitate"
                value={capacitate}
                onChange={(e) => setCapacitate(e.target.value)}
            />

            <input
                placeholder="Intarziere"
                value={intarziere}
                onChange={(e) => setIntarziere(e.target.value)}
            />

            <button onClick={adaugaTren}>
                Adauga
            </button>

            <button onClick={modificaTren}>
                Modifica
            </button>

            <button onClick={stergeTren}>
                Sterge
            </button>

            <p className="message">
                {mesaj}
            </p>

            <h3>Trenuri existente</h3>

            {trenuri.map((tren) => (

                <div
                    key={tren.id}
                    className="list-item"
                    onClick={() => selecteazaTren(tren)}
                >

                    {tren.numarTren}
                    {" "}-
                    {" "}capacitate {tren.capacitate}
                    {" "}-
                    {" "}intarziere {tren.intarziere}

                </div>

            ))}

        </div>
    );
}

export default TrenCrud;