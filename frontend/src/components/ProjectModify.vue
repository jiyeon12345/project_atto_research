<template>
  <div>
    <div>
      <label for="">이름 : </label>
      <span>
        <input type="text" v-model="modiHostName" style="width: 200px" />
      </span>
      <span><v-btn @click="isDuplicatedHostName">중복검사</v-btn></span>
    </div>
    <div>
      <label for="">i p : </label>
      <span>
        <input type="text" v-model="modiIp" style="width: 200px" />
      </span>
      <span><v-btn @click="isDuplicatedIp">중복검사</v-btn></span>
    </div>
    <div>
      <p>alive 상태 : {{ readServer2.alive }}</p>
      <p>alive 실행 일자 : {{ readServer2.lastAliveDate }}</p>
    </div>
    <v-btn @click="modifyData">수정하기</v-btn>
    <v-btn @click="goToBackPage">취소하기</v-btn>
  </div>
</template>
<script>
export default {
  name: "ProjectModify",
  props: {
    readServer2: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      modiHostName: this.readServer2.hostName,
      modiIp: this.readServer2.ip,
    };
  },
  created() {
    this.modiHostName = this.readServer2.hostName;
    this.modiIp = this.readServer2.ip;
  },
  methods: {
    isDuplicatedHostName() {
      this.$emit("isDuplicatedHostName", this.modiHostName);
    },
    isDuplicatedIp() {
      this.$emit("isDuplicatedIp", this.modiIp);
    },
    modifyData() {
      let hostName = this.modiHostName;
      let ip = this.modiIp;
      //const { hostName, ip } = this;
      this.$emit("modifyData", { hostName, ip });
    },
    goToBackPage() {
      this.$router.push({
        name: "ProjectReadServerPage2",
        params: { hostName: this.readServer2.hostName },
      });
    },
  },
};
</script>
<style scoped>
input {
  outline: 2px solid #000000;
}
button {
  margin: 5px;
}
</style>
