import { useState } from "react";
import api from "../api";

function LoginPage({ dupaLogin }) {

    const [modSignup, setModSignup] = useState(false);

    const [nume, setNume] = useState("");
    const [parola, setParola] = useState("");

    const [mesaj, setMesaj] = useState("");

    const login = async () => {

        try {

            const response = await api.post("/auth/login", {
                nume,
                parola
            });

            if (response.data === "Login reusit") {

                const userResponse =
                    await api.get(`/auth/utilizator/${nume}`);

                dupaLogin(userResponse.data);

            } else {
                setMesaj(response.data);
            }

        } catch (e) {
            setMesaj("Eroare la login");
        }
    };

    const signup = async () => {

        try {

            const response = await api.post("/auth/signup", {
                nume,
                parola,
                rol: "CLIENT"
            });

            setMesaj(response.data);
            setModSignup(false);

        } catch (e) {
            setMesaj("Eroare la signup");
        }
    };

    return (
        <div className="page-center">

            <div className="auth-card">

                <h1>Aplicatie Trenuri</h1>

                {!modSignup && <h2>Login</h2>}
                {modSignup && <h2>Signup</h2>}

                <input
                    placeholder="Nume"
                    value={nume}
                    onChange={(e) => setNume(e.target.value)}
                />

                <input
                    placeholder="Parola"
                    type="password"
                    value={parola}
                    onChange={(e) => setParola(e.target.value)}
                />

                {!modSignup &&
                    <button onClick={login}>
                        Login
                    </button>
                }

                {modSignup &&
                    <button onClick={signup}>
                        Creeaza cont
                    </button>
                }

                {!modSignup &&
                    <button
                        className="secondary"
                        onClick={() => setModSignup(true)}
                    >
                        Nu ai cont? Signup
                    </button>
                }

                {modSignup &&
                    <button
                        className="secondary"
                        onClick={() => setModSignup(false)}
                    >
                        Ai deja cont? Login
                    </button>
                }

                <p className="message">{mesaj}</p>

            </div>

        </div>
    );
}

export default LoginPage;