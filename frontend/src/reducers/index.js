import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import goalReducer from "./goalReducer";

/* combineReducers = meeting place for all our reducers */
export default combineReducers({
  errors: errorReducer,
  goal: goalReducer,
});
