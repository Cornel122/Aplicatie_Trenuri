import { useState } from "react";
import api from "../api";

function Login() {

    const [nume, setNume] = useState("");
    const [parola, setParola] = useState("");
    const [mesaj, setMesaj] = useState("");

    const login = async () => {

        const response = await api.post("/auth/login", {
            nume,
            parola
        });

        setMesaj(response.data);
    };

    return (
        <div className="card">
            <h2>Login</h2>

            <input
                placeholder="Nume"
                onChange={(e) => setNume(e.target.value)}
            />

            <input
                placeholder="Parola"
                type="password"
                onChange={(e) => setParola(e.target.value)}
            />

            <button onClick={login}>Login</button>

            <div className="result">{mesaj}</div>
        </div>
    );
}

export default Login;