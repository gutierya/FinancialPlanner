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
import { Provider } from "react-redux";
/* basically how we define the store we will use for our app */
import store from "./store";
import updateGoal from "./components/updateGoal";
class App extends Component {
  render() {
    return (
      /* provider tag takes a prop - a store  */
      <Provider store={store}>
        <Router>
          <Switch>
            <Route path="/" exact={true} component={Home} />
            <Route path="/Contact" exact={true} component={Contact} />
            <Route path="/goalview" exact={true} component={GoalView} />
            <Route path="/addGoal" exact={true} component={AddGoal} />
            <Route path="/updateGoal/:id" exact={true} component={updateGoal} />
            <Route path="/signin" exact={true} component={SignIn} />
            <Route path="/whoarewe" exact={true} component={WhoAreWe} />
          </Switch>
        </Router>
      </Provider>
    );
  }
}
export default App;
