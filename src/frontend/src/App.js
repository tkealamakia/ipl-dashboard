import './App.css';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import {TeamPage} from "./pages/TeamPage";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/team/:teamName" element={<TeamPage/>}>
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
