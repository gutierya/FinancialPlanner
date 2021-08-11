import axios from "axios"; /* library import to talk to the backend*/
import { GET_ERRORS, GET_GOAL, GET_GOALS, DELETE_GOAL } from "./Types";

/* history param - allows us to redirect the once form is submited */

export const createGoal = (goal, history) => async (dispatch) => {
  try {
    /* might have to delete the 1 in url ... */
    const res = await axios.post(
      "http://localhost:8080/goalview",
      goal
    ); /* this route takes a valid goal object */
    history.push("/goalview/"); /* redirect to the new goal */
  } catch (err) {
    dispatch({ type: GET_ERRORS, payload: {} });
  }
};

export const getGoals = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8080/goalview/all");
  dispatch({ type: GET_GOALS, payload: res.data });
};

export const getGoal = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`http://localhost:8080/goalview/${id}`);
    dispatch({
      type: GET_GOAL,
      payload: res.data,
    });
  } catch (error) {
    history.push("/goalview");
  }
};

export const deleteGoal = (id) => async (dispatch) => {
  if (window.confirm("Are you sure you want to delete this goal?")) {
    await axios.delete(`http://localhost:8080/goalview/${id}`);
    dispatch({
      type: DELETE_GOAL,
      payload: id,
    });
  }
};
