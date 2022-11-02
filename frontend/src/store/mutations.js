import { FETCH_READ_SERVER2 } from "./mutation-types";
export default {
  [FETCH_READ_SERVER2](state, readServer2) {
    state.readServer2 = readServer2;
  },
};
