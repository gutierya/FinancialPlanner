import logo from "./logo.svg";
import React, { Component } from "react";
import Contact from "./Contact";
import Home from "./Home";
import Toolbar from "@material-ui/core/Toolbar";
import TypoGraphy from "@material-ui/core/Typography";
import Navbar from "./Navbar";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Dashboard from "./components/GoalView";
import GoalView from "./components/GoalView";
import "bootstrap/dist/css/bootstrap.min.css";
import AddGoal from "./components/AddGoal";
import SignIn from "./SignIn";
import WhoAreWe from "./WhoAreWe";

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/" exact={true} component={Home} />
          <Route path="/Contact" exact={true} component={Contact} />
          <Route path="/Goalview" exact={true} component={GoalView} />
          <Route path="/addGoal" exact={true} component={AddGoal} />
          <Route path="/signin" exact={true} component={SignIn} />
          <Route path="/whoarewe" exact={true} component={WhoAreWe} />
        </Switch>
      </Router>
    );
  }
}

export default App;
