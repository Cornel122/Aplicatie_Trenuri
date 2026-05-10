import { useState } from "react";
import api from "../api";

function Admin() {

    const [numarTren, setNumarTren] = useState("");
    const [capacitate, setCapacitate] = useState("");
    const [mesaj, setMesaj] = useState("");

    const adaugaTren = async () => {

        const response = await api.post("/admin/trenuri", {
            numarTren,
            capacitate,
            intarziere: 0
        });

        setMesaj("Tren adaugat");
    };

    return (
        <div className="card">
            <h2>Admin</h2>

            <input
                placeholder="Numar tren"
                onChange={(e) => setNumarTren(e.target.value)}
            />

            <input
                placeholder="Capacitate"
                onChange={(e) => setCapacitate(e.target.value)}
            />

            <button onClick={adaugaTren}>Adauga Tren</button>

            <div className="result">{mesaj}</div>
        </div>
    );
}

export default Admin;