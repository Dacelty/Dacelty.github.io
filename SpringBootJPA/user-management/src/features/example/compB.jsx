import React, {useState, useEffect} from "react";
import {useLocation} from 'react-router-dom';

 function ComponentB() {

    const [userList, setuserList] = useState([])
    const location = useLocation();
   
    function getUserList() {
        setuserList(location.state.jsonName)
        localStorage.setItem('currentList2', JSON.stringify(userList));
    }

    return (
        <a className="btn btn-warning" onClick={getUserList}>
        Tạo user
        </a>
    )
}

export default ComponentB;