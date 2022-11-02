import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Read = () => {
  const [data, setData] = useState([]);
  const [sTerm, setsTerm] = useState('')

  function getData() {
    axios
      .get("https://63607b3daf66cc87dc14b3dd.mockapi.io/reactcrud-no-backend")
      .then((res) => {
        setData(res.data);
      });
  }

  function handleDelete(id) {
    axios
      .delete(`https://63607b3daf66cc87dc14b3dd.mockapi.io/reactcrud-no-backend/${id}`)
      .then(() => {
        getData();
      });
  }

  const setToLocalStorage = (id, name, email) => {
    localStorage.setItem("id", id);
    localStorage.setItem("name", name);
    localStorage.setItem("email", email);
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <>

      <div className="d-flex justify-content-between m-2">
        <h2>Read</h2>
        <input
            type="text"
            id="search"
            className="form-control w-50"
            placeholder="Tìm kiếm user"
            onChange={event => {setsTerm(event.target.value)
        }}/>
        <Link to="/">
          <button className="btn btn-secondary">Create</button>
        </Link>
      </div>
      <table className={`table`}>
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        {data
        .filter((data) => {
            if (sTerm === ""){
                return data;
            } else if (data.name.toLowerCase().includes(sTerm.toLowerCase())){
                return data;
            }
                return null;
            })
        .map((user) => {
          return (
            <>
              <tbody>
                <tr>
                  <th scope="row">{user.id}</th>
                  <td>{user.name}</td>
                  <td>{user.email}</td>
                  <td>
                    <Link to="/update">
                      <button
                        className="btn btn-success"
                        onClick={() =>
                          setToLocalStorage(
                            user.id,
                            user.name,
                            user.email
                          )
                        }
                      >
                        Edit{" "}
                      </button>
                    </Link>
                  </td>
                  <td>
                    <button
                      className="btn btn-danger"
                      onClick={() => handleDelete(user.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              </tbody>
            </>
          );
        })}
      </table>
    </>
  );
};

export default Read;