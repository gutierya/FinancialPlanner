import axios from "axios"; /* library import to talk to the backend*/
import { GET_ERRORS, GET_GOALS } from "./Types";

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
    dispatch({ type: GET_ERRORS, payload: err.response.data });
  }
};

// export const createGoal = function(goal, history){ async dispatch => {

// try {
//     const res = await axios.post("http://localhost:8080/goalview/1", goal); /* this route takes a valid goal object */
//     history.push("/goalview/"); /* redirect to the new goal */
// } catch (err ) {
//     dispatch({ type: GET_ERRORS, payload: err.response.data })
// }
// }
// }
export const getGoals = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8080/goalview/all");
  dispatch({ type: GET_GOALS, payload: res.data });
};
