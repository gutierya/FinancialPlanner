import React, { Component } from "react";
import GoalItem from "./GoalItem";
import Button from "./Button";
/*
class based component that takes props and use life cycle hooks for 
rendering using JSX
*/
class GoalView extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Goals</h1>
              <br />
              <br />
              <hr />

              <GoalItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default GoalView;
