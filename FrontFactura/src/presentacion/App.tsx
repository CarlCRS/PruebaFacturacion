import "../App.css"
import { Route, Routes } from "react-router-dom"
import Login from "./paginas/Login"
import Register from "./paginas/Register"
import Home from "./paginas/Home"

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/registro" element={<Register />} />
      <Route path="/home" element={<Home />} />
    </Routes>
  )
}

export default App
