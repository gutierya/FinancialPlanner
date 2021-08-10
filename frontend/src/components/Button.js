import React, { Component } from "react";
import { Link } from "react-router-dom";

const Button = () => {
  return (
    <div>
      <React.Fragment>
        <Link to="/addGoal" classname="btn btn-warning">
          Create Financial Goal
        </Link>
        <br></br>
        <Link to="/addGoal" classname="btn btn-warning">
          Edit Financial Goal
        </Link>
        <br></br>
        <Link to="/addGoal" classname="btn btn-warning">
          Delete Financial Goal
        </Link>
      </React.Fragment>
    </div>
  );
};

export default Button;
