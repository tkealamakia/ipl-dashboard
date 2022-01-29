import './App.css';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import {TeamPage} from "./pages/TeamPage";
import {MatchPage} from "./pages/MatchPage";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/team/:teamName" element={<TeamPage/>}>
          </Route>
          <Route path="/team/:teamName/matches/:year" element={<MatchPage/>}>
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
