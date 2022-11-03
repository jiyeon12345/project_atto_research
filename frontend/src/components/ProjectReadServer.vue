<template>
  <div>
    <div>
      <p>이름 : {{ readServer2.hostName }}</p>
      <p>ip : {{ readServer2.ip }}</p>
      <p v-if="readServer2.alive == true">alive 상태 : on</p>
      <p v-else>alive 상태 : off</p>
      <p>alive 실행 일자 : {{ readServer2.lastAliveDate }}</p>
      <!-- <p>생성 일자 : {{ readServer2.createdDate }}</p>
      <p>수정 일자 : {{ readServer2.lastModifiedDate }}</p> -->
    </div>
    <v-btn @click="requestAlive">alive 실행 or 중지하기</v-btn>
    <v-btn @click="modifyData">수정하기</v-btn>
    <v-btn @click="deleteData">삭제하기</v-btn>
    <v-btn @click="goToBackPage">이전 페이지</v-btn>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "ProjectReadServer",
  props: {
    readServer2: {
      type: Object,
      required: true,
    },
  },
  methods: {
    goToBackPage() {
      this.$router.push({ name: "ProjectCheckAlivePage" });
    },
    requestAlive() {
      let hostName = this.readServer2.hostName;
      if (this.readServer2.alive == true)
        var result1 = confirm("alive 상태를 중지하겠습니까?");
      else if (this.readServer2.alive == false)
        var result = confirm("alive 상태를 실행하겠습니까?");

      if (result1 || result) {
        axios
          .put(`http://localhost:7777/project/requestServer/${hostName}`)
          .then(() => {
            alert("alive 상태를 변경했습니다.");
            this.$router.go();
          })
          .catch(() => {
            alert("유효한 이름을 적어주시기 바랍니다.");
          });
      }
    },
    modifyData() {
      this.$router.push({
        name: "ProjectModifyPage",
        params: {
          readServer2: this.readServer2,
          hostName: this.readServer2.hostName,
        },
      });
    },
    deleteData() {
      let hostNo = this.readServer2.hostNo;
      var result = confirm("해당 값을 삭제하시겠습니까?");
      if (result) {
        axios
          .delete(`http://localhost:7777/project/${hostNo}`)
          .then(() => {
            alert("삭제가 완료되었습니다.");
            this.$router.push({ name: "ProjectMain" });
          })
          .catch(() => {
            alert("삭제가 실패했습니다.");
          });
      }
    },
  },
};
</script>
<style scoped></style>
