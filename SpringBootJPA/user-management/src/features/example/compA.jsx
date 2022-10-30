import React from "react";
import {Link, useNavigate} from 'react-router-dom';
import jsonName from "../json/MOCK_DATA.json"

function ComponentA(props) {

    const navigate = useNavigate();

    const toComponentB=()=>{
    navigate('/componentB',{state:{jsonName}});
    }

    return (
        <>
        <div> <a onClick={()=>{toComponentB()}}>Component B</a></div>
        </>
    );
}

export default ComponentA;