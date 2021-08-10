import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootReducer from "../reducers";

/* setting up initial state of app*/
const initState = {};

/* creating middleware */
const middleware = [thunk];

/* setting up our store to configure it so it works with chrome*/
let store;

export default store;
