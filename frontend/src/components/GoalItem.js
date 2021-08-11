import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteGoal } from "../actions/projectActions";
class GoalItem extends Component {
  onDeleteClick = (id) => {
    this.props.deleteGoal(id);
  };

  render() {
    const { goal } = this.props;

    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2"></div>

            <div className="col-lg-6 col-md-4 col-8">
              <p>{goal.id}</p>
              <h3>{goal.goalName}</h3>
              <p>{goal.goalDescription} </p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <div>
                <React.Fragment>
                  <button type="button" class="btn btn-primary">
                    <Link to="/addGoal">Financial Goal</Link>
                  </button>
                  <br></br>
                  <br></br>
                  <button type="button" class="btn btn-primary">
                    <Link to={`/updateGoal/${goal.id}`}>
                      Edit Financial Goal
                    </Link>
                  </button>
                  <br></br>
                  <br></br>
                  <button
                    type="button"
                    class="btn btn-primary"
                    onClick={this.onDeleteClick.bind(this, goal.id)}
                  >
                    <Link to="/deleteGoal">Delete Financial Goal</Link>
                  </button>
                </React.Fragment>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

GoalItem.propTypes = {
  deleteGoal: PropTypes.func.isRequired,
};

export default connect(null, { deleteGoal })(GoalItem);
