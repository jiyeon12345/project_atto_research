import {
  FETCH_READ_SERVER2,
  FETCH_ALIVE_LIST,
  FETCH_SERVER_LIST,
} from "./mutation-types";
export default {
  [FETCH_READ_SERVER2](state, readServer2) {
    state.readServer2 = readServer2;
  },
  [FETCH_ALIVE_LIST](state, aliveList) {
    state.aliveList = aliveList;
  },
  [FETCH_SERVER_LIST](state, serverList) {
    state.serverList = serverList;
  },
};
