<template>
  <div>
    <p>여기는</p>
    <project-read-server :readServer2="readServer2" />
  </div>
</template>
<script>
import ProjectReadServer from "@/components/ProjectReadServer.vue";
//import { mapActions, mapState } from "vuex";
import axios from "axios";

export default {
  name: "ProjectReadServerPage2",
  props: {
    readServer2: {
      type: Object,
      required: true,
    },
    hostName: {
      type: String,
      required: true,
    },
  },
  components: { ProjectReadServer },

  async mounted() {
    await this.getServerData();
  },
  methods: {
    getServerData() {
      axios
        .get(
          `http://localhost:7777/project/checkServer2/${this.readServer2.hostName}`
        )
        .then(() => {})
        .catch(() => {
          alert("유효한 이름을 적어주시기 바랍니다.");
        });
    },
  },
};
</script>
<style scoped></style>
