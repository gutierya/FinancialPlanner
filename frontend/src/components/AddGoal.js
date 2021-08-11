import React, { Component } from "react";
import Navbar from "../Navbar";
import { Link } from "react-router-dom";

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

    console.log(
      newGoal
    ); /* this line is for debugging purposes to send goal object to postman*/
  }

  render() {
    return (
      <div>
        <Navbar />
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
export default AddGoal;
