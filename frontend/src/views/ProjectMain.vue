<template>
  <div class="main">
    <h1>메인 페이지</h1>
    <v-btn @click="register"> 회원 등록 </v-btn>
    <br />
    <v-btn @click="checkList"> 회원 조회 </v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectMain",
  methods: {
    register() {
      this.$router.push({ name: "ProjectRegisterPage" });
    },
    checkList() {
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
