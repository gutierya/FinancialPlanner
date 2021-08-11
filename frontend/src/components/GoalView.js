import React, { Component } from "react";
import CreateGoalButton from "./createGoalButton";
import GoalItem from "./GoalItem";
import Navbar from "../Navbar";

/*
class based component that takes props and use life cycle hooks for 
rendering using JSX
*/
class GoalView extends Component {
  render() {
    return (
      <div>
        <Navbar/>
        <div className="projects">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Goals Dash</h1>
                <br />
                <CreateGoalButton />
                <br />
                <hr />
                <GoalItem />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default GoalView;
