import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Create from "./Components/Create";
import Read from "./Components/Read";
import Update from "./Components/Update";
import 'bootstrap/dist/css/bootstrap.css';
import React, { useState } from "react";

function App() {
  const [darkmodeBG, setDarkModeBG] = useState("");
  return (
    <div className={`.container-xl py-4 px-5 h-100 ${darkmodeBG}`}>
      <div className="form-check form-switch">
        <input
          className="form-check-input"
          type="checkbox"
          onClick={() => {
            if (darkmodeBG === "bg-dark") {
              setDarkModeBG("");
              localStorage.setItem("darkmode","false")
            }
            else {
              setDarkModeBG("bg-dark");
              localStorage.setItem("darkmode","true")
            }
          }}
        />
      </div>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<Create />}></Route>
          <Route path="/read" element={<Read />}></Route>
          <Route path="/update" element={<Update />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;