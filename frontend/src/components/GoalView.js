/* eslint-disable */

import React, { Component } from "react";
import CreateGoalButton from "./createGoalButton";
import GoalItem from "./GoalItem";
import { connect } from "react-redux";
import { getGoals } from "../actions/projectActions";
import { Dashboard } from "@material-ui/icons";
import PropTypes from "prop-types";
/*
class based component that takes props and use life cycle hooks for 
rendering using JSX
*/
class GoalView extends Component {
  /* mounting when loading the component*/
  componentDidMount() {
    this.props.getGoals();
  }

  render() {
    const { goals } = this.props.goal;

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Goals Dash</h1>
              <br />
              <CreateGoalButton />

              <br />
              <hr />

              {goals.map((goal) => (
                <GoalItem key={goal.id} goal={goal} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  goal: PropTypes.object.isRequired,
  getGoals: PropTypes.func.isRequired,
};

const mapStateToProps = (state) => ({
  goal: state.goal,
});

export default connect(mapStateToProps, { getGoals })(GoalView);
