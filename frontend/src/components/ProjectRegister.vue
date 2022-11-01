<template>
  <div class="registerForm">
    <h2>등록하기</h2>

    <v-container>
      <v-row style="padding: 20px 0 0 100px">
        <v-text-field
          flat
          v-model="hostName"
          type="text"
          dense
          required
          placeholder="이름 입력"
        />
        <v-btn @click="isDuplicatedHostName">중복검사</v-btn>
      </v-row>
      <v-row style="padding: 20px 0 0 100px">
        <v-text-field
          flat
          v-model="ip"
          type="text"
          dense
          required
          placeholder="ip 입력"
        />
        <v-btn @click="isDuplicatedIp">중복검사</v-btn>
      </v-row>
    </v-container>
    <br />
    <v-btn @click="submitData">등록하기</v-btn>
    <v-btn @click="goToMainPage">뒤로가기</v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectRegister",
  data() {
    return {
      hostName: "",
      ip: "",
    };
  },
  methods: {
    isDuplicatedHostName() {
      this.$emit("isDuplicatedHostName", this.hostName);
    },
    isDuplicatedIp() {
      this.$emit("isDuplicatedIp", this.ip);
    },
    submitData() {
      const { hostName, ip } = this;
      this.$emit("submitData", { hostName, ip });
    },
    goToMainPage() {
      this.$router.push({ name: "ProjectMain" });
    },
  },
};
</script>
<style scoped>
.registerForm {
  display: grid;
  place-items: center;
}
</style>
