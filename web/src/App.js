import './App.css';
import Dashboard from './Dashboard';
import Homepage from './Homepage';
import Login from './Login';
import { Route, Routes } from "react-router-dom";
import { useLocalState } from './util/useLocalStorage';
import PrivateRoute from './PrivateRoute';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [jwt, setJwt] = useLocalState("", "jwt");

  return (
    <Routes>
      <Route path="/dashboard" element={
        <PrivateRoute>
          <Dashboard />
        </PrivateRoute>
      } />
      <Route path="/login" element={<Login />} />
      <Route path="/" element={<Homepage />} />
    </Routes>
  );
}

export default App;
