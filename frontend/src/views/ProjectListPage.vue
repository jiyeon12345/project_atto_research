<template>
  <div>
    <h2>전체조회</h2>
    <project-list :serverList="serverList" />
  </div>
</template>
<script>
import ProjectList from "@/components/ProjectList.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "ProjectListPage",
  components: {
    ProjectList,
  },
  computed: {
    ...mapState(["serverList"]),
  },
  mounted() {
    this.fetchServerList();
    //this.fetchAliveList();
  },
  methods: {
    ...mapActions(["fetchServerList"]),
  },
};
</script>
<style lang=""></style>
