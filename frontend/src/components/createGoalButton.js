import React, { Component } from "react";
import { Link } from "react-router-dom";

const CreateGoalButton = () => {
  return (
    <React.Fragment>
      <Link to="/addGoal" className="btn btn-primary">
        Create a Financial Goal
      </Link>
    </React.Fragment>
  );
};

export default CreateGoalButton;
