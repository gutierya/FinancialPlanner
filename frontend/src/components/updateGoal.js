import React, { Component } from "react";
import Navbar from "../Navbar";
import { Link } from "react-router-dom";
import { getGoal, createGoal } from "../actions/projectActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classNames from "classnames";
class updateGoal extends Component {
  //set state
  constructor() {
    super();
    this.state = {
      id: "",
      goalName: "",
      goalDescription: "",
      StartDate: "",
      goalPrice: "",
      goalWeekly: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  /* component recieves props from backend/reducer*/
  componentWillReceiveProps(nextProps) {
    const { id, goalName, goalDescription, StartDate, goalPrice, goalWeekly } =
      nextProps.goal;

    this.setState({
      id,
      goalName,
      goalDescription,
      StartDate,
      goalPrice,
      goalWeekly,
    });
  }

  /* lifecyle hook */
  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getGoal(id, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const updateGoal = {
      id: this.state.id,
      goalName: this.state.goalName,
      goalDescription: this.state.goalDescription,
      StartDate: this.state.StartDate,
      goalPrice: this.state.goalPrice,
      goalWeekly: this.state.goalWeekly,
    };
    this.props.createGoal(updateGoal, this.props.history);
  }

  render() {
    return (
      <div>
        <Navbar />

        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update Financial Goal</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Goal ID"
                    name="id"
                    value={this.state.id}
                    disabled
                  />
                </div>

                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Goal Name"
                    name="goalName"
                    value={this.state.goalName}
                    onChange={this.onChange}
                  />
                </div>

                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Goal Description"
                    name="goalDescription" /*holds a brief description of what the goal is for */
                    value={this.state.goalDescription}
                    onChange={this.onChange}
                  ></textarea>
                </div>

                <h6>Start Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="StartDate" /* initializes start date of saving for goal */
                    value={this.state.StartDate}
                    onChange={this.onChange}
                  />
                </div>

                <div className="form-group">
                  <input
                    type="number"
                    min="0.00"
                    step="0.01"
                    className="form-control form-control-lg"
                    placeholder="Goal Target Amount $ "
                    name="goalPrice" /* holds the price tag of the goal */
                    value={this.state.goalPrice}
                    onChange={this.onChange}
                  ></input>
                </div>

                <div className="form-group">
                  <input
                    type="number"
                    min="0.00"
                    step="0.01"
                    className="form-control form-control-lg"
                    placeholder="Goal Weekly Deposit Amount $ "
                    name="goalWeekly" /* holds how much they will pay each week */
                    value={this.state.goalWeekly}
                    onChange={this.onChange}
                  ></input>
                </div>

                <React.Fragment>
                  <Link to="/Goalview" className="btn btn-primary">
                    Submit
                  </Link>
                </React.Fragment>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

updateGoal.propTypes = {
  getGoal: PropTypes.func.isRequired,
  createGoal: PropTypes.func.isRequired,
  goal: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  goal: state.goal.goal,
});

export default connect(mapStateToProps, { getGoal, createGoal })(updateGoal);
