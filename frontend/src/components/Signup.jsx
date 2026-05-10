import { useState } from "react";
import api from "../api";

function Signup() {

    const [nume, setNume] = useState("");
    const [parola, setParola] = useState("");
    const [mesaj, setMesaj] = useState("");

    const signup = async () => {

        const response = await api.post("/auth/signup", {
            nume,
            parola
        });

        setMesaj(response.data);
    };

    return (
        <div className="card">
            <h2>Signup</h2>

            <input
                placeholder="Nume"
                onChange={(e) => setNume(e.target.value)}
            />

            <input
                placeholder="Parola"
                type="password"
                onChange={(e) => setParola(e.target.value)}
            />

            <button onClick={signup}>Signup</button>

            <div className="result">{mesaj}</div>
        </div>
    );
}

export default Signup;