<template>
  <div>
    <p>alive 상태 확인</p>
    <project-read-server :readServer2="readServer2" />
  </div>
</template>

<script>
import ProjectReadServer from "@/components/ProjectReadServer.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "ProjectReadServerPage2",
  props: {
    hostName: {
      type: String,
      required: true,
    },
  },
  components: { ProjectReadServer },
  computed: {
    ...mapState(["readServer2"]),
  },
  created() {
    this.fetchReadServer2(this.hostName).catch(() => {
      alert("게시물 요청 실패!");
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchReadServer2"]),
  },
};
</script>
<style scoped></style>
