<template>
  <div>
    <project-check-alive
      @submitData1="submitData1"
      @submitData2="submitData2"
    />
  </div>
</template>
<script>
import ProjectCheckAlive from "@/components/ProjectCheckAlive.vue";
import axios from "axios";

export default {
  name: "ProjectCheckAlivePage",
  components: { ProjectCheckAlive },
  methods: {
    submitData1(payload) {
      let hostName = payload;

      axios
        .get(`http://localhost:7777/project/checkServer1/${hostName}`)
        .then(() => {
          this.$router.push({ name: "ProjectReadServerPage" });
        })
        .catch(() => {
          alert("유효한 이름을 적어주시기 바랍니다.");
        });
    },
    submitData2(payload) {
      let hostName = payload;

      axios
        .get(`http://localhost:7777/project/checkServer2/${hostName}`)
        .then(() => {
          this.$router.push({ name: "ProjectReadServerPage" });
        })
        .catch(() => {
          alert("유효한 이름을 적어주시기 바랍니다.");
        });
    },
  },
};
</script>
<style lang=""></style>
