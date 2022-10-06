import React, {useState} from 'react';
import './App.css';
import jsonName from "./MOCK_DATA.json";

function App() {
  const [sTerm, setsTerm] = useState('')
  return (
    <div className="App">
      <input 
        type="text" 
        placeholder = "Search.." 
        onChange={event => {setsTerm(event.target.value)
        }}/>
{/*       {jsonName.map((val, key) => {
        return (
          <div className='user' key={key}>
            <p>{val.first_name}</p>
          </div>
        )
      })} */}
      {jsonName.filter((val) => {
        if (sTerm == ""){
          return val
        } else if (val.first_name.toLowerCase().includes(sTerm.toLowerCase())){
          return val
        }
      }).map((val, key) => {
        return (
          <div className='user' key={key}>
            <p>{val.first_name}</p>
          </div>
        )
      })}
    </div>
  );
}

export default App;
