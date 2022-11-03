<template>
  <div class="main">
    <h1>메인 페이지</h1>
    <v-btn @click="register"> 회원 등록 </v-btn>
    <br />
    <v-btn @click="searchName"> 회원 조회 </v-btn>
    <br />
    <v-btn @click="totalList"> 전체 조회 </v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectMain",
  methods: {
    register() {
      this.$router.push({ name: "ProjectRegisterPage" });
    },
    searchName() {
      this.$router.push({ name: "ProjectCheckAlivePage" });
    },
    totalList() {
      this.$router.push({ name: "ProjectListPage" });
    },
  },
};
</script>
<style scoped>
.main {
  display: grid;
  place-items: center;
}

a {
  text-decoration: none;
  color: black;
}
</style>
