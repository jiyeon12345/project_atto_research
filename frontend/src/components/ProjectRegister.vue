<template lang="">
  <div class="registerForm">
    <h2>등록하기</h2>

    <v-text-field
      flat
      v-model="hostName"
      type="text"
      dense
      required
      placeholder="이름 입력"
    />
    <v-text-field
      flat
      v-model="ip"
      type="text"
      dense
      required
      placeholder="ip 입력"
    />
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
};
</script>
<style scoped>
.registerForm {
  display: grid;
  place-items: center;
}
input {
  width: 80%;
}
</style>
