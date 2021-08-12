import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

/* setting up initial state of app*/
const initialState = {};

/* creating middleware */
const middleware = [thunk];

/* setting up our store to configure it so it works with chrome*/
let store;

if (window.navigator.userAgent.includes("Chrome")) {
  /* passing an array of middle ware and pasting in redux dev tool extension*/
  store = createStore(
    rootReducer,
    initialState,
    compose(
      applyMiddleware(...middleware),
      window.__REDUX_DEVTOOLS_EXTENSION__ &&
        window.__REDUX_DEVTOOLS_EXTENSION__()
    )
  );
} else {
  /* for browsers that don't support chrome extension */
  store = createStore(
    rootReducer,
    initialState,
    compose(applyMiddleware(...middleware))
  );
}

export default store;
