import { GET_GOALS, GET_GOAL, DELETE_GOAL } from "../actions/Types";

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

    case DELETE_GOAL:
      return {
        ...state,
        goals: state.goals.filter((goal) => goal.id !== action.payload),
      };

    default:
      return state;
  }
}
