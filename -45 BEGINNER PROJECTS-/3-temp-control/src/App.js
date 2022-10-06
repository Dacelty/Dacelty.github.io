import React, {useState} from 'react';

const App = () => {
  const [temperatureValue, settemperatureValue] = useState(10);

  const [temperatureColor, settemperatureColor] = useState("cold");

  const increaseTemp = () => {
    if (temperatureValue===30) return;
    const newTemp = temperatureValue + 1;
    if (newTemp >= 15){
      settemperatureColor('hot');
    }
    settemperatureValue(newTemp);
  }

  const decTemp = () => {
    if (temperatureValue ===0) return;
    const newTemp = temperatureValue -1;
    if (newTemp < 15){
      settemperatureColor('cold');
    }
    settemperatureValue(newTemp);
  }

  return (
    <div className="app-container">
      <div className="temperature-display-container">
        <div className={`temperature-display ${temperatureColor}`}>{temperatureValue} C</div>
      </div> 
      <div className='button-container'>
        <button onClick={()=> increaseTemp()}>+</button>
        <button onClick={()=> decTemp()}>-</button>
      </div>
    </div>
  )
}

export default App;