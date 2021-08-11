import { GET_GOALS, GET_GOAL } from "../actions/Types";

const initialState = {
  goals: [],
  goal: {},
};

// eslint-disable-next-line import/no-anonymous-default-export
export default function (state = initialState, action) {
  switch (action.type) {
    case GET_GOALS:
      return {
        ...state,
        goals: action.payload,
      };

    case GET_GOAL:
      return {
        ...state,
        goal: action.payload,
      };

    default:
      return state;
  }
}
