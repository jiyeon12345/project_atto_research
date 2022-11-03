<template>
  <div>
    <h2>수정하기</h2>
    <project-modify
      :readServer2="readServer2"
      @isDuplicatedHostName="isDuplicatedHostName"
      @isDuplicatedIp="isDuplicatedIp"
      @modifyData="modifyData"
    />
  </div>
</template>
<script>
import ProjectModify from "@/components/ProjectModify.vue";
import axios from "axios";

export default {
  components: { ProjectModify },
  name: "ProjectModifyPage",
  props: {
    readServer2: {
      type: Object,
      required: true,
    },
    hostName: {
      type: String,
      required: true,
    },
  },
  methods: {
    isDuplicatedHostName(payload) {
      let hostName = payload;

      axios
        .get(`http://localhost:7777/project/checkHostName/${hostName}`)
        .then((res) => {
          if (res.data == true) {
            alert("중복된 이름입니다.");
          } else alert("사용 가능한 이름입니다.");
        })
        .catch(() => {
          alert("조회 실패");
        });
    },
    isDuplicatedIp(payload) {
      let ip = payload;

      axios
        .get(`http://localhost:7777/project/checkIp/${ip}`)
        .then((res) => {
          if (res.data == true) {
            alert("중복된 ip 입니다.");
          } else alert("사용 가능한 ip입니다.");
        })
        .catch(() => {
          alert("조회 실패");
        });
    },
    modifyData(payload) {
      const { hostName, ip } = payload;
      let hostNo = this.readServer2.hostNo;
      //let hostName = h
      axios
        .put(`http://localhost:7777/project/modify`, { hostNo, hostName, ip })
        .then((res) => {
          if (res.data == 0) {
            alert("수정을 완료했습니다.");
            return this.$router.push({
              name: "ProjectReadServerPage2",
              params: { hostName },
            });
          }
          if (res.data == 1) {
            alert("중복검사를 다시 해 주시기 바랍니다.");
          }
        })
        .catch(() => {
          alert("등록에 실패하였습니다.");
        });
    },
  },
};
</script>
<style scoped></style>
