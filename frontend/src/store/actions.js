import axios from "axios";
import {
  FETCH_READ_SERVER2,
  FETCH_ALIVE_LIST,
  FETCH_SERVER_LIST,
} from "./mutation-types";

export default {
  fetchReadServer2({ commit }, hostName) {
    return axios
      .get(`http://localhost:7777/project/checkServer2/${hostName}`)
      .then((res) => {
        commit(FETCH_READ_SERVER2, res.data);
      })
      .catch(() => {});
  },
  fetchAliveList({ commit }) {
    return axios
      .get(`http://localhost:7777/project/alive/list`)
      .then((res) => {
        commit(FETCH_ALIVE_LIST, res.data);
      })
      .catch(() => {});
  },
  fetchServerList({ commit }) {
    return axios
      .get(`http://localhost:7777/project/server/list`)
      .then((res) => {
        commit(FETCH_SERVER_LIST, res.data);
      })
      .catch(() => {});
  },
};
