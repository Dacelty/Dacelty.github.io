import axios from "axios";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";

const Create = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [darkmodeText, setDarkModeText] = useState("");

  useEffect(() => {
    const dmCheck = localStorage.getItem('darkmode')
    if (dmCheck === "true"){
      setDarkModeText("text-light")
    } else if (dmCheck === "false"){
      setDarkModeText("")
    }
},[])


  const history = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("handle được triển khai");
    axios
      .post("https://63607b3daf66cc87dc14b3dd.mockapi.io/reactcrud-no-backend", {
        name: name,
        email: email,
      })
      .then(() => {
        history("/read");
      });
  };

  return (
    <>
      <div className={`d-flex justify-content-between m-2 ${darkmodeText}`}>
        <h2>Create</h2>
        <Link to="/read">
          <button className="btn btn-primary">Show Data</button>
        </Link>
      </div>
      <form>
        <div className="mb-3">
          <label className={`form-label ${darkmodeText}`}>Name</label>
          <input
            type="text"
            className="form-control"
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className={`form-label ${darkmodeText}`}>Email address</label>
          <input
            type="email"
            className="form-control"
            aria-describedby="emailHelp"
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <button
          type="submit"
          className="btn btn-primary"
          onClick={handleSubmit}
        >
          Submit
        </button>
      </form>
    </>
  );
};

export default Create;