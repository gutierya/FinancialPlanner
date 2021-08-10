import React, { Component } from "react";
import Button from "./Button";
class GoalItem extends Component {
  render() {
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2"></div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>Goal: </h3>
              <p>"My goal is ..." </p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <Button />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default GoalItem;
