import { GET_ERRORS } from "../actions/Types";

/* with errors we always have an initial state */
const initialState = {};

export default function (state = initialState, action) {
  switch (action.type) {
    case GET_ERRORS:
      return action.payload;
    default:
      /* return state as is*/
      return state;
  }
}
