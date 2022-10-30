import './App.css';
import UserList from './features/user/UserList';
import UserAdd from './features/user/UserAdd';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CompA from "./features/example/compA"
import CompB from "./features/example/compB"



function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
{/*         <Route path="/" element={<CompA />} />
        <Route path="/componentB" element={<CompB />} /> */}
        <Route path="/" element={<UserList />} />
        <Route path="UserAdd" element={<UserAdd />} />
      </Routes>
    </BrowserRouter>

    </div>
  );
}

export default App;
