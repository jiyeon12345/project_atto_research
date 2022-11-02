<template>
  <div>
    <p>readServer2.hostName : {{ readServer2.hostName }}</p>
    <v-btn @click="goToMainPage">메인으로</v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectReadServer",
  props: {
    readServer2: {
      type: Object,
      required: true,
    },
  },
  methods: {
    goToMainPage() {
      this.$router.push({ name: "ProjectMain" });
    },
  },
};
</script>
<style lang=""></style>
