import logo from './logo.svg';
import React, { Component } from 'react';
import Contact from './Contact';
import Home from './Home';
import Toolbar from '@material-ui/core/Toolbar';
import TypoGraphy from '@material-ui/core/Typography'
import Navbar from './Navbar';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <WelcomeMessage />
        <a
          className="App-link"
          href="https://youtube.com"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  )
}
*/

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path = '/' exact = {true} component={Home}/>
          <Route path = '/Contact' exact={true} component = {Contact}/> 
        </Switch>
      </Router>
    )
  }
}

/* const App = () => {
	return (
		<div className="App">
			<Navbar />
      
		</div>
	);
}; */

export default App;
