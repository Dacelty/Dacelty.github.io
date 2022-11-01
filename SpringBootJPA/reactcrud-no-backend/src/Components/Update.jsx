import axios from "axios";
import React, { useEffect, useState } from "react";

import { Link, useNavigate } from "react-router-dom";

const Update = () => {
  const [id, setId] = useState(0);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [darkmodeText, setDarkModeText] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    setId(localStorage.getItem("id"));
    setName(localStorage.getItem("name"));
    setEmail(localStorage.getItem("email"));
    
    const dmCheck = localStorage.getItem('darkmode')
    if (dmCheck === "true"){
      setDarkModeText("text-light")
    } else if (dmCheck === "false"){
      setDarkModeText("")
    }
  }, []);

  const handleUpdate = (e) => {
    e.preventDefault();
    console.log("Id : ", id);
    axios
      .put(`https://63607b3daf66cc87dc14b3dd.mockapi.io/reactcrud-no-backend/${id}`, {
        name: name,
        email: email,
      })
      .then(() => {
        navigate("/read");
      });
  };

  return (
    <>
      <h2 className={`mb-3 ${darkmodeText}`}>Update</h2>
      <form>
        <div className={`mb-3 ${darkmodeText}`}>
          <label className="form-label">Name</label>
          <input
            type="text"
            className="form-control"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        <div className={`mb-3 ${darkmodeText}`}>
          <label className="form-label">Email address</label>
          <input
            type="email"
            className="form-control"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <button
          type="submit"
          className="btn btn-primary mx-2"
          onClick={handleUpdate}
        >
          Update
        </button>
        <Link to="/read">
          <button className="btn btn-secondary mx-2"> Back </button>
        </Link>
      </form>
    </>
  );
};

export default Update;