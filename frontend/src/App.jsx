import { useState } from "react";

import LoginPage from "./pages/LoginPage";
import ClientPage from "./pages/ClientPage";
import AdminPage from "./pages/AdminPage";

function App() {

    const [pagina, setPagina] = useState("login");
    const [utilizator, setUtilizator] = useState(null);

    const dupaLogin = (user) => {

        setUtilizator(user);

        if (user.rol === "ADMIN") {
            setPagina("admin");
        } else {
            setPagina("client");
        }
    };

    const logout = () => {
        setUtilizator(null);
        setPagina("login");
    };

    if (pagina === "login") {
        return <LoginPage dupaLogin={dupaLogin} />;
    }

    if (pagina === "client") {
        return (
            <ClientPage
                utilizator={utilizator}
                logout={logout}
            />
        );
    }

    if (pagina === "admin") {
        return (
            <AdminPage
                utilizator={utilizator}
                logout={logout}
            />
        );
    }
}

export default App;