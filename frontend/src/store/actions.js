import axios from "axios";
import { FETCH_READ_SERVER2 } from "./mutation-types";

export default {
  fetchReadServer2({ commit }, hostName) {
    return axios
      .get(`http://localhost:7777/project/checkServer2/${hostName}`)
      .then((res) => {
        commit(FETCH_READ_SERVER2, res.data);
      });
  },
};
