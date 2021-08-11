/* eslint-disable */
import React, { Component } from "react";
import Navbar from "../Navbar";
import { PropTypes } from "prop-types";
import { connect } from "react-redux";
import { createGoal } from "../actions/projectActions";
import classNames from "classnames";
class AddGoal extends Component {
  constructor() {
    super();

    this.state = {
      id: "",
      goalName: "",
      goalDescription: "",
      StartDate: "",
      goalPrice: "",
      goalWeekly: "",
      errors: {},
    };

    this.onChange =
      this.onChange.bind(
        this
      ); /*enables the onChange function to be called per input on form below. Its at constructor level so it works for all inputs.*/

    this.onSubmit =
      this.onSubmit.bind(
        this
      ); /*enables the onSubmit function to be called per form below. Its at constructor level so it works for all inputs when submitting*/
  }

  /* life cycle hook - will recieve props*/
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({
        errors: nextProps.errors,
      });
    }
  }

  onChange(e) {
    this.setState({
      [e.target.name]:
        e.target
          .value /* take whichever value and set it to the state aka values from the form */,
    });
  }

  onSubmit(e) {
    e.preventDefault(); /* this line prevents form from reloading back to initial state when we click 'submit' */
    const newGoal = {
      id: this.state.id,
      goalName: this.state.goalName,
      goalDescription: this.state.goalDescription,
      StartDate: this.state.StartDate,
      goalPrice: this.state.goalPrice,
      goalWeekly: this.state.goalWeekly,
    };

    this.props.createGoal(newGoal, this.props.history);

    /* this line is for debugging purposes to send goal object to postman
    console.log(
      newGoal
    ); 
    */
  }

  render() {
    const { errors } = this.state;

    return (
      <div>
        <Navbar />

        <h1>{errors.goalName}</h1>
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">
                Create / Edit Financial Goal
              </h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Goal ID"
                    name="iD"
                    value={this.state.id}
                    onChange={this.onChange}
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

                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

/* setting up prop type */
AddGoal.propTypes = {
  /* telling react the createGoal function is a reqyuired function */

  createGoal: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  errors: state.errors,
});

/* to help map our state to our props */
export default connect(mapStateToProps, { createGoal })(AddGoal);
