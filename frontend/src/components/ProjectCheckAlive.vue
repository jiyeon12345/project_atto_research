<template>
  <div class="checkForm">
    <h2>회원 조회</h2>
    <v-text-field
      flat
      v-model="hostName"
      type="text"
      dense
      required
      placeholder="이름 입력"
    />
    <v-btn @click="submitData1">조회하기(버전1)</v-btn>
    <v-btn @click="submitData2">조회하기(버전2)</v-btn>
    <v-btn @click="goToMainPage">메인으로</v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectCheckAlive",
  data() {
    return {
      hostName: "",
    };
  },
  methods: {
    submitData1() {
      this.$emit("submitData1", this.hostName);
    },
    submitData2() {
      this.$emit("submitData2", this.hostName);
    },
    goToMainPage() {
      this.$router.push({ name: "ProjectMain" });
    },
  },
};
</script>
<style scoped>
.checkForm {
  display: grid;
  place-items: center;
}
button {
  margin: 3px;
}
</style>
